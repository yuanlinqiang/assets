package com.sbr.asset.info.service;

import com.sbr.asset.group.model.AssetGroup;
import com.sbr.asset.info.model.AssetObject;
import com.sbr.common.finder.Finder;
import com.sbr.common.page.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
* <p>资产对象表 服务实现层接口</p>
* @author YLQ  2019-07-26 14:23:01
*/

public interface IAssetObjectService {

    /**
     *
     * <p>根据查询条件查询</p>
     * @param finder 查询条件
     * @return 数据的集合
     * @author YLQ 2019-07-26 14:23:01
     */
    public List<AssetObject> findByFinder(Finder finder);

    /**
     *
     * <p>根据查询条件查询 带分页</p>
     * @param finder 查询条件
     * @param page 分页信息
     * @return 实体
     * @author YLQ 2019-07-29 17:38:21
     */
    public Page<AssetObject> findByFinderAndPage(Finder finder, Page<AssetObject> page);

    /**
    *
    * <p>根据Id查询实体</p>
    * @param id 主键
    * @return 实体
    * @author YLQ 2019-07-26 14:23:01
    */
    public AssetObject findById(String id);


    /**
    *
    * <p>新增资产对象表</p>
    * @param  AssetObject
    * @return 实体
    * @author YLQ 2019-07-26 14:23:01
    */
    public AssetObject create(AssetObject AssetObject);

    /**
    *
    * <p>根据id删除资产对象表</p>
    * @param id 主键
    * @author YLQ 2019-07-26 14:23:01
    */
    public void deleteByListIds(List<String> id);


    /**
    *
    * <p>更新部分数据</p>
    * @param assetObject 需要更新的数据实体
    * @return 实体
    * @author YLQ 2019-07-26 14:23:01
    */
    public AssetObject patchUpdate(AssetObject assetObject);


    /**
    *
    * <p>查询资产组的所有数据</p>  
    * @param  levelCode
    * @return 实体
    * @author YLQ 2019-07-26 14:23:01
    */
	public List<AssetObject> findByLevelCode(String levelCode);


    /**
     *
     * <p>查询资产组的所有数据</p>
     * @return 实体
     * @author YLQ 2019-07-26 14:23:01
     */
    public List<AssetObject> findAllAsset();


    /**
     *
     * <p>移动资产组</p>
     * @param moveAssetIds 资产ID和资产组ID
     * @return 实体
     * @author YLQ 2019-07-26 10:10:48
     */
    public List<AssetObject> getMoveAssetGroup(String[] moveAssetIds);


    /**
     * <p>导入资产</p>
     * @return 实体
     * @author YLQ 2019-07-26 10:10:48
     */
    public void importExcel(MultipartFile file,String assetGroupID) throws IOException;


}
