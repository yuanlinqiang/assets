package com.sbr.asset.type.service.impl;

import com.sbr.asset.type.dao.IAssetTypeDAO;
import com.sbr.asset.type.dao.IAssetTypeTemplateDAO;
import com.sbr.asset.type.model.AssetType;
import com.sbr.asset.type.service.IAssetTypeService;
import com.sbr.asset.util.StringBuilderUtil;
import com.sbr.common.entity.Tree;
import com.sbr.common.finder.Finder;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

/**
* 描述：资产类型表 服务实现层
* @author YLQ
* @date 2019-07-26 10:10:48
*/
@Service
public class AssetTypeServiceImpl implements IAssetTypeService {
	private Logger logger = Logger.getLogger(AssetTypeServiceImpl.class);

    @Autowired
    private IAssetTypeDAO assetTypeDAO;
    @Autowired
    private IAssetTypeTemplateDAO  assetTypeTemplateDAO;

	@Override
	@Transactional
	public AssetType create(AssetType assetType) {
        String id = UUID.randomUUID().toString();
        AssetType assetTypeParent =  new AssetType();
        if(assetType.getRoot_id() != null){ //查询父节点
            assetTypeParent = assetTypeDAO.findOne(assetType.getRoot_id());
            assetType.setParent(assetTypeParent);
            assetType.setLevelcode(StringBuilderUtil.stringBuilder(assetTypeParent.getLevelcode(),id));
        }else{
            assetType.setLevelcode("/" + id);
        }
        assetType.setParentId("0");
		assetType.setId(id);
		assetType.setCreated(new Date());
        AssetType save = assetTypeDAO.save(assetType);
        assetTypeTemplateDAO.save(save);   //同步新增标签类型到服务器
        return save ;
	}

	@Override
	public List<AssetType> findByFinder(Finder finder){

		return assetTypeDAO.findByFinder(finder);
	}


    @Override
    public List<AssetType> structureMenuChildren(List<AssetType> menuAllList) {
        for (AssetType menu : menuAllList) {
            for (AssetType menu2 : menuAllList) {
                if (menu2.getParent() != null && menu2.getParent().getId().equals(menu.getId())) {
                    menu.getTypeChildren().add(menu2);
                }
            }
        }
        return menuAllList;
    }

    @Override
    public Tree constructTree(AssetType menu) {
        Tree tree = new Tree();
        if (menu == null) {
            return tree;
        }
        tree.setId(menu.getId());
        tree.setText(menu.getAssetTypeName());
        boolean isLeaf = true;
        if (menu.getTypeChildren().size() > 0) {
            isLeaf = false;
        }
        if (menu.getParent()!=null) {
            tree.setParentId(menu.getParent().getId());
        }
        //组装参数
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("asset_type_name", menu.getAssetTypeName());
        attributes.put("code", menu.getCode());
        attributes.put("levelcode", menu.getLevelcode());
        attributes.put("description", menu.getDescription());
       // attributes.put("root_id", menu.getRoot_id());
        attributes.put("icon", menu.getIcon());
        attributes.put("icon_class", menu.getIconClass());
        attributes.put("is_cvs", menu.getIsCvs());
        attributes.put("is_common", menu.getIsCommon());
        attributes.put("is_builtin", menu.getIsBuiltin());
        attributes.put("display_index", menu.getDisplayIndex());
        attributes.put("created", menu.getCreated());
        attributes.put("modified", menu.getModified());

        //菜单类型如果是API为true，前台操作
        if (!StringUtils.isEmpty(menu.getParent())) {
            attributes.put("root_id", menu.getParent().getId());
        }
        tree.setAttributes(attributes);
        for (AssetType menu1 : menu.getTypeChildren()) {
            tree.getChildren().add(constructTree(menu1));
        }
        return tree;
    }




	@Override
	@Transactional
	public void delete(String id) {
		assetTypeDAO.delete(id);
	}

	@Override
	@Transactional
	public AssetType patchUpdate(AssetType assetType) {
        AssetType  assetTypeParent = new AssetType();
            if(assetType.getRoot_id() != null){ //查询父节点
            assetTypeParent = assetTypeDAO.findOne(assetType.getRoot_id());
            assetType.setParent(assetTypeParent);
            assetType.setLevelcode(StringBuilderUtil.stringBuilder(assetTypeParent.getLevelcode(),assetType.getId()));
        }else{
            assetType.setLevelcode("/" + assetType.getId());
        }
        AssetType save = assetTypeDAO.save(assetType);
        assetTypeTemplateDAO.update(save);  //同步修改服务器
        return   save;
	}

	@Override
	@Transactional
	public void deleteByListIds(List<String> ids) {
        List<AssetType> list  =  new ArrayList<>();
        List<AssetType> treeMenuList = new ArrayList<>();//遍历所有的子菜单
        List<String>  typeIdlist = new ArrayList<>();
        for (String assetTypeId:ids) {
            treeMenuList = getTreeMenuList(list, assetTypeId);  //查询父几点下面的所有子节点
            for (AssetType assetType:  treeMenuList) {
                typeIdlist.add(assetType.getId());
            }
        }
		assetTypeDAO.deleteAssetTypesByIds(typeIdlist);
        assetTypeTemplateDAO.delete(typeIdlist);
	}

    @Override
    public List<AssetType> findParent() {
        List<AssetType>  assetTypesList = assetTypeDAO.selectRootAssetTypes();
        return assetTypesList;
    }

    @Override
    public AssetType findById(String id) {
        return assetTypeDAO.findOne(id);
    }

	@Override
	public List<AssetType> findAllAssettype() {
        List<AssetType> allAssetType = assetTypeDAO.findAll();
        List<AssetType> listRoot = new ArrayList<>();
        return 	getAllData(listRoot,allAssetType);
	}

    private List<AssetType> getAllData(List<AssetType> listRoot,List<AssetType> list){
        if(CollectionUtils.isNotEmpty(listRoot)&&CollectionUtils.isNotEmpty(list)){
            List<AssetType> t = new ArrayList<>();
            for (AssetType root : listRoot) {
                List<AssetType> ee = new ArrayList<AssetType>();
                for (AssetType list1 : list) {
//                    if (root.getId().equals(list1.getRoot_id())) {
//                        ee.add(list1);
//                    }
                }
                root.setTypeChildren(ee);
                t.addAll(ee);
            }
            getAllData(t,list);
        }
        return listRoot;
    }



    //查询子节点
    public List<AssetType> getTreeMenuList(List<AssetType> domainList ,String pid) {
        //加入它本身
        AssetType model = new AssetType();
        model.setId(pid);
        domainList.add(model);
        //加入子集
        List<AssetType> list = assetTypeDAO.findAllByAssetTypeId(pid);
        for(AssetType type : list) {
            getTreeMenuList(domainList,String.valueOf(type.getId()));
        }
        return domainList;
    }

    @Override
    public List<AssetType> findAssetTypeList() {
        return assetTypeDAO.findChildAssetType();
    }
}