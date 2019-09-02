package com.sbr.asset.tag.service.impl;

import com.sbr.asset.group.model.AssetGroup;
import com.sbr.asset.tag.dao.IAssetTagDAO;
import com.sbr.asset.tag.dao.IAssetTagGroupDAO;
import com.sbr.asset.tag.dao.IAssetTagObjectRtlDAO;
import com.sbr.asset.tag.dao.IAssetTagTemplateDAO;
import com.sbr.asset.tag.model.AssetTag;
import com.sbr.asset.tag.model.AssetTagGroup;
import com.sbr.asset.tag.service.IAssetTagGroupService;
import com.sbr.common.finder.Finder;
import com.sbr.common.util.ClassUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* 描述：标签组表 服务实现层
* @author YLQ
* @date 2019-07-29 17:40:26
*/
//标记为Service类
@Service
public class AssetTagGroupServiceImpl  implements IAssetTagGroupService {

    @Autowired
    private IAssetTagGroupDAO assetTagGroupDAO;
    @Autowired
    private IAssetTagDAO assetTagDAO;
    @Autowired
    private IAssetTagObjectRtlDAO assetTagObjectRtlDAO;
    @Autowired
    private IAssetTagTemplateDAO assetTagTemplateDAO;


    @Override
    public List<AssetTagGroup> findAll() {
        return assetTagGroupDAO.findAll();
    }

    @Override
    public AssetTagGroup findById(String id){
        return assetTagGroupDAO.findOne(id);
    }

    @Override
    public List<AssetTagGroup> findByFinder(Finder finder){
        return assetTagGroupDAO.findByFinder(finder);
    }

    private List<AssetGroup> getAllData(List<AssetGroup> listRoot,List<AssetGroup> list){

        if(CollectionUtils.isNotEmpty(listRoot)&&CollectionUtils.isNotEmpty(list)){
            List<AssetGroup> t = new ArrayList<AssetGroup>();
            for (AssetGroup root : listRoot) {
                List<AssetGroup> ee = new ArrayList<AssetGroup>();
                for (AssetGroup list1 : list) {
                    if (root.getId().equals(list1.getRootId())) {
                        ee.add(list1);
                    }
                }
                root.setChildren(ee);
                t.addAll(ee);

            }
            getAllData(t,list);
        }
        return listRoot;

    }



    @Override
    @Transactional
    public AssetTagGroup create(AssetTagGroup assetTagGroup) {
        String id = UUID.randomUUID().toString();
        assetTagGroup.setId(id);
        assetTagGroup.setRootId("0");
        assetTagGroup.setParentId("0");
        assetTagGroup.setLevelcode("/" + id);
        assetTagGroup.setCreated(new Date());
        AssetTagGroup save = assetTagGroupDAO.save(assetTagGroup);
        assetTagTemplateDAO.save(save);//同步到服务器
        return save;
    }

    @Override
    @Transactional
    public void delete (String id){
        assetTagGroupDAO.delete(id);
    }

    @Override
    @Transactional
    public void batchDelete (List<String> ids){

        assetTagGroupDAO.deleteAssetTagGroupsById(ids);
        assetTagDAO.deleteAssetTagByGroupId(ids);
//        assetTagObjectRtlDAO.deleteTagsByAssetID(ids);
        assetTagTemplateDAO.deleteAssetTagGroupsById(ids); //同步到服务器
        assetTagTemplateDAO.deleteAssetTagByGroupId(ids);   //同步到服务器

    }


    @Override
    @Transactional
    public AssetTagGroup patchUpdate(AssetTagGroup assetTagGroup) {
        assetTagGroup.setAssetTagSet(null);
        assetTagGroup.setChildren(null);
        AssetTagGroup entity = findById(assetTagGroup.getId());
        entity.setModified(new Date());
      //  entity.setAssetTagSet(assetTagGroup.getAssetTagSet());
        ClassUtil.merge(entity, assetTagGroup);
        AssetTagGroup save = assetTagGroupDAO.save(entity);
        assetTagTemplateDAO.update(save);//同步到服务器
        return save;
    }

    @Override
    public List<AssetTagGroup> findAllAssetTags() {
        List<AssetTagGroup> allAssetTag = assetTagGroupDAO.findAll();
        List<AssetTagGroup> listRoot = new ArrayList<>();
        for (AssetTagGroup assetTagGroup : allAssetTag) {
            if (assetTagGroup.getRootId().equals("0")) {
                listRoot.add(assetTagGroup);
            }
        }
        return getAllChildrenTags(listRoot, allAssetTag);
    }

    private List<AssetTagGroup> getAllChildrenTags(List<AssetTagGroup> listRoot, List<AssetTagGroup> list) {
        List<AssetTag> allAssetTag = assetTagDAO.findAll();
        List<AssetTagGroup> t = new ArrayList<AssetTagGroup>();
        if (CollectionUtils.isNotEmpty(listRoot) && CollectionUtils.isNotEmpty(list)) {
            for (AssetTagGroup assetTagGroup : listRoot) {
                List<AssetTag> assetTagsList = new ArrayList<>();
                for (AssetTag assetTag : allAssetTag) {
                    if (assetTagGroup.getId().equals(assetTag.getGroupTagId().getId())) {
                        assetTagsList.add(assetTag);
                    }
                }
                assetTagGroup.setChildren(assetTagsList);
                t.add(assetTagGroup);
            }
        }
        return listRoot;
    }
}