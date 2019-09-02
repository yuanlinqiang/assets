package com.sbr.asset.info.service.impl;

import com.sbr.asset.group.model.AssetGroup;
import com.sbr.asset.info.dao.IAssetObjectTemplateDAO;
import com.sbr.asset.preparation.dao.IAssetObjectPreDAO;

import com.sbr.asset.preparation.model.AssetObjectPre;
import com.sbr.asset.tag.dao.IAssetTagObjectRtlDAO;
import com.sbr.asset.tag.dao.IAssetTagTemplateDAO;
import com.sbr.asset.tag.model.AssetTagObjectRlt;
import com.sbr.asset.type.dao.IAssetTypeDAO;
import com.sbr.asset.type.model.AssetType;
import com.sbr.asset.util.DataTypeConversionUtil;
import com.sbr.common.util.StringUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import com.sbr.asset.group.dao.IAssetGroupDAO;
import com.sbr.asset.info.dao.IAssetObjectDAO;
import com.sbr.asset.info.model.AssetObject;
import com.sbr.asset.info.service.IAssetObjectService;
import com.sbr.asset.util.StringBuilderUtil;
import com.sbr.common.finder.Finder;
import com.sbr.common.page.Page;
import com.sbr.common.util.ClassUtil;
import com.sbr.platform.service.RedisService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


/**
* 描述：资产对象表 服务实现层
* @author YLQ
* @date 2019-07-26 14:23:01
*/
//标记为Service类
@Service
public class AssetObjectServiceImpl implements IAssetObjectService {


    @Autowired
    private IAssetObjectDAO assetObjectDAO;
    @Autowired
    private IAssetGroupDAO assetGroupDAO;
    @Autowired
    private IAssetTypeDAO assetTypeDAO;
    @Autowired
    private IAssetTagObjectRtlDAO assetTagObjectRtlDAO;
    @Autowired
    private IAssetObjectPreDAO  assetObjectPreDAO ;
    @Autowired
    private  IAssetObjectTemplateDAO  assetObjectTemplateDAO ;
    @Autowired
    private IAssetTagTemplateDAO assetTagTemplateDAO ;

    @Autowired
    private RedisService redisService;

    private static final String  redisKey = "asset_";



    @Override
    public List<AssetObject> findByFinder(Finder finder) {
        List<AssetObject> assetObject = assetObjectDAO.findByFinder(finder);
      //  List<AssetTagObjectRlt> assetTagObjectRlt = assetTagObjectRtlDAO.findAll();
        for (int i = 0; i <assetObject.size() ; i++) {
            List<String> tagsByAssetID = assetTagObjectRtlDAO.findTagsByAssetID(assetObject.get(i).getId()); //tagIDs
            String[] tags = tagsByAssetID.toArray(new String[tagsByAssetID.size()]);
            if(tagsByAssetID.size() > 0) assetObject.get(i).setAssetTagID(tags);
        }
        return assetObject;
    }

    @Override
    public Page<AssetObject> findByFinderAndPage(Finder finder, Page<AssetObject> page) {
        return assetObjectDAO.findByFinderAndPage(finder, page);
    }

    @Override
    public AssetObject findById(String id){
        return 	assetObjectDAO.findOne(id);
    }

    @Override
    public void deleteByListIds(List<String> ids) {
        assetObjectDAO.deleteAssetObjectByIds(ids);
        assetObjectTemplateDAO.deleteAssetObjectsById(ids);
        for (String assetId:ids) {  //批量删除   后期做一定的修改操作
            assetTagObjectRtlDAO.deleteTagsByAssetID(assetId);
        }
        assetTagTemplateDAO.deleteAssetTagByAssetId(ids);
    }

    @Override
    @Transactional
    public AssetObject create(AssetObject assetObject) {
        String id = UUID.randomUUID().toString();
        String levelcode = assetGroupDAO.findOne(assetObject.getLevelcode()).getLevelcode();
        assetObject.setId(id);
        assetObject.setLevelcode(StringBuilderUtil.stringBuilder(levelcode, id));//资产的分组
        assetObject.setCreated(new Date());
        assetObject.setTypeCode(assetTypeDAO.findOne(assetObject.getTypeId()).getCode());
        if (assetObject.getAssetTagID().length > 0) { //如果资产选择了标签，添加到资产标签中间表
            AssetTagObjectRlt assetTagObjectRlt = new AssetTagObjectRlt();
            List<String> tagIds = Arrays.asList(assetObject.getAssetTagID());
            for (String tagId : tagIds) {
                assetTagObjectRlt.setId(UUID.randomUUID().toString());
                assetTagObjectRlt.setAssetId(id);
                assetTagObjectRlt.setTagId(tagId);
                assetTagObjectRtlDAO.save(assetTagObjectRlt);
                assetTagTemplateDAO.saveAssetTags(assetTagObjectRlt);  //将资产对应的标签同步到服务器
            }
        }
        AssetObject save = assetObjectDAO.save(assetObject);
        assetObjectTemplateDAO.save(save);  //将资产同步到服务器
        return save;
    }



