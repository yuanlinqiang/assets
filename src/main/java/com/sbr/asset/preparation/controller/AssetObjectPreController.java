package com.sbr.asset.preparation.controller;

import com.sbr.asset.preparation.model.AssetObjectPre;
import com.sbr.asset.preparation.service.IAssetObjectPreService;
import com.sbr.asset.util.DataTypeConversionUtil;
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
* 描述：预备资产对象表控制层
* @author YLQ 2019-05-15 10:10:16
*/
@RestController
@RequestMapping("/sp-assets/api")
public class AssetObjectPreController extends BaseController{

    @Autowired
    private IAssetObjectPreService assetObjectPreService;

    /**
     * <p>分页查询AssetObjectPre集合</p>
     * @author YLQ
     * @date 2019/7/29  14:02
     * @param req
     * @return AssetObjectPre集合
     */
    @GetMapping(value = "/v1/assetobjectpre")
    public List<AssetObjectPre> findAllAssetObjectPre(HttpServletRequest req){
        Finder finder = FinderFactory.createFromRequestParamAccordingEntityClass(req, AssetObjectPre.class);
        return assetObjectPreService.findByFinder(finder);
    }

    /**
     * <p>根据资产ID查询AssetObjectPre</p>
     * @author YLQ
     * @date 2019/7/29  14:02
     * @param  id
     * @return AssetObjectPre实体
     */
    @GetMapping(value = "/v1/assetobjectpre/{id}")
    public AssetObjectPre findById(@PathVariable("id") String id) {
        return assetObjectPreService.findById(id);
    }

    /**
    * <p>新增预备资产对象表</p>
    * @param assetObjectPre 需要新增的数据
    * @return AssetObjectPre
    * @author YLQ
    * @author 2019/7/29  14:02
    */
    @PostMapping(value = "/v1/assetobjectpre")
    public AssetObjectPre create(@RequestBody AssetObjectPre assetObjectPre) {
        return assetObjectPreService.create(assetObjectPre);
    }

    /**
    * <p>删除预备资产对象表</p>
    * @param ids 主键
    * @author YLQ 2019-05-15 10:10:16
    */
    @DeleteMapping(value = "/v1/assetobjectpre/{ids}")
    public InfoJson deleteById(@PathVariable("ids") String[] ids) throws Exception {
        InfoJson infoJson = new InfoJson();
        List<String> idsStr = Arrays.asList(ids);
        assetObjectPreService.deleteByListIds(idsStr);
        infoJson.setSuccess(true);
        infoJson.setDescription("删除成功！");
        return infoJson;

    }


    /**
    * <p>更新预备资产对象表</p>
    * @param id 主键
    * @return 实体
    * @author YLQ 2019-05-15 10:10:16
    */
    @PatchMapping(value = "/v1/assetobjectpre/{id}")
    public AssetObjectPre update (@PathVariable("id") String id,@RequestBody AssetObjectPre assetObjectPre) throws Exception {
        assetObjectPre.setId(id);
        return assetObjectPreService.patchUpdate(assetObjectPre);
    }
}