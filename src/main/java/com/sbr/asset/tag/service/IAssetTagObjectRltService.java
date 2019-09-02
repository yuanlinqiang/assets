package com.sbr.asset.tag.service;


import com.sbr.asset.tag.model.AssetTagObjectRlt;

import java.util.List;

/**
* <p>标签资产中间表 服务实现层接口</p>
* @author YLQ  2019-07-29 17:39:52
*/

public interface IAssetTagObjectRltService {


    /**
     *
     * <p>查询资产对应的标签ID</p>
     * @param AssetTagObjectRlt
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    public List<AssetTagObjectRlt>  findAll();

    /**
     *
     * <p>查询资产对应的标签IDs</p>
     * @param assetID
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    public List<String>  findTagsByAssetID(String  assetID);

    /**
     *
     * <p>根据资产ID删除中间关系</p>
     * @param assetID
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    public void deleteTagsByAssetID(String  assetID);


}