    @Override
    @Transactional
    public AssetObject patchUpdate(AssetObject assetObject) {
        if (assetObject.getAssetTagID().length > 0) { //如果资产选择了标签，添加到资产标签中间表
            assetTagObjectRtlDAO.deleteTagsByAssetID(assetObject.getId());
            assetTagTemplateDAO.deleteAssetTagByAssetId(assetObject.getId());
            AssetTagObjectRlt assetTagObjectRlt = new AssetTagObjectRlt();
            List<String> tagIds = Arrays.asList(assetObject.getAssetTagID());
            for (String tagId : tagIds) {
                assetTagObjectRlt.setId(UUID.randomUUID().toString());
                assetTagObjectRlt.setAssetId(assetObject.getId());
                assetTagObjectRlt.setTagId(tagId);
                assetTagObjectRtlDAO.save(assetTagObjectRlt);
                assetTagTemplateDAO.saveAssetTags(assetTagObjectRlt);  //将资产对应的标签同步到服务器
            }
        }
        AssetObject entity = findById(assetObject.getId());
        ClassUtil.merge(entity, assetObject);
        AssetObject save = assetObjectDAO.save(entity);
        save.setModified(new Date());
        assetObjectTemplateDAO.update(save);  //将资产同步到服务器
        return save;
    }

    //存取查过的数据
    @Override
    public List<AssetObject> findByLevelCode(String levelCode) {
            List<AssetObject> assetList = assetObjectDAO.findByLevelCode(levelCode);
            // 写入缓存
            return assetList;
    }

    @Override
    public List<AssetObject> findAllAsset() {
//        boolean hasKey =  redisService.exists(redisKey);
//        if (hasKey) {
//            Object o = redisService.get(redisKey);
//            return null;
//        } else {
//            List<AssetObject> assetObject = assetObjectDAO.findAll();
//            // 写入缓存
//            redisService.set(redisKey,assetObject);
//            return assetObject;
//        }
        List<AssetObject> assetObject = assetObjectDAO.findAll();
        return assetObject;
    }

    @Override
    @Transactional
    public List<AssetObject> getMoveAssetGroup(String[] moveAssetIds) {

        String levelCode = assetGroupDAO.findOne(moveAssetIds[moveAssetIds.length-1]).getLevelcode();  //取最后一位的移动的组ID
        List<AssetObject>assetObjects = new ArrayList<AssetObject>();
        for (int i = 0; i < moveAssetIds.length-1; i++) {
            AssetObject  entity = assetObjectDAO.findOne(moveAssetIds[i]);
            String newLevelCode = StringBuilderUtil.stringBuilder(levelCode,moveAssetIds[i]);
            entity.setLevelcode(newLevelCode);
            assetObjectTemplateDAO.update(entity);  //将移动资产同步到服务器
            assetObjectDAO.save(entity);
        }
        return assetObjects;
    }


