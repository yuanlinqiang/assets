package com.sbr.asset.type.service;
import com.sbr.asset.type.model.AssetType;
import com.sbr.common.entity.Tree;
import com.sbr.common.finder.Finder;

import java.util.List;

/**
* <p>资产类型表 服务实现层接口</p>
* @author YLQ  2019-07-26 10:10:48
*/

public interface IAssetTypeService {


    /**
     *
     * <p>根据查询条件查询</p>
     * @param finder 查询条件
     * @return 数据的集合
     * @author YLQ 2019-07-26 10:10:48
     */
    public List<AssetType> findByFinder(Finder finder);




    /**
     * 构建子节点
     * @param menuAllList
     * @return 菜单的子节点集合
     */

    public List<AssetType> structureMenuChildren(List<AssetType> menuAllList);

    /**
     * <p>构建资源树</p>
     * @param assetType 菜单对象
     * @return 菜单树
     */
    public Tree constructTree(AssetType assetType);

    /**
     *
     * <p>查询所有资产类型名称</p>
     * @return 实体
     * @author YLQ 2019-07-26 10:10:48
     */
    public List<AssetType> findAssetTypeList();

    /**
     *
     * <p>查询所有资产类型名称</p>
     * @return 实体
     * @author YLQ 2019-07-26 10:10:48
     */
    public List<AssetType> findAllAssettype();


    /**
    *
    * <p>根据Id查询实体</p>
    * @param id 主键
    * @return 实体
    * @author YLQ 2019-07-26 10:10:48
    */
    public AssetType findById(String id);


    /**
    *
    * <p>新增资产类型表</p>
    * @param assetType 需要新增的数据
    * @return 实体
    * @author YLQ 2019-07-26 10:10:48
    */
    public AssetType create(AssetType assetType);

    /**
     *
     * <p>根据id删除资产类型表</p>
     * @param id 主键
     * @author YLQ 2019-07-26 17:38:21
     */
    public void delete(String id);


    /**
    *
    * <p>更新部分数据</p>
    * @param assetType 需要更新的数据实体
    * @return 实体
    * @author YLQ 2019-07-26 10:10:48
    */
    public AssetType patchUpdate(AssetType assetType);

    /**
     *
     * <p>查询所属类型名称</p>
     * @return 实体
     * @author YLQ 2019-07-26 10:10:48
     */
    public List<AssetType> findParent();



    /**
     *
     * <p>删除所选类型</p>
     * @param ids 需要更新的数据实体
     * @return 实体
     * @author YLQ 2019-07-26 10:10:48
     */
    public void deleteByListIds(List<String> ids);

}
