package com.sbr.asset.tag.dao;

import com.sbr.asset.group.model.AssetGroup;
import com.sbr.asset.tag.model.AssetTag;
import com.sbr.asset.tag.model.AssetTagGroup;
import com.sbr.asset.tag.model.AssetTagObjectRlt;
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
public class IAssetTagTemplateDAO {

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    /**
     * <p>新增标签组同步到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     * @param assetTagGroup
     */
    public Boolean  save(AssetTagGroup assetTagGroup){
        String sqlAdd = "insert into asset_tag_group (id,parent_id,name,levelcode,icon,iconClass,display_index,creator_id,created,modified,description) " +
                "value" +
                " (?,?,?,?,?,?,?,?,?,?,?)";
        Object args[] = {
                DataTypeConversionUtil.UUIDTransID(assetTagGroup.getId()),
                0,
                assetTagGroup.getTagGroupName(),
                StringBuilderUtil.levelCodeTrans(assetTagGroup.getLevelcode()),
                assetTagGroup.getIcon(),
                assetTagGroup.getIconClass(),
                assetTagGroup.getDisplayIndex(),
                assetTagGroup.getCreatorId(),
                DataTypeConversionUtil.DataFormatMillises(assetTagGroup.getCreated()),
                DataTypeConversionUtil.DataFormatMillises(assetTagGroup.getModified()),
                assetTagGroup.getDescription(),
        };
        int update = jdbcTemplate.update(sqlAdd, args);
        if(update == 1) return   true;
        return   false;
    }

    /**
     * <p>新增标签组标签同步到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     * @param assetTag
     */
    public Boolean  save(AssetTag assetTag){
        String sqlAdd = "insert into asset_tag (uuid,id,group_id,name,color,display_index,created,creator_id) " +
                "value" +
                " (?,?,?,?,?,?,?,?)";
        Object args[] = {
                assetTag.getId(),
                DataTypeConversionUtil.UUIDTransID(assetTag.getId()),
                DataTypeConversionUtil.UUIDTransID(assetTag.getGroupTagId().getId()),
                assetTag.getTagName(),
                assetTag.getColor(),
                assetTag.getDisplayIndex(),
                DataTypeConversionUtil.DataFormatMillises(assetTag.getCreated()),
                assetTag.getCreatorId()
        };
        int update = jdbcTemplate.update(sqlAdd, args);
        if(update == 1) return   true;
        return   false;
    }

