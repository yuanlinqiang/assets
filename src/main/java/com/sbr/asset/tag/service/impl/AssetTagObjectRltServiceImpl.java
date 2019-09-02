package com.sbr.asset.tag.service.impl;


import com.sbr.asset.tag.dao.IAssetTagObjectRtlDAO;
import com.sbr.asset.tag.model.AssetTagObjectRlt;
import com.sbr.asset.tag.service.IAssetTagObjectRltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 描述：标签表 服务实现层
* @author YLQ
* @date 2019-07-29 17:39:52
*/
//标记为Service类
@Service
public class AssetTagObjectRltServiceImpl implements IAssetTagObjectRltService {


    @Autowired
    private IAssetTagObjectRtlDAO assetTagObjectRtlDAO;

    @Override
    public List<AssetTagObjectRlt> findAll() {
        return assetTagObjectRtlDAO.findAll();
    }


    @Override
    public List<String> findTagsByAssetID(String assetID) {
        return assetTagObjectRtlDAO.findTagsByAssetID(assetID);
    }

    @Override
    public void deleteTagsByAssetID(String assetID) {
        assetTagObjectRtlDAO.deleteTagsByAssetID(assetID);
    }
}