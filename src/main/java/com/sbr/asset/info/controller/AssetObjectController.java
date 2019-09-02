package com.sbr.asset.info.controller;


import com.sbr.asset.group.model.AssetGroup;
import com.sbr.asset.group.service.IAssetGroupService;
import com.sbr.asset.info.model.AssetObject;
import com.sbr.asset.info.service.IAssetObjectService;
import com.sbr.asset.preparation.model.AssetObjectPre;
import com.sbr.asset.preparation.service.IAssetObjectPreService;
import com.sbr.asset.util.DataTypeConversionUtil;
import com.sbr.common.finder.Filter;
import com.sbr.common.finder.Finder;
import com.sbr.common.finder.FinderFactory;
import com.sbr.platform.service.RedisService;
import com.sbr.springboot.controller.BaseController;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.ObjectUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;


/**
* 描述：资产对象
* @author YLQ 2019-07-26 14:23:01
*/
@RestController
@RequestMapping("/sp-assets/api")
public class AssetObjectController extends BaseController{

    @Autowired
    private IAssetObjectService assetObjectService;
    @Autowired
    private IAssetGroupService assetGroupService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private IAssetObjectPreService assetObjectPreService;


    /**
     * <p>分页查询所有</p>
     * @param req
     * @return  资产集合AssetObject
     * @author YLQ 2019-07-26 14:23:01
     */
    @GetMapping(value="/v1/assetobject")
    public List<AssetObject> findAllAssetInfo(HttpServletRequest req) {
        Finder finder = FinderFactory.createFromRequestParamAccordingEntityClass(req, AssetObject.class);
        Filter ff = new Filter();
        List<Filter> filterList = finder.getFilterList();
        String assertGroupID = "";
        if (filterList.size() > 1) { //点击资产组树id，获取分组节点层级，查询分页数据
            for (int i = 0; i < filterList.size(); i++) {
                if (filterList.get(i).getName().equals("id")) {
                    assertGroupID = (String) filterList.get(i).getValue();
                    AssetGroup assetGroup = assetGroupService.findById(String.valueOf(assertGroupID));
                    finder.getFilterList().remove(i);//移除ID过滤条件
                    Filter.OperateType llk = Filter.OperateType.getOperateType("LLK"); //模糊查询类型
                    ff.setName("levelcode");
                    ff.setValue(assetGroup == null ? null : assetGroup.getLevelcode());
                    ff.setOperateType(llk);
                    filterList.add(ff);
                }
            }
            finder.setFilterList(filterList);
        }
        List<AssetObject> byFinder = assetObjectService.findByFinder(finder);
        return assetObjectService.findByFinder(finder);
    }


    /**
    * <p>根据Id 查询</p>
    * @param id 主键
    * @return 实体AssetObject
    * @author YLQ 2019-07-26 14:23:01
    */
    @GetMapping(value = "/v1/assetobject/{id}")
    public AssetObject findById(@PathVariable("id") String id) {
        return assetObjectService.findById(id);
    }

    /**
    * <p>新增资产对象表</p>
    * @param assetObject 需要新增的数据
    * @return 实体
    * @author YLQ 2019-07-26 14:23:01
    */
    @PostMapping(value = "/v1/assetobject")
    public AssetObject create(@RequestBody AssetObject assetObject) {
        return assetObjectService.create(assetObject);
    }

    /**
    * <p>删除资产对象表</p>
    * @param  ids 资产ID
    * @author YLQ 2019-07-26 14:23:01
    */
    @DeleteMapping(value = "/v1/assetobject/{ids}")
    public void deleteById(@PathVariable("ids") String[] ids) throws Exception {
        List<String> assetIds = Arrays.asList(ids);
    	assetObjectService.deleteByListIds(assetIds);
    }

    /**
    * <p>更新资产对象表</p>
    * @param id 主键
    * @return 实体
    * @author YLQ 2019-07-26 14:23:01
    */
    @PatchMapping(value = "/v1/assetobject/{id}")
    public AssetObject update (@PathVariable("id") String id,@RequestBody AssetObject assetObject) throws Exception {
        return assetObjectService.patchUpdate(assetObject);
    }

    /**
    * <p>根据资产组查询</p>
    * @param groupId 资产组id
    * @return 实体
    * @author YLQ 2019-06-12 14:23:01
    */
    @ApiOperation(value = "根据资产组查询资产", notes = "根据资产组查询资产")
    @GetMapping("/v1/assetobject/group/{group_id}")
    public List<AssetObject> findByGroupId(@PathVariable("group_id") String groupId) {
        AssetGroup assetgroup = assetGroupService.findById(groupId);
        if(assetgroup == null ) return   null;
        List<AssetObject> assetList = assetObjectService.findByLevelCode(assetgroup.getLevelcode());
        return assetList;
    }

    /**
     * <p>移动资产组</p>
     * @param ids
     * @return 实体
     * @author YLQ 2019-05-15 14:23:01
     */
    @GetMapping(value = "/v1/assetobject/moveAssetGroups/{ids}")
    public List<AssetObject> getMoveAssetGroup( @PathVariable("ids") String[] ids) {
        return assetObjectService.getMoveAssetGroup(ids);
    }

    /**
     * <p>导出资产组</p>
     * @param assetGroupID
     * @return 实体
     * @author YLQ 2019-05-15 14:23:01
     */
    @RequestMapping(value = "/v1/assetobject/exportExcel/{assetGroupID}", method = RequestMethod.GET)
    @ResponseBody
    public void excelDownload( HttpServletResponse response,@PathVariable("assetGroupID")  String assetGroupID) throws IOException {
        String levelCode = assetGroupService.findById(assetGroupID).getLevelcode();
        List<AssetObject>  assetObjects  = assetObjectService.findByLevelCode(levelCode);
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("分组资产");
        HSSFRow row = null;
        row = sheet.createRow(0);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("编号");
        row.createCell(1).setCellValue("资产类型ID");
        row.createCell(2).setCellValue("资产类型Code");
        row.createCell(3).setCellValue("资产型号");
        row.createCell(4).setCellValue("操作系统");
        row.createCell(5).setCellValue("操作系统版本");
        row.createCell(6).setCellValue("固件");
        row.createCell(7).setCellValue("资产名称");
        row.createCell(8).setCellValue("资产主IP");
        row.createCell(9).setCellValue("资产管理IP或主IP默认网关");
        row.createCell(10).setCellValue("资产管理IP接口的MAC地址");
        row.createCell(11).setCellValue("资产主机名");
        row.createCell(12).setCellValue("资产联系人");
        row.createCell(13).setCellValue("资产地理位置");
        row.createCell(14).setCellValue("资产生产厂商");
        row.createCell(15).setCellValue("资产质保开始日期");
        row.createCell(16).setCellValue("资产质保结束日期");
        row.createCell(17).setCellValue("资产序列号");
        row.createCell(18).setCellValue("资产形态：0物理设备/1虚拟设备");
        row.createCell(19).setCellValue("当资产为数据库、中间件、虚拟资产时，宿主主机资产ID");
        row.createCell(20).setCellValue("资产所属区域/单位");
        row.createCell(21).setCellValue("资产状态：1在线，0下线");
        row.createCell(22).setCellValue("资产描述");
        row.createCell(23).setCellValue("资产创建时间");
        row.createCell(24).setCellValue("资产最后修改时间");
        row.createCell(25).setCellValue("资产机密性 低：0，中等：2，高：3，极高：4");
        row.createCell(26).setCellValue("资产完整性 低：0，中等：2，高：3，极高：4");
        row.createCell(27).setCellValue("资产可用性 低：0，中等：2，高：3，极高：4");
        row.createCell(28).setCellValue("资产价值");
        row.createCell(29).setCellValue("资产等保级别");
        row.createCell(30).setCellValue("资产所属资产组级次码");
        row.createCell(31).setCellValue("当资产从第三方同步时记录的第三方资产编号");
        row.createCell(32).setCellValue("预备资产来源类型：0.录入或导入 1.事件 2.漏洞 3.自动发现 4.流量");

        for (int i = 0; i < assetObjects.size(); i++) {
            row = sheet.createRow(i + 1);
            AssetObject assetObject = assetObjects.get(i);
            row.createCell(0).setCellValue(assetObject.getId());
            row.createCell(1).setCellValue(assetObject.getTypeId());
            row.createCell(2).setCellValue(assetObject.getTypeCode());
            row.createCell(3).setCellValue(assetObject.getCode());
            row.createCell(4).setCellValue(assetObject.getOs());
            row.createCell(5).setCellValue(assetObject.getOsVersion());
            row.createCell(6).setCellValue(assetObject.getFirmware());
            row.createCell(7).setCellValue(assetObject.getAssetName());
            row.createCell(8).setCellValue(assetObject.getIp());
            row.createCell(9).setCellValue(assetObject.getMask());
            row.createCell(10).setCellValue(assetObject.getMac());
            row.createCell(11).setCellValue(assetObject.getHostname());
            row.createCell(12).setCellValue(assetObject.getContact());
            row.createCell(13).setCellValue(assetObject.getLocation());
            row.createCell(14).setCellValue(assetObject.getManufacturer());
            row.createCell(15).setCellValue(assetObject.getWarrantyFrom()+"");
            row.createCell(16).setCellValue(assetObject.getWarrantyTo()+"");
            row.createCell(17).setCellValue(assetObject.getSn());
            row.createCell(18).setCellValue(assetObject.getIsVirtual()+ "");
            row.createCell(19).setCellValue(assetObject.getHostOn() + "");
            row.createCell(20).setCellValue(assetObject.getArea());
            row.createCell(21).setCellValue(assetObject.getStatus()+ "");
            row.createCell(22).setCellValue(assetObject.getDescription());
            row.createCell(23).setCellValue(assetObject.getCreated()+"");
            row.createCell(24).setCellValue(assetObject.getModified()+"");
            row.createCell(25).setCellValue(assetObject.getConfidentiality()+ "");
            row.createCell(26).setCellValue(assetObject.getIntegrity()+ "");
            row.createCell(27).setCellValue(assetObject.getAvailability()+ "");
            row.createCell(28).setCellValue(assetObject.getValue()+ "");
            row.createCell(29).setCellValue(assetObject.getGrade()+ "");
            row.createCell(30).setCellValue(assetObject.getLevelcode());
            row.createCell(31).setCellValue(assetObject.getThirdCode());
            row.createCell(32).setCellValue(assetObject.getThirdType()+ "");
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=user.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }

    /**
     * <p>导入资产组</p>
     * @return 实体
     * @author YLQ 2019-05-15 14:23:01
     */
    @RequestMapping(value = "/v1/assetobject/importExcel/{assetGroupID}",method = RequestMethod.POST)
    public void importExcel(@RequestParam("file") MultipartFile file ,@PathVariable("assetGroupID") String assetGroupID) throws IOException {
        //先把数据库中的数据查询出来
        try {
           assetObjectService.importExcel( file,assetGroupID);
        } catch (Exception e) {
            //导表发生异常的时候
            throw e;
        }
    }

}