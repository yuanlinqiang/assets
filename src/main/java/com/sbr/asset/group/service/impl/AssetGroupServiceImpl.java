package com.sbr.asset.group.service.impl;

import com.sbr.asset.group.dao.IAssetGroupTemplateDAO;
import com.sbr.asset.info.dao.IAssetObjectDAO;
import com.sbr.asset.util.StringBuilderUtil;
import com.sbr.common.finder.Finder;
import com.sbr.common.util.ClassUtil;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbr.asset.group.dao.IAssetGroupDAO;
import com.sbr.asset.group.model.AssetGroup;
import com.sbr.asset.group.service.IAssetGroupService;

import java.util.*;

/**
 * 描述：资产组表 服务实现层
 * 
 * @author yuan
 * @date 2019-07-29 17:38:21
 */


// 标记为Service类
@Service
public class AssetGroupServiceImpl implements IAssetGroupService {

	@Autowired
	private IAssetGroupDAO assetGroupDAO;
	@Autowired
	private IAssetObjectDAO assetObjectDAO;
    @Autowired
    private IAssetGroupTemplateDAO assetGroupTemplateDAO;

	@Override
	public AssetGroup findById(String id) {
		return assetGroupDAO.findOne(id);
	}

	//临时上面方法修改
    @Override
    public List<AssetGroup> findByFinder(Finder finder) {
        List<AssetGroup> listRoot = new ArrayList<AssetGroup>();
        List<AssetGroup> list = assetGroupDAO.findByFinder(finder);
        for (AssetGroup assetGroup : list) {
            // 根节点
            if (assetGroup.getRootId().equals("0")) {
                listRoot.add(assetGroup);
            }
        }
        return 	getAllData(listRoot,list);
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
    public AssetGroup create(AssetGroup assetGroup) {
        String id = UUID.randomUUID().toString();
        String rootLevelCode = "";
        if (assetGroup.getId() != null) rootLevelCode = assetGroupDAO.findOne(assetGroup.getId()).getLevelcode(); //获取资产组的levelCode
        assetGroup.setLevelcode(StringBuilderUtil.stringBuilder(rootLevelCode, id));
        assetGroup.setParentId("0"); //系统的节点
        assetGroup.setId(id);
        assetGroup.setCreated(new Date());
        //同步数据到服务器
        AssetGroup save = assetGroupDAO.save(assetGroup);
        synchronizeData(save);
        return save;
    }

    @Override
    public List<AssetGroup> findAll() {
        return assetGroupDAO.findAll();
    }

    @Override
    @Transactional
    public void delete(String[] ids) {
        ArrayList<String> groupIds =  new ArrayList<String>(ids.length);
        List<AssetGroup> all = assetGroupDAO.findAll();
        List<AssetGroup> list  =  new ArrayList<>();
        List<AssetGroup> treeMenuList = new ArrayList<>();//遍历所有的子菜单
        List<String>  groupIdlist = new ArrayList<>();
        Collections.addAll(groupIds, ids);  //  后期业务可能需要修改分组List
        for (String groupId: groupIds) {  // 将组节点下的资产假删除
            String levelcode = assetGroupDAO.findOne(groupId).getLevelcode();
            assetObjectDAO.deleteAssetObjectByLevelcode(levelcode);
        }
        for (String groupId :ids) { //删除父几点下面的所有子节点
            treeMenuList = getTreeMenuList(list, groupId);  //查询父几点下面的所有子节点
            for (AssetGroup childGroupId:treeMenuList) {
                groupIdlist.add(childGroupId.getId());
            }
            assetGroupDAO.deleteAssetGroupByGroupIds(groupIdlist);
        }
        assetGroupTemplateDAO.delete(treeMenuList); //删除服务器数据以及资产
    }

    @Override
    @Transactional
	public void deleteByEntity(AssetGroup assetGroup) {
        assetGroupDAO.delete(assetGroup);
	}

	@Override
    @Transactional
	public AssetGroup patchUpdate(AssetGroup assetGroup) {
        AssetGroup entity = findById(assetGroup.getId().toString());
        assetGroup.setModified(new Date());
        ClassUtil.merge(entity, assetGroup);
        AssetGroup save = assetGroupDAO.save(entity);
        assetGroupTemplateDAO.update(save);  //修改同步
        return  save;

	}

	@Override
    @Transactional
	public AssetGroup putUpdate(AssetGroup assetGroup) {
        return assetGroupDAO.save(assetGroup);
	}

    public List<AssetGroup> getTreeMenuList(List<AssetGroup> domainList ,String pid) {
        //加入它本身
        AssetGroup model = new AssetGroup();
        model.setId(pid);
        domainList.add(model);
        //加入子集
        List<AssetGroup> list = assetGroupDAO.findByRootID(pid);
        for(AssetGroup type : list) {
            getTreeMenuList(domainList,String.valueOf(type.getId()));
        }
        return domainList;
    }



    public Boolean synchronizeData(AssetGroup assetGroup) {
        return assetGroupTemplateDAO.save(assetGroup);
    }


}