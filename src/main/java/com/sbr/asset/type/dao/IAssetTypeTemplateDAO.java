package com.sbr.asset.type.dao;

import com.sbr.asset.type.model.AssetType;
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
public class IAssetTypeTemplateDAO {



    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    /**
     * <p>新增到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean  save(AssetType assetType){
        String sqlAdd = "insert into asset_type (uuid,id,parent_id,name,code,icon,iconClass,levelcode,is_builtin,is_cvs,is_common,display_index,created,modified,description) " +
                "value" +
                " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object args[] = {
                assetType.getId(),
                DataTypeConversionUtil.UUIDTransID(assetType.getId()),
                assetType.getParent()== null? 0: DataTypeConversionUtil.UUIDTransID(assetType.getParent().getId()),
                assetType.getAssetTypeName(),
                assetType.getCode(),
                assetType.getIcon(),
                assetType.getIconClass(),
                StringBuilderUtil.levelCodeTrans(assetType.getLevelcode()),
                assetType.getIsBuiltin(),
                assetType.getIsCvs(),
                assetType.getIsCommon(),
                assetType.getDisplayIndex(),
                DataTypeConversionUtil.DataFormatMillises(assetType.getCreated()),
                DataTypeConversionUtil.DataFormatMillises(assetType.getModified()),
                assetType.getDescription(),
        };
        int update = jdbcTemplate.update(sqlAdd, args);
        if(update == 1) return   true;
        return   false;
    }

    /**
     * <p>修改到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean  update(AssetType assetType){
        Boolean result= existData("id", DataTypeConversionUtil.UUIDTransID(assetType.getId()));  //判断服务器是否存在该数据
        if (result == false) return true; //如果服务器数据库不存在该数据，直接返回
        String updateSql = "update asset_type  set  uuid= ?,parent_id= ?,name= ?,code= ?,icon= ?,iconClass= ?,levelcode= ?,is_builtin= ?,is_cvs= ?,is_common= ?,display_index= ?,created= ?,modified= ?,description= ?  where id = ?";
        Object args[] = {
                assetType.getId(),
                assetType.getParent()== null? 0: DataTypeConversionUtil.UUIDTransID(assetType.getParent().getId()),
                assetType.getAssetTypeName(),
                assetType.getCode(),
                assetType.getIcon(),
                assetType.getIconClass(),
                StringBuilderUtil.levelCodeTrans(assetType.getLevelcode()),
                assetType.getIsBuiltin(),
                assetType.getIsCvs(),
                assetType.getIsCommon(),
                assetType.getDisplayIndex(),
                DataTypeConversionUtil.DataFormatMillises(assetType.getCreated()),
                DataTypeConversionUtil.DataFormatMillises(assetType.getModified()),
                assetType.getDescription(),
                DataTypeConversionUtil.UUIDTransID(assetType.getId())
        };
        int update = jdbcTemplate.update(updateSql, args);
        if(update == 1) return   true;
        return   false;
    }

    /**
     * <p>刪除到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean   delete(List<String> typeIds){

        String deleteSql = "delete from asset_type where id = ?";
        for (int i = 0; i < typeIds.size(); i++) {
            Integer typeID =  DataTypeConversionUtil.UUIDTransID(typeIds.get(i));
            Boolean result= existData("id", typeID);  //判断服务器是否存在该数据
            if (result == false) continue;
            jdbcTemplate.update(deleteSql, typeID);
        }
        return   true;
    }

    /**
     * <p>查询是否存在某个值</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean   existData(String cloumnName,Object cloumnValue){
        String selectSql = "select count(*) from asset_type where  " +cloumnName+ " = "+cloumnValue;
        int count = jdbcTemplate.queryForObject(selectSql, Integer.class);
        if(count > 0) return   true;
        return   false;
    }

}