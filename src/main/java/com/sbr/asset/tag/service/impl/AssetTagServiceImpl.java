package com.sbr.asset.tag.service.impl;

import com.sbr.asset.tag.dao.IAssetTagDAO;
import com.sbr.asset.tag.dao.IAssetTagGroupDAO;
import com.sbr.asset.tag.dao.IAssetTagObjectRtlDAO;
import com.sbr.asset.tag.dao.IAssetTagTemplateDAO;
import com.sbr.asset.tag.model.AssetTag;
import com.sbr.asset.tag.model.AssetTagGroup;
import com.sbr.asset.tag.service.IAssetTagService;
import com.sbr.common.util.ClassUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* 描述：标签表 服务实现层
* @author YLQ
* @date 2019-07-29 17:39:52
*/
//标记为Service类
@Service
public class AssetTagServiceImpl  implements IAssetTagService {

    @Autowired
    private IAssetTagDAO assetTagDAO;
    @Autowired
    private IAssetTagGroupDAO assetTagGroupDAO;
    @Autowired
    private IAssetTagObjectRtlDAO assetTagObjectRtlDAO;
    @Autowired
    private IAssetTagTemplateDAO assetTagTemplateDAO;


    @Override
    public AssetTag findById(String id){
        return assetTagDAO.findOne(id);
    }


    @Override
    @Transactional
    public AssetTag create(AssetTag assetTag){
        AssetTagGroup father = assetTagGroupDAO.findOne(assetTag.getGroup_id());
        assetTag.setGroupTagId(father);
        assetTag.setCreated(new Date());
        String id = UUID.randomUUID().toString();
        assetTag.setId(id);
        AssetTag save = assetTagDAO.save(assetTag);
        assetTagTemplateDAO.save(save);
        return save;
    }

    @Override
    @Transactional
    public void delete (String id){
        assetTagDAO.delete(id);
        assetTagTemplateDAO.deleteAssetTagBytagId(id); //删除标签同步到数据库

    }

    @Override
    @Transactional
    public void batchDelete (List<String> groupIds){
        assetTagDAO.deleteAssetTagByGroupId(groupIds);
    }



    @Override
    @Transactional
    public AssetTag patchUpdate (AssetTag AssetTag){
        AssetTag entity = findById(AssetTag.getId());
        ClassUtil.merge(entity, AssetTag);
        return assetTagDAO.save(entity);
    }
}