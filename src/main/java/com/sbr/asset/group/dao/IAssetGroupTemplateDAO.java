package com.sbr.asset.group.dao;

import com.sbr.asset.group.model.AssetGroup;
import com.sbr.asset.util.DataTypeConversionUtil;
import com.sbr.asset.util.StringBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
* 描述：同步数据到服务器
* @author YLQ
* @date 2019-07-26 17:38:21
*/
@Repository
public class IAssetGroupTemplateDAO{



    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    /**
     * <p>新增到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean  save(AssetGroup assetGroup){
        String sqlAdd = "insert into asset_group (id,parent_id,name,value,grade,levelcode,icon,iconClass,display_index,created,modified,description) " +
                "value" +
                " (?,?,?,?,?,?,?,?,?,?,?,?)";
        Object args[] = {
                DataTypeConversionUtil.UUIDTransID(assetGroup.getId()),
                DataTypeConversionUtil.UUIDTransID(assetGroup.getRootId()),
                assetGroup.getAssetGroupName(),
                assetGroup.getValue(),
                assetGroup.getGrade(),
                StringBuilderUtil.levelCodeTrans(assetGroup.getLevelcode()),
                assetGroup.getIcon(),
                assetGroup.getIconclass(),
                assetGroup.getDisplayIndex(),
                DataTypeConversionUtil.DataFormatMillises(assetGroup.getCreated()),
                DataTypeConversionUtil.DataFormatMillises(assetGroup.getModified()),
                assetGroup.getDescription(),
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
    public Boolean  update(AssetGroup assetGroup){

        Boolean result= existData("id", DataTypeConversionUtil.UUIDTransID(assetGroup.getId()));  //判断服务器是否存在该数据
        if (result == false) return true; //如果服务器数据库不存在该数据，直接返回
        String updateSql = "update asset_group  set  parent_id= ?,name= ?,value= ?,grade= ?,levelcode= ?,icon= ?,iconClass= ?,display_index= ?,created= ?,modified= ?,description= ?  where id = ?";
        Object args[] = {
                DataTypeConversionUtil.UUIDTransID(assetGroup.getRootId()),
                assetGroup.getAssetGroupName(),
                assetGroup.getValue(),
                assetGroup.getGrade(),
                StringBuilderUtil.levelCodeTrans(assetGroup.getLevelcode()),
                assetGroup.getIcon(),
                assetGroup.getIconclass(),
                assetGroup.getDisplayIndex(),
                DataTypeConversionUtil.DataFormatMillises(assetGroup.getCreated()),
                DataTypeConversionUtil.DataFormatMillises(assetGroup.getModified()),
                assetGroup.getDescription(),
                DataTypeConversionUtil.UUIDTransID(assetGroup.getId()),
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
    public Boolean   delete(List<AssetGroup> groupIds){

        String deleteSql = "delete from asset_group where id = ?";
        for (int i = 0; i < groupIds.size(); i++) {
            Integer groupID =  DataTypeConversionUtil.UUIDTransID(groupIds.get(i).getId());
            Boolean result= existData("id", groupID);  //判断服务器是否存在该数据
            if (result == false) continue;
            jdbcTemplate.update(deleteSql, groupID);
        }
        return   true;
    }

    /**
     * <p>查询是否存在某个值</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean   existData(String cloumnName,Object cloumnValue){
        String selectSql = "select count(*) from asset_group where  " +cloumnName+ " = "+cloumnValue;
        int count = jdbcTemplate.queryForObject(selectSql, Integer.class);
        if(count > 0) return   true;
        return   false;
    }

}