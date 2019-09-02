package com.sbr.asset.group.service;
import com.sbr.asset.group.model.AssetGroup;
import com.sbr.asset.info.model.AssetObject;
import com.sbr.common.finder.Finder;
import com.sbr.common.page.Page;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
* <p>资产组表 服务实现层接口</p>
* @author yuan  2019-07-26 17:38:21
*/

public interface IAssetGroupService {

    /**
     *
     * <p>根据查询条件查询</p>
     * @param finder 查询条件
     * @return 数据的集合
     * @author YLQ 2019-07-29 17:38:21
     */
    public List<AssetGroup> findByFinder(Finder finder);

    /**
    *
    * <p>根据Id查询实体</p>
    * @param id 主键
    * @return 实体
    * @author yuan 2019-07-26 17:38:21
    */
    public AssetGroup findById(String id);

    /**
     *
     * <p>查询所有</p>
     * @return 实体
     * @author yuan 2019-07-26 17:38:21
     */
    public List<AssetGroup> findAll();

    /**
     *
     * <p>新增资产组表</p>
     * @param assetGroup 需要新增的数据
     * @return 实体
     * @author yuan 2019-07-26 17:38:21
     */
    public AssetGroup create(AssetGroup assetGroup);



    /**
     *
     * <p>根据id删除资产组表</p>
     * @param ids 资产ID
     * @author yuan 2019-07-26 17:38:21
     */
    public void delete(String[] ids);

    /**
     *
     * <p>根据实体删除资产组表</p>
     * @param assetGroup 实体
     * @author yuan 2019-07-26 17:38:21
     */
    public void deleteByEntity(AssetGroup assetGroup);

    /**
     *
     * <p>更新部分数据</p>
     * @param assetGroup 需要更新的数据实体
     * @return 实体
     * @author yuan 2019-07-26 17:38:21
     */
    public AssetGroup patchUpdate(AssetGroup assetGroup);

    /**
     *
     * <p>更新全部数据</p>
     * @param assetGroup 需要更新的数据实体
     * @return 实体
     * @author yuan 2019-07-26 17:38:21
     */
    public AssetGroup putUpdate (AssetGroup assetGroup);


}
