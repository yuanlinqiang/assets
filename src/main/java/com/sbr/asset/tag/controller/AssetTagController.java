package com.sbr.asset.tag.controller;


import com.sbr.asset.group.model.AssetGroup;
import com.sbr.asset.tag.model.AssetTag;
import com.sbr.asset.tag.model.AssetTagGroup;
import com.sbr.asset.tag.service.IAssetTagGroupService;
import com.sbr.asset.tag.service.IAssetTagService;
import com.sbr.common.finder.Finder;
import com.sbr.common.finder.FinderFactory;
import com.sbr.springboot.controller.BaseController;
import com.sbr.springboot.json.InfoJson;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
* 描述：标签组表控制层
* @author YLQ 2019-07-29 17:40:26
*/
@RestController
@RequestMapping("/sp-assets/api")
public class AssetTagController extends BaseController{


    @Autowired
    private IAssetTagGroupService assetTagGroupService;
    @Autowired
    private IAssetTagService assetTagService;

    /**
     * <p>根据Id 查询</p>
     * @param id 主键assettaggroups
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    @GetMapping(value = "/v1/assettaggroups/{id}")
    public AssetTagGroup findById(@PathVariable("id") String id) {
        return assetTagGroupService.findById(id);
    }



    /**
     * <p>分页查询</p>
     * @param req
     * @return  资产标签查询
     * @author YLQ  2019-07-26 17:38:21
     */
    @GetMapping(value = "/v1/assettaggroups" )
    public List<AssetTagGroup> findAllAssetGroup(HttpServletRequest req){
        Finder finder = FinderFactory.createFromRequestParamAccordingEntityClass(req, AssetGroup.class);
        List<AssetTagGroup> byFinder = assetTagGroupService.findByFinder(finder);
        return assetTagGroupService.findByFinder(finder);
    }


    /**
     * <p>查询标签数树状list</p>
     * @return 实体
     * @author YLQ 2019-07-29 16:10:48
     */
    @GetMapping(value = "/v1/assettaggroups/allAssetTags")
    public List<AssetTagGroup> findAssetTypeList(){
        List<AssetTagGroup> assetTypes = assetTagGroupService.findAllAssetTags();
        return assetTypes;
    }

    /**
     * <p>新增标签组表</p>
     * @param assetTagGroup 需要新增的数据
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    @PostMapping(value = "/v1/assettaggroups")
    public AssetTagGroup create(@RequestBody AssetTagGroup assetTagGroup) {
        return assetTagGroupService.create(assetTagGroup);
    }



    /**
     * <p>新增标签</p>
     * @param assetTag 需要新增的数据
     * @return 实体
     * @author YLQ 2019-05-16 17:40:26
     */
    @PostMapping(value = "/v1/assettaggroups/newtag")
    public AssetTag create(@RequestBody AssetTag assetTag) {
        AssetTag result = assetTagService.create(assetTag);
        result.setGroup_id(result.getGroupTagId().getId());
        return result;
    }

    /**
     * <p>新增标签</p>
     * @param assetTag 需要新增的数据
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    @PostMapping(value = "/v1/assettag")
    public AssetTag creates(@RequestBody AssetTag assetTag) {
        return assetTagService.create(assetTag);
    }

    /**
     * <p>删除标签组表</p>
     * @param ids 标签组主键
     * @author YLQ 2019-07-29 17:40:26
     */
    @DeleteMapping(value = "/v1/assettaggroups/{ids}")
    public InfoJson deleteById(@PathVariable  String[] ids) throws Exception {
        InfoJson infoJson = new InfoJson();
        List<String> idsStr = Arrays.asList(ids);
        assetTagGroupService.batchDelete(idsStr);
        infoJson.setSuccess(true);
        infoJson.setDescription("删除成功！");
        return infoJson;
    }

    /**
     * <p>删除标签表</p>
     * @param id 主键
     * @author YLQ 2019-07-29 17:40:26
     */
    @DeleteMapping(value = "/v1/assettag/{id}")
    public InfoJson deleteTagById(@PathVariable("id") String id) throws Exception {
        InfoJson infoJson = new InfoJson();
        assetTagService.delete(id);
        infoJson.setSuccess(true);
        infoJson.setDescription("删除成功！");
        return infoJson;
    }


    /**
     * <p>更新标签组表</p>
     * @param assetTagGroup 标签组
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    @PatchMapping(value = "/v1/assettaggroups/{id}")
    public AssetTagGroup update (@RequestBody AssetTagGroup assetTagGroup) throws Exception {
        return assetTagGroupService.patchUpdate(assetTagGroup);
    }

    /**
     * <p>更新标签表</p>
     * @param assetTag 标签
     * @return 实体
     * @author YLQ 2019-07-29 17:40:26
     */
    @PatchMapping(value = "/v1/assettag/{id}")
    public AssetTag update (@RequestBody AssetTag assetTag) throws Exception {
        return assetTagService.patchUpdate(assetTag);
    }




}