package com.sbr.asset.type.dao;


import com.sbr.asset.type.model.AssetType;
import com.sbr.ms.springdata.repository.IBaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 描述：资产类型表DAO
* @author YLQ
* @date 2019-07-26 10:10:48
*/
public interface IAssetTypeDAO extends IBaseRepository<AssetType,String>{
	@Modifying
	@Transactional
	@Query("delete from AssetType at where id in ?1")
	public void deleteAssetTypesByIds(List<String> ids);

	@Query(value="select *  from asset_type at where root_id = 0"  ,nativeQuery = true)
	public List<AssetType> selectRootAssetTypes();

	@Query(value="select *  from asset_type at where root_id = ?1"  ,nativeQuery = true)
	public List<AssetType> findAllByAssetTypeId(String typeId);

	@Query(value="select  *  from  asset_type   WHERE root_id is not null and root_id <>''"  ,nativeQuery = true)
	public List<AssetType> findChildAssetType();


}