    /**
     * <p>新增资产标签中间表同步到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     * @param assetTagObjectRlt
     */
    public Boolean  saveAssetTags(AssetTagObjectRlt assetTagObjectRlt){
        String sqlAdd = "insert into asset_tag_object_rlt (id,tag_id,asset_id) " +
                "value" +
                " (?,?,?)";
        Object args[] = {
                DataTypeConversionUtil.UUIDTransID(assetTagObjectRlt.getId()),
                DataTypeConversionUtil.UUIDTransID(assetTagObjectRlt.getTagId()),
                DataTypeConversionUtil.UUIDTransID(assetTagObjectRlt.getAssetId()),
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
    public Boolean  update(AssetTagGroup assetTagGroup){

        Boolean result= existAssetGroupData("id", DataTypeConversionUtil.UUIDTransID(assetTagGroup.getId()));  //判断服务器是否存在该数据
        if (result == false) return true; //如果服务器数据库不存在该数据，直接返回

        String updateSql = "update asset_tag_group  set  parent_id= ?,name= ?,levelcode= ?,icon= ?,iconClass= ?,display_index= ?,creator_id=?,created= ?,modified= ?,description= ?  where id = ?";
        Object args[] = {
                0,
                assetTagGroup.getTagGroupName(),
                StringBuilderUtil.levelCodeTrans(assetTagGroup.getLevelcode()),
                assetTagGroup.getIcon(),
                assetTagGroup.getIconClass(),
                assetTagGroup.getDisplayIndex(),
                assetTagGroup.getCreatorId(),
                DataTypeConversionUtil.DataFormatMillises(assetTagGroup.getCreated()),
                DataTypeConversionUtil.DataFormatMillises(assetTagGroup.getModified()),
                assetTagGroup.getDescription(),
                DataTypeConversionUtil.UUIDTransID(assetTagGroup.getId()),
        };
        int update = jdbcTemplate.update(updateSql, args);
        if(update == 1) return   true;
        return   false;
    }

    /**
     * <p>刪除标签组同步到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean   deleteAssetTagGroupsById(List<String> tagGroupIds){
        String deleteSql = "delete from asset_tag_group where id = ?";
        for (String tagGroupId:tagGroupIds) {
            Integer integer = DataTypeConversionUtil.UUIDTransID(tagGroupId);
            Boolean result= existAssetGroupData("id", DataTypeConversionUtil.UUIDTransID(tagGroupId));  //判断服务器是否存在该数据
            if (result == false) continue; //如果服务器数据库不存在该数据，执行下次循环
            jdbcTemplate.update(deleteSql, DataTypeConversionUtil.UUIDTransID(tagGroupId));
        }
        return   true;
    }

    /**
     * <p>刪除标签组对应的标签同步到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean   deleteAssetTagByGroupId(List<String> groupIds){
        String deleteSql = "delete from asset_tag  where group_id =?";
        for (String tagGroupId:groupIds) {
            Boolean result= existData("group_id", DataTypeConversionUtil.UUIDTransID(tagGroupId));  //判断服务器是否存在该数据
            if (result == false) continue; //如果服务器数据库不存在该数据，执行下次循环
            jdbcTemplate.update(deleteSql, DataTypeConversionUtil.UUIDTransID(tagGroupId));
        }
        return   true;
    }


//    /**
//     * <p>刪除标签组对应的标签同步到服务器数据库</p>
//     * @author YLQ
//     * @date 2019-07-26 17:38:21
//     */
//    public Boolean   deleteAssetTagByGroupId(String groupId){
//        String deleteSql = "delete from asset_tag  where group_id =?";
//        Boolean result= existData("group_id", DataTypeConversionUtil.UUIDTransID(groupId));  //判断服务器是否存在该数据
//        if (result == false) return false;  //如果服务器数据库不存在该数据，执行下次循环
//        int update = jdbcTemplate.update(deleteSql, DataTypeConversionUtil.UUIDTransID(groupId));
//        if(update == 1) return   true;
//        return   true;
//    }

    /**
     * <p>刪除单个标签组对应的标签同步到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean   deleteAssetTagBytagId(String tagID){
        String deleteSql = "delete from asset_tag  where id =?";
        Boolean result= existData("id", DataTypeConversionUtil.UUIDTransID(tagID));  //判断服务器是否存在该数据
        if (result == false) return  true; //如果服务器数据库不存在该数据，执行下次循环
        int update = jdbcTemplate.update(deleteSql, DataTypeConversionUtil.UUIDTransID(tagID));
        if(update == 1) return   true;
        return   false;
    }

    /**
     * <p>刪除资产标签对应关系同步到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean   deleteAssetTagByAssetId(List<String> assetIDs){
        String deleteSql = "delete from asset_tag_object_rlt  where asset_id =?";
        for (String assetID:assetIDs ) {
            Boolean result= existAssetTagObjectRltData("asset_id", DataTypeConversionUtil.UUIDTransID(assetID));  //判断服务器是否存在该数据
            if (result == false) return  true; //如果服务器数据库不存在该数据，执行下次循环
            int update = jdbcTemplate.update(deleteSql, DataTypeConversionUtil.UUIDTransID(assetID));
        }
        return   true;
    }

    /**
     * <p>刪除资产标签对应关系同步到服务器数据库</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean   deleteAssetTagByAssetId(String assetID){
        String deleteSql = "delete from asset_tag_object_rlt  where asset_id =?";
        Boolean result= existAssetTagObjectRltData("asset_id", DataTypeConversionUtil.UUIDTransID(assetID));  //判断服务器是否存在该数据
        if (result == false) return  true; //如果服务器数据库不存在该数据，执行下次循环
        int update = jdbcTemplate.update(deleteSql, DataTypeConversionUtil.UUIDTransID(assetID));
        if(update == 1) return   true;
        return   false;
    }

    /**
     * <p>查询是标签表否存在某个值</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */

    public Boolean   existData(String cloumnName,Object cloumnValue){
        String selectSql = "select count(*) from asset_tag where " +cloumnName+ " = "+cloumnValue;
        int count = jdbcTemplate.queryForObject(selectSql, Integer.class);
        if(count > 0) return   true;
        return   false;
    }

    /**
     * <p>查询标签组表是否存在某个值</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean   existAssetGroupData(String cloumnName,Object cloumnValue){
        String selectSql = "select count(*) from asset_tag_group where " +cloumnName+ " = "+cloumnValue;
        int count = jdbcTemplate.queryForObject(selectSql, Integer.class);
        if(count > 0) return   true;
        return   false;
    }

    /**
     * <p>查询资产标签组表是否存在某个值</p>
     * @author YLQ
     * @date 2019-07-26 17:38:21
     */
    public Boolean   existAssetTagObjectRltData(String cloumnName,Object cloumnValue){
        String selectSql = "select count(*) from asset_tag_object_rlt where " +cloumnName+ " = "+cloumnValue;
        int count = jdbcTemplate.queryForObject(selectSql, Integer.class);
        if(count > 0) return   true;
        return   false;
    }

}