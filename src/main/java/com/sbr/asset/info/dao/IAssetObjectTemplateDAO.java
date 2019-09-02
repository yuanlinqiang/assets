package com.sbr.asset.info.dao;

import com.sbr.asset.info.model.AssetObject;
import com.sbr.asset.util.DataTypeConversionUtil;
import com.sbr.asset.util.StringBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 描述：同步数据到服务器
* @author YLQ
* @date 2019-07-26 17:38:21
*/
@Repository
public class IAssetObjectTemplateDAO {

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    /**
     * <p>新增资产同步到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     * @param assetObject
     */
    public Boolean  save(AssetObject assetObject){
        String sqlAdd = "insert into asset_object (uuid,id,type_id,type_code,code,os,os_version,firmware,name,ip,mask,mac,hostname,contact,location,manufacturer,warranty_from,warranty_to,sn,is_virtual,host_on,area,status,description,created,modified,confidentiality,integrity,availability,value,grade,levelcode,third_code,third_type) " +
                "value" +
                " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object args[] = {
                assetObject.getId(),
                DataTypeConversionUtil.UUIDTransID(assetObject.getId()),
                DataTypeConversionUtil.UUIDTransID( assetObject.getTypeId()),
                assetObject.getTypeCode(),
                assetObject.getCode(),
                assetObject.getOs(),
                assetObject.getOsVersion(),
                assetObject.getFirmware(),
                assetObject.getAssetName(),
                assetObject.getIp(),
                assetObject.getMask(),
                assetObject.getMac(),
                assetObject.getHostname(),
                assetObject.getContact(),
                assetObject.getLocation(),
                assetObject.getManufacturer(),
                DataTypeConversionUtil.DataFormatMillises(assetObject.getWarrantyFrom()),
                DataTypeConversionUtil.DataFormatMillises(assetObject.getWarrantyTo()),
                assetObject.getSn(),
                assetObject.getIsVirtual(),
//                assetObject.getHostOn(),
                0,
                assetObject.getArea(),
                assetObject.getStatus(),
                assetObject.getDescription(),
                DataTypeConversionUtil.DataFormatMillises(assetObject.getCreated()),
                DataTypeConversionUtil.DataFormatMillises(assetObject.getModified()),
                assetObject.getConfidentiality(),
                assetObject.getIntegrity(),
                assetObject.getAvailability(),
                assetObject.getValue(),
                assetObject.getGrade(),
                StringBuilderUtil.levelCodeTrans(assetObject.getLevelcode()),
                assetObject.getThirdCode(),
                assetObject.getThirdType()
        };
        int update = jdbcTemplate.update(sqlAdd, args);
        if(update == 1) return   true;
        return   false;
    }

    /**
     * <p>修改标签组同步到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean  update(AssetObject assetObject){

        Boolean id = existAssetObjectData("id", DataTypeConversionUtil.UUIDTransID(assetObject.getId()));  //判断服务器是否存在该数据
        if (id == false) return true; //如果服务器数据库不存在该数据，直接返回

        String updateSql = "update asset_object  set  uuid= ?,type_id= ?,type_code= ?,code= ?,os= ?,os_version= ?,firmware= ?,name= ?,ip= ?," +
                "mask= ?,mac= ?,hostname= ?,contact= ?,location= ?,manufacturer= ?,warranty_from= ?,warranty_to= ?,sn= ?,is_virtual= ?," +
                "host_on= ?,area= ?,status= ?,description= ?,created= ? ,modified= ?,confidentiality= ?,integrity= ?,availability= ?,value= ?  " +
                ",grade= ?,levelcode= ?,third_code= ?,third_type= ?  where id = ?";
        Object args[] = {
                assetObject.getId(),
                DataTypeConversionUtil.UUIDTransID( assetObject.getTypeId()),
                assetObject.getTypeCode(),
                assetObject.getCode(),
                assetObject.getOs(),
                assetObject.getOsVersion(),
                assetObject.getFirmware(),
                assetObject.getAssetName(),
                assetObject.getIp(),
                assetObject.getMask(),
                assetObject.getMac(),
                assetObject.getHostname(),
                assetObject.getContact(),
                assetObject.getLocation(),
                assetObject.getManufacturer(),
                DataTypeConversionUtil.DataFormatMillises(assetObject.getWarrantyFrom()),
                DataTypeConversionUtil.DataFormatMillises(assetObject.getWarrantyTo()),
                assetObject.getSn(),
                assetObject.getIsVirtual(),
//                assetObject.getHostOn(),
                0,
                assetObject.getArea(),
                assetObject.getStatus(),
                assetObject.getDescription(),
                DataTypeConversionUtil.DataFormatMillises(assetObject.getCreated()),
                DataTypeConversionUtil.DataFormatMillises(assetObject.getModified()),
                assetObject.getConfidentiality(),
                assetObject.getIntegrity(),
                assetObject.getAvailability(),
                assetObject.getValue(),
                assetObject.getGrade(),
                StringBuilderUtil.levelCodeTrans(assetObject.getLevelcode()),
                assetObject.getThirdCode(),
                assetObject.getThirdType(),
                DataTypeConversionUtil.UUIDTransID(assetObject.getId()),
        };
        int update = jdbcTemplate.update(updateSql, args);
        if(update == 1) return   true;
        return   false;
    }

    /**
     * <p>资产组的资产同步到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean   deleteAssetObjectsById(List<String> assetIds){
        String deleteSql = "delete from asset_object where id = ?";
        for (String assetID:assetIds) {
           Boolean result = existAssetObjectData("id", DataTypeConversionUtil.UUIDTransID(assetID));  //判断服务器是否存在该数据
            if (result == false) continue; //如果服务器数据库不存在该数据，执行下次循环
            jdbcTemplate.update(deleteSql, DataTypeConversionUtil.UUIDTransID(assetID));
        }
        return   true;
    }

    /**
     * <p>查询资产表是否存在某个值</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean   existAssetObjectData(String cloumnName,Object cloumnValue){
        String selectSql = "select count(*) from asset_object where " +cloumnName+ " = "+cloumnValue;
        int count = jdbcTemplate.queryForObject(selectSql, Integer.class);
        if(count > 0) return   true;
        return   false;
    }
    
    
    
}