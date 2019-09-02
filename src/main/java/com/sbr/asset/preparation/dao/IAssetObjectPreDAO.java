package com.sbr.asset.preparation.dao;

import com.sbr.asset.preparation.model.AssetObjectPre;
import com.sbr.ms.springdata.repository.IBaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 描述：预备资产对象表DAO
* @author YLQ
* @date 2019-05-15 10:10:16
*/
public interface IAssetObjectPreDAO extends IBaseRepository<AssetObjectPre,String>{
	@Modifying
	@Transactional
	@Query("delete from AssetObjectPre at where at.id in ?1")
	public void deleteAssetTypesWithUuidIds(List<String> id);
}
