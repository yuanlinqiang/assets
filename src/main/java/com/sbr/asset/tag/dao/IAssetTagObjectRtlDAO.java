package com.sbr.asset.tag.dao;


import com.sbr.asset.tag.model.AssetTagObjectRlt;
import com.sbr.ms.springdata.repository.IBaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 描述：标签表DAO
* @author YLQ
* @date 2019-07-29 17:39:52
*/
public interface IAssetTagObjectRtlDAO extends IBaseRepository<AssetTagObjectRlt,String> {

    @Query(value="select  tag_id  from   asset_tag_object_rlt     where   asset_id  = ?1 ",nativeQuery = true)
    List<String> findTagsByAssetID(String assetID);

    @Modifying
    @Transactional
    @Query("delete  from   AssetTagObjectRlt  where  asset_id  = ?1 ")
    public void  deleteTagsByAssetID(String assetID);

    @Modifying
    @Transactional
    @Query("delete  from   AssetTagObjectRlt  where  asset_id  in ?1 ")
    public void  deleteTagsByAssetID(List<String> assetID);


}
