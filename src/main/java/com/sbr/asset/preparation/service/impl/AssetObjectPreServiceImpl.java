package com.sbr.asset.preparation.service.impl;

import com.sbr.asset.preparation.dao.IAssetObjectPreDAO;
import com.sbr.asset.preparation.model.AssetObjectPre;
import com.sbr.asset.preparation.service.IAssetObjectPreService;
import com.sbr.common.finder.Finder;
import com.sbr.common.page.Page;
import com.sbr.common.util.ClassUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
* 描述：预备资产对象表 服务实现层
* @author YLQ
* @date 2019-05-15 10:10:16
*/
//标记为Service类
@Service
public class AssetObjectPreServiceImpl implements IAssetObjectPreService {

    @Autowired
    private IAssetObjectPreDAO assetObjectPreDAO;

    @Override
    public List<AssetObjectPre> findByFinder(Finder finder){
        return assetObjectPreDAO.findByFinder(finder);
    }

    @Override
    public AssetObjectPre findById(String id){
        return assetObjectPreDAO.findOne(id);
    }

    @Override
    public Page<AssetObjectPre> findByFinderAndPage(Finder finder, Page<AssetObjectPre> page) {
        return assetObjectPreDAO.findByFinderAndPage(finder,page);
    }

    @Override
    @Transactional
    public AssetObjectPre create(AssetObjectPre assetObjectPre){
    	assetObjectPre.setId(UUID.randomUUID().toString());
        return assetObjectPreDAO.save(assetObjectPre);
    }

    @Override
    @Transactional
    public void delete (String id){
        assetObjectPreDAO.delete(id);
    }

    @Override
    @Transactional
	public void deleteByListIds(List<String> ids) {
    	assetObjectPreDAO.deleteAssetTypesWithUuidIds(ids);
	}

    @Override
    @Transactional
    public void deleteByEntity(AssetObjectPre assetObjectPre){
        assetObjectPreDAO.delete(assetObjectPre);
    }

    @Override
    @Transactional
    public AssetObjectPre patchUpdate (AssetObjectPre assetObjectPre){
        AssetObjectPre entity = findById(assetObjectPre.getId());
        ClassUtil.merge(entity, assetObjectPre);
        return assetObjectPreDAO.save(entity);
    }

    @Override
    @Transactional
    public AssetObjectPre putUpdate (AssetObjectPre assetObjectPre){
        return assetObjectPreDAO.save(assetObjectPre);
    }
}