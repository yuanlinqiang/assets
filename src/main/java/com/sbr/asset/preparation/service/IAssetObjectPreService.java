package com.sbr.asset.preparation.service;
import com.sbr.asset.preparation.model.AssetObjectPre;
import com.sbr.common.finder.Finder;
import com.sbr.common.page.Page;

import java.util.List;

/**
* <p>预备资产对象表 服务实现层接口</p>
* @author YLQ  2019-05-15 10:10:16
*/

public interface IAssetObjectPreService {
    /**
    *
    * <p>根据查询条件查询</p>
    * @param finder 查询条件
    * @return 数据的集合
    * @author YLQ 2019-05-15 10:10:16
    */
    public List<AssetObjectPre> findByFinder(Finder finder);

    /**
    *
    * <p>根据Id查询实体</p>
    * @param id 主键
    * @return 实体
    * @author YLQ 2019-05-15 10:10:16
    */
    public AssetObjectPre findById(String id);

    /**
    *
    * <p>根据查询条件查询 带分页</p>
    * @param finder 查询条件
    * @param page 分页信息
    * @return 实体
    * @author YLQ 2019-05-15 10:10:16
    */
    public Page<AssetObjectPre> findByFinderAndPage(Finder finder, Page<AssetObjectPre> page);

    /**
    *
    * <p>新增预备资产对象表</p>
    * @param assetObjectPre 需要新增的数据
    * @return 实体
    * @author YLQ 2019-05-15 10:10:16
    */
    public AssetObjectPre create(AssetObjectPre assetObjectPre);

    /**
    *
    * <p>根据id删除预备资产对象表</p>
    * @param id 主键
    * @author YLQ 2019-05-15 10:10:16
    */
    public void delete(String id);

    /**
    *
    * <p>根据实体删除预备资产对象表</p>
    * @param assetObjectPre 实体
    * @author YLQ 2019-05-15 10:10:16
    */
    public void deleteByEntity(AssetObjectPre assetObjectPre);

    /**
    *
    * <p>更新部分数据</p>
    * @param assetObjectPre 需要更新的数据实体
    * @return 实体
    * @author YLQ 2019-05-15 10:10:16
    */
    public AssetObjectPre patchUpdate(AssetObjectPre assetObjectPre);

    /**
    *
    * <p>更新全部数据</p>
    * @param assetObjectPre 需要更新的数据实体
    * @return 实体
    * @author YLQ 2019-05-15 10:10:16
    */
    public AssetObjectPre putUpdate(AssetObjectPre assetObjectPre);

    public void deleteByListIds(List<String> ids);

}
