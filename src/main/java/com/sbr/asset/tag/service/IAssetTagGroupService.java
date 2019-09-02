package com.sbr.asset.tag.service;
import com.sbr.asset.tag.model.AssetTagGroup;
import com.sbr.common.finder.Finder;

import java.util.List;

/**
* <p>标签组表 服务实现层接口</p>
* @author YLQ  2019-07-29 17:40:26
*/

public interface IAssetTagGroupService {

    /**
     *
     * <p>根据查询条件查询</p>
     * @param finder 查询条件
     * @return 数据的集合
     * @author YLQ 2019-05-16 17:40:26
     */
    public List<AssetTagGroup> findByFinder(Finder finder);

    /**
    *
    * <p>根据Id查询实体</p>
    * @param id 主键
    * @return 实体
    * @author YLQ 2019-07-29 17:40:26
    */
    public AssetTagGroup findById(String id);


    /**
     *
     * <p>根据Id查询实体</p>
     * @param id 主键
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    public List< AssetTagGroup> findAll();

    /**
     *
     * <p>新增标签组表</p>
     * @param assetTagGroup 需要新增的数据
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    public AssetTagGroup create(AssetTagGroup assetTagGroup);

    /**
     *
     * <p>根据id删除标签组表</p>
     * @param id 主键
     * @author YLQ 2019-07-29 17:40:26
     */
    public void delete(String id);

    /**
     *
     * <p>根据id删除标签组表</p>
     * @param id 主键
     * @author YLQ 2019-07-29 17:40:26
     */
    public void batchDelete(List<String> id);

    /**
     *
     * <p>更新部分数据</p>
     * @param assetTagGroup 需要更新的数据实体
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    public AssetTagGroup patchUpdate(AssetTagGroup assetTagGroup);

    /**
     *
     * <p>查询所有的标签以及对应的组</p>
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    public List<AssetTagGroup> findAllAssetTags();

}
