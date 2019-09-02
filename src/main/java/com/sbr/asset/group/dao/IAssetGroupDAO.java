package com.sbr.asset.group.dao;

import com.sbr.asset.group.model.AssetGroup;
import com.sbr.ms.springdata.repository.IBaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 描述：资产组表DAO
* @author YLQ
* @date 2019-07-26 17:38:21
*/
public interface IAssetGroupDAO extends IBaseRepository<AssetGroup,String>{

    @Modifying
    @Transactional
    @Query("delete from AssetGroup  where id in ?1")
    public void deleteAssetGroupByGroupIds(List<String> groupIds);


    @Query(value="select * from asset_group  where root_id =  ?1 ",nativeQuery = true)
    List<AssetGroup> findByRootID(String rootId);



}