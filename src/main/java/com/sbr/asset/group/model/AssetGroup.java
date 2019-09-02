package com.sbr.asset.group.model;
import javax.persistence.*;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
* 描述：资产组表模型
* @author YLQ
* @date 2019-07-29 17:38:21
*/
//@Data
@Entity
@Table(name="asset_group")
public class AssetGroup {

    /**
    *资产组uuid_id
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
    *资产组名称
    */
    @JsonProperty(value = "asset_group_name")
    private String assetGroupName;

    /**
    *资产组内资产的价值
    */
    
    @JsonProperty(value = "value")
    private Integer value;
    
    /**
    *资产组的等保级别
    */
    @JsonProperty(value = "grade")
    private Integer grade;

    /**
    *当前资产组节点级次码，包括本节点ID,格式为:/1/22/85/
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
    @JsonProperty(value = "iconclass")
    private String iconclass;

    /**
    *资产组显示顺序
    */
    @JsonProperty(value = "display_index")
    private Integer displayIndex;

    /**
    *资产组创建时间
    */
    
    @JsonProperty(value = "created")
    private Date created;
    /**
    *资产组最后修改时间
    */
    @JsonProperty(value = "modified")
    private Date modified;
    /**
    *资产组描述
    */
    @JsonProperty(value = "description")
    private String description;
	
	//用于传递给前端到数据，不作为数据库字段映射
	@Transient
    private List<AssetGroup> children= new ArrayList<AssetGroup>();

    //用于传递给前端到数据，1 创建子节点 2根节点
    @Transient
    private String  addAssetGroupNum;


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

    public String getAssetGroupName() {
        return assetGroupName;
    }

    public void setAssetGroupName(String assetGroupName) {
        this.assetGroupName = assetGroupName;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
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

    public String getIconclass() {
        return iconclass;
    }

    public void setIconclass(String iconclass) {
        this.iconclass = iconclass;
    }

    public Integer getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(Integer displayIndex) {
        this.displayIndex = displayIndex;
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

    public List<AssetGroup> getChildren() {
        return children;
    }

    public void setChildren(List<AssetGroup> children) {
        this.children = children;
    }

    public String getAddAssetGroupNum() {
        return addAssetGroupNum;
    }

    public void setAddAssetGroupNum(String addAssetGroupNum) {
        this.addAssetGroupNum = addAssetGroupNum;
    }
}