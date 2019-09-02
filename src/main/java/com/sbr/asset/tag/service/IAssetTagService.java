package com.sbr.asset.tag.service;

import com.sbr.asset.tag.model.AssetTag;
import com.sbr.asset.tag.model.AssetTag;
import com.sbr.common.finder.Finder;
import com.sbr.common.page.Page;

import java.util.List;

/**
* <p>标签表 服务实现层接口</p>
* @author YLQ  2019-07-29 17:39:52
*/

public interface IAssetTagService {



    /**
    *
    * <p>根据Id查询实体</p>
    * @param id 主键
    * @return 实体
    * @author YLQ 2019-07-29 17:39:52
    */
    public AssetTag findById(String id);
    /**
     *
     * <p>新增标签组表</p>
     * @param AssetTag 需要新增的数据
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    public AssetTag create(AssetTag AssetTag);

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
     * @param groupId 分组集合
     * @author YLQ 2019-07-29 17:40:26
     */
    public void batchDelete(List<String> groupId);




    /**
     *
     * <p>更新部分数据</p>
     * @param AssetTag 需要更新的数据实体
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    public AssetTag patchUpdate(AssetTag AssetTag);



}
