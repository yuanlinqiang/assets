package com.sbr.asset.tag.dao;

import com.sbr.asset.tag.model.AssetTagGroup;
import com.sbr.ms.springdata.repository.IBaseRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 描述：标签组表DAO
* @author YLQ
* @date 2019-07-29 17:40:26
*/


// 注意更新和删除是需要加事务的， 并且要加上 @Modify的注解

//@Query 如果在注解中添加 nativeQuery=true 是支持原生SQL查询

public interface IAssetTagGroupDAO extends IBaseRepository<AssetTagGroup,String> {


    @Modifying
    @Transactional
    @Query("delete from AssetTagGroup at where id in ?1")
    public void deleteAssetTagGroupsById(List<String> ids);


}
