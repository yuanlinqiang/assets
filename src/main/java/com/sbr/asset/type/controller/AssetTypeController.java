package com.sbr.asset.type.controller;

import com.sbr.asset.type.model.AssetType;
import com.sbr.asset.type.service.IAssetTypeService;
import com.sbr.common.entity.Tree;
import com.sbr.common.finder.Finder;
import com.sbr.common.finder.FinderFactory;
import com.sbr.springboot.controller.BaseController;
import com.sbr.springboot.json.InfoJson;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述：资产类型表控制层
 *
 * @author YLQ 2019-07-26
 */
@RestController
@RequestMapping("/sp-assets/api")
public class AssetTypeController extends BaseController {

    @Autowired
    private IAssetTypeService assetTypeService;

    /**
     * <p>分页查询AssetType集合</p>
     *
     * @param req
     * @param res
     * @return AssetType集合
     * @author YLQ
     * @date 2019/5/23 0023 14:02
     */
    @GetMapping(value = "/v1/assettypes/typesfortree")
    public List<AssetType> findAllForTreeList(HttpServletRequest req, HttpServletResponse res) {
        Finder finder = FinderFactory.createFromRequestParamAccordingEntityClass(req, AssetType.class);
        return assetTypeService.findByFinder(finder);
    }

    /**
     * <p>查询资产类型树状结构数据</p>
     *
     * @return 实体
     * @author YLQ 2019-07-29 16:10:48
     */
    @GetMapping(value = "/v1/assettypes/trees")
    public List<Tree> trees(HttpServletRequest req, HttpServletResponse res) {
        List<Tree> trees = new ArrayList<Tree>();
        Finder finder = FinderFactory.createFromRequestParamAccordingEntityClass(req, AssetType.class);
        //查询所有菜单
        List<AssetType> menuAllList = assetTypeService.findByFinder(finder);
        //构建子节点
        assetTypeService.structureMenuChildren(menuAllList);
        for (AssetType menu : menuAllList) {
            if (menu.getParent()==null) {
                trees.add(assetTypeService.constructTree(menu));
            }
        }
        return trees;
    }


    /**
     * <p>查询所有集合</p>
     *
     * @return 实体
     * @author YLQ 2019-07-29 16:10:48
     */
    @GetMapping(value = "/v1/assettypes/typeList")
    public List<AssetType> findAllAssetTypeList() {
        List<AssetType> assetTypes = assetTypeService.findAssetTypeList();
        return assetTypes;
    }

    /**
     * <p>查询树状list</p>
     *
     * @return 实体
     * @author YLQ 2019-07-29 16:10:48
     */
    @GetMapping(value = "/v1/assettypes/allAssetTypes")
    public List<AssetType> findAssetTypeList() {
        List<AssetType> assetTypes = assetTypeService.findAllAssettype();
        return assetTypes;
    }

    /**
     * <p>查询资产类型层级list</p>
     *
     * @return 实体
     * @author YLQ 2019-07-29
     */
    @GetMapping(value = "/v1/assettypes/parenttypes")
    public List<AssetType> findAllParent() {
        List<AssetType> parent = assetTypeService.findParent();
        return parent;
    }

    /**
     * <p>根据Id 查询</p>
     *
     * @param id 主键
     * @return 实体
     * @author YLQ 2019-07-26 10:10:48
     */
    @GetMapping(value = "/v1/assettypes/{id}")
    public AssetType findById(@PathVariable("id") String id) {
        return assetTypeService.findById(id);
    }

    /**
     * <p>新增资产类型表</p>
     *
     * @param assetType 需要新增的数据
     * @return 实体
     * @author YLQ 2019-07-26 10:10:48
     */
    @PostMapping(value = "/v1/assettypes")
    public AssetType create(@RequestBody AssetType assetType) {
        assetType = assetTypeService.create(assetType);
        return assetType;
    }

    /**
     * <p>删除资产类型表</p>
     *
     * @param ids 主键
     * @author YLQ 2019-07-26 10:10:48
     */
    @DeleteMapping(value = "/v1/assettypes/{ids}")
    public InfoJson deleteById(@PathVariable("ids") String[] ids) throws Exception {
        InfoJson infoJson = new InfoJson();
        List<String> typeIds = Arrays.asList(ids);
        assetTypeService.deleteByListIds(typeIds);
        infoJson.setSuccess(true);
        infoJson.setDescription("删除成功！");
        return infoJson;
    }

    /**
     * <p>更新资产类型表</p>
     * @param id 主键
     * @return 实体
     * @author YLQ 2019-07-26 10:10:48
     */
    @PatchMapping(value = "/v1/assettypes/{id}")
    public AssetType update(@PathVariable("id") String id, @RequestBody AssetType assetType) throws Exception {
        assetType.setId(id);
        return assetTypeService.patchUpdate(assetType);
    }

}