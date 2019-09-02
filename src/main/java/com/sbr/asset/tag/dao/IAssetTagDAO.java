package com.sbr.asset.tag.dao;

import com.sbr.asset.tag.model.AssetTag;
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
public interface IAssetTagDAO extends IBaseRepository<AssetTag,String>{


    @Modifying
    @Transactional
    @Query("delete from AssetTag at where group_id in ?1")
    public void deleteAssetTagByGroupId(List<String> groupIds);


}
