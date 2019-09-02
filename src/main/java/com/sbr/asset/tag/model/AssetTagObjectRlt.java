package com.sbr.asset.tag.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 描述：标签与资产关系表模型
* @author YLQ
* @date 2019-07-29 17:41:02
*/
//@Data
@Entity
@Table(name="asset_tag_object_rlt")
public class AssetTagObjectRlt {

    /**
    *主键uuid_id
    */
    @JsonProperty(value = "id")
    @Id
    private String id;

    /**
    *标签
    */
    @JsonProperty(value = "tag_id")
    private String tagId;

    /**
    *资产uuid_asset_id
    */
    @JsonProperty(value = "asset_id")
    private String assetId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
}