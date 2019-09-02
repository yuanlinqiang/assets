package com.sbr.asset.tag.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sbr.asset.group.model.AssetGroup;
import com.sbr.asset.type.model.AssetType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
* 描述：标签组表模型
* @author yuan
* @date 2019-07-26 17:39:52
*/
//@Data
@Entity
@Table(name="asset_tag_group")
public class AssetTagGroup {

    /**
    *标签组id
    */
    @JsonProperty(value = "id")
    @Id
    private String id;

    /**
     *当前资产组节点的父级节点ID,顶级节点为0
     */
    @JsonProperty(value = "parent_id")
    private String parentId;

    /**
     *当前资产组节点的父级节点ID,顶级节点为0
     */
    @JsonProperty(value = "root_id")
    private String rootId;

    
    /**
    *标签组名称
    */
    @JsonProperty(value = "tag_group_name")
    private String tagGroupName;

    /**
    *当前标签组节点级次码，包括本节点ID,格式为:/1/22/85/
    */
    @JsonProperty(value = "levelcode")
    private String levelcode;

    /**
    *图标文件路径
    */
    @JsonProperty(value = "icon")
    private String icon;

    /**
    *使用fonticon显示图标
    */
    @JsonProperty(value = "icon_Class")
    private String iconClass;

    /**
    *标签组显示顺序
    */
    @JsonProperty(value = "display_index")
    private Integer displayIndex;

    /**
    *标签组创建人员ID
    */  
    @JsonProperty(value = "creator_id")
    private Integer creatorId;
    /**
    *标签组创建时间
    */
    @JsonProperty(value = "created")
    private Date created;
    /**
    *最后修改时间
    */
    @JsonProperty(value = "modified")
    private Date modified;
    /**
    *标签组描述
    */
    @JsonProperty(value = "description")
    private String description;


    @OneToMany(fetch=FetchType.EAGER,mappedBy= "groupTagId",orphanRemoval=true)
    private Set<AssetTag> assetTagSet;

    //用于传递给前端到数据，子数据类集合
    @Transient
    private List<AssetTag> children= new ArrayList<AssetTag>();



    public List<AssetTag> getChildren() {
        return children;
    }

    public void setChildren(List<AssetTag> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRootId() {
        return rootId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }

    public String getTagGroupName() {
        return tagGroupName;
    }

    public void setTagGroupName(String tagGroupName) {
        this.tagGroupName = tagGroupName;
    }

    public String getLevelcode() {
        return levelcode;
    }

    public void setLevelcode(String levelcode) {
        this.levelcode = levelcode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public Integer getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(Integer displayIndex) {
        this.displayIndex = displayIndex;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<AssetTag> getAssetTagSet() {
        return assetTagSet;
    }

    public void setAssetTagSet(Set<AssetTag> assetTagSet) {
        this.assetTagSet = assetTagSet;
    }
}