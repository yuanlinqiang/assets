package com.sbr.asset.group.controller;

import com.sbr.common.finder.Finder;
import com.sbr.common.finder.FinderFactory;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sbr.asset.group.model.AssetGroup;
import com.sbr.asset.group.service.IAssetGroupService;
import com.sbr.springboot.controller.BaseController;

import java.util.List;

/**
* 描述：资产组
* @author YLQ  2019-07-26 17:38:21
*/
@RestController
@RequestMapping("/sp-assets/api")
public class AssetGroupController extends BaseController{

    @Autowired
    private IAssetGroupService assetGroupService;

    /**
     * <p>分页查询</p>
     * @param req
     * @return  资产组集合AssetGroup
     * @author YLQ  2019-07-26 17:38:21
     */
    @GetMapping(value = "/v1/assetgroup" )
    public List<AssetGroup> findAllAssetGroup(HttpServletRequest req){
        Finder finder = FinderFactory.createFromRequestParamAccordingEntityClass(req, AssetGroup.class);
        List<AssetGroup> byFinder = assetGroupService.findByFinder(finder);
        return assetGroupService.findByFinder(finder);
    }

    /**
    * <p>根据Id 查询相应资产</p>
    * @param id 主键
    * @return 资产组
    * @author YLQ 2019-07-26 15:38:21
    */
    @GetMapping(value = "/v1/assetgroup/{id}")
    public AssetGroup findById(@PathVariable("id") String id) {
        return assetGroupService.findById(id);
    }



    /**
     * <p>新增资产组表</p>
     * @param assetGroup 需要新增的数据
     * @return 实体
     * @author YLQ  2019-07-26 17:38:21
     */
    @PostMapping(value = "/v1/assetgroup")
    public AssetGroup create(@RequestBody AssetGroup assetGroup) {
        return assetGroupService.create(assetGroup);

    }

    /**
     * <p>删除资产组表 资产假删除</p>
     * @param  ids 主键
     * @author YLQ  2019-07-26 17:38:21
     */
    @DeleteMapping(value = "/v1/assetgroup/{ids}")
    public void deleteById(@PathVariable("ids") String[] ids) throws Exception {
        assetGroupService.delete(ids);
    }

    /**
     * <p>更新资产组表</p>
     * @param id 主键
     * @return 实体
     * @author YLQ  2019-07-26 17:38:21
     */
    @PatchMapping(value = "/v1/assetgroup/{id}")
    public AssetGroup update (@PathVariable("id") String id,@RequestBody AssetGroup assetGroup) throws Exception {
        assetGroup.setId(id);
        return assetGroupService.patchUpdate(assetGroup);
    }





}