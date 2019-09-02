package com.sbr.asset.info.dao;

import com.sbr.asset.info.model.AssetObject;
import com.sbr.ms.springdata.repository.IBaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 描述：资产对象表DAO
* @author YLQ
* @date 2019-07-26 14:23:01
*/
public interface IAssetObjectDAO extends IBaseRepository<AssetObject,String> {
	
//	@Query(value="select * from asset_object  where levelcode like  ?1 " +" '%' ",nativeQuery = true)
	@Query(value="select * from asset_object  where levelcode like  ?1 " +" '%' and  status = '1'",nativeQuery = true)
	List<AssetObject> findByLevelCode(String levelCode);


	@Modifying
	@Transactional
	@Query("update AssetObject set  status = '0' where id in ?1")
	public void deleteAssetObjectByIds(List<String> ids);

	@Modifying
	@Transactional
	@Query(value="update asset_object set status = '0'  where levelcode like ?1"+" '%' ",nativeQuery = true)
	public void deleteAssetObjectByLevelcode(String levelcode);



}