    @Override
    @Transactional
    public void importExcel(MultipartFile file,String assetGroupID) throws IOException {
        String Levelcode = assetGroupDAO.findOne(assetGroupID).getLevelcode();
        InputStream is = file.getInputStream();
        Workbook wb = null;
        //确定版本
        String originalFilename = file.getOriginalFilename();
        boolean isExcel2003 = file.getOriginalFilename().endsWith("xls")?true:false;
        List<Map<String, Object>> returnMap;
        try {
            if(isExcel2003(file.getOriginalFilename())){
                wb = new HSSFWorkbook(is); //创建2003版本Excel工作簿对象
            }else if (isExcel2007(file.getOriginalFilename())){
                wb = new XSSFWorkbook(is); //创建2007版本Excel工作簿对象
            }else { //目前只存在上面两种格式
                System.out.println("未知版本的Excel !!!,");
            }
            Sheet sheet = wb.getSheetAt(0); //获取第1个工作表
            for(int i=1;i<=sheet.getLastRowNum();i++){//循环Excel文件的i=1行开始

//                AssetObjectPre assetObject = new AssetObjectPre();
                AssetObject assetObject = new AssetObject();
                String id = UUID.randomUUID().toString();
                Row row = sheet.getRow(i); //获取第i行

                //查询资产对应的标签ID
                List<String> tagsByAssetID = assetTagObjectRtlDAO.findTagsByAssetID(row.getCell(0).getStringCellValue());
                if(tagsByAssetID.size()>0){
                    for (String tagID:tagsByAssetID) {
                        AssetTagObjectRlt assetTagObjectRtl =  new    AssetTagObjectRlt();
                        assetTagObjectRtl.setId(UUID.randomUUID().toString());
                        assetTagObjectRtl.setTagId(tagID);
                        assetTagObjectRtl.setAssetId(id);
                        assetTagObjectRtlDAO.save(assetTagObjectRtl);
                    }
                }

                assetObject.setId(id);
                Cell cell = row.getCell(1);
                assetObject.setTypeId(row.getCell(1)== null ? null:row.getCell(1).getStringCellValue());
                assetObject.setTypeCode(row.getCell(2)== null ? null:row.getCell(2).getStringCellValue());
                assetObject.setCode(row.getCell(3)== null ? null:row.getCell(3).getStringCellValue());
                assetObject.setOs(row.getCell(4)== null ? null:row.getCell(4).getStringCellValue());
                assetObject.setOsVersion(row.getCell(5)== null ? null:row.getCell(5).getStringCellValue());
                assetObject.setFirmware(row.getCell(6)== null ? null:row.getCell(6).getStringCellValue());
                assetObject.setAssetName(row.getCell(7)== null ? null:row.getCell(7).getStringCellValue());
                assetObject.setIp(row.getCell(8)== null ? null:row.getCell(8).getStringCellValue());
                assetObject.setMask(row.getCell(9)== null ? null:row.getCell(9).getStringCellValue());
                assetObject.setMac(row.getCell(10)== null ? null:row.getCell(10).getStringCellValue());
                assetObject.setHostname(row.getCell(11)== null ? null:row.getCell(11).getStringCellValue());
                assetObject.setContact(row.getCell(12)== null ? null:row.getCell(12).getStringCellValue());
                assetObject.setLocation(row.getCell(13)== null ? null:row.getCell(13).getStringCellValue());
                assetObject.setManufacturer(row.getCell(14)== null ? null:row.getCell(14).getStringCellValue());
                assetObject.setWarrantyFrom(DataTypeConversionUtil.StringFormatDate(row.getCell(15).getStringCellValue()));
                assetObject.setWarrantyTo(DataTypeConversionUtil.StringFormatDate(row.getCell(16).getStringCellValue()));
                assetObject.setSn(row.getCell(17)== null ? null:row.getCell(17).getStringCellValue());
                assetObject.setIsVirtual(row.getCell(18).getStringCellValue().equals("null") ? null:Integer.parseInt(row.getCell(18).getStringCellValue()));
                assetObject.setHostOn(row.getCell(19).getStringCellValue().equals("null") ? null:Integer.parseInt(row.getCell(19).getStringCellValue()));
                assetObject.setArea(row.getCell(20)== null ? null:row.getCell(20).getStringCellValue());
               // assetObject.setStatus(row.getCell(21).getStringCellValue().equals("null") ? null:Integer.parseInt(row.getCell(21).getStringCellValue()));
                assetObject.setStatus(1);
                assetObject.setDescription(row.getCell(22)== null ? null:row.getCell(22).getStringCellValue());
                assetObject.setCreated(DataTypeConversionUtil.StringFormatDate(row.getCell(23).getStringCellValue()));
                assetObject.setModified(DataTypeConversionUtil.StringFormatDate(row.getCell(24).getStringCellValue()));
                assetObject.setConfidentiality(row.getCell(25).getStringCellValue().equals("null") ? null:Integer.parseInt(row.getCell(25).getStringCellValue()));
                assetObject.setIntegrity(row.getCell(26).getStringCellValue().equals("null") ? null:Integer.parseInt(row.getCell(26).getStringCellValue()));
                assetObject.setAvailability(row.getCell(27).getStringCellValue().equals("null") ? null:Integer.parseInt(row.getCell(27).getStringCellValue()));
                assetObject.setValue(row.getCell(28).getStringCellValue().equals("null") ? null:Integer.parseInt(row.getCell(28).getStringCellValue()));
                assetObject.setGrade(row.getCell(29).getStringCellValue().equals("null") ? null:Integer.parseInt(row.getCell(29).getStringCellValue()));
                //assetObject.setLevelcode(row.getCell(30)== null ? null:row.getCell(30).getStringCellValue());
                assetObject.setLevelcode(StringBuilderUtil.stringBuilder(Levelcode,id));
                assetObject.setThirdCode(row.getCell(31)== null ? null:row.getCell(31).getStringCellValue());
                assetObject.setThirdType(row.getCell(32).getStringCellValue().equals("null") ? null:Integer.parseInt(row.getCell(29).getStringCellValue()));
                assetObjectDAO.save(assetObject);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            is.close();
        }
    }


    public static boolean isExcel2003(String filePath)
    {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String filePath)
    {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }



}