package com.sbr.asset.type.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
* 描述：资产类型表模型
* @author YLQ
* @date 2019-07-26 10:10:48
*/
//@Data
@Entity
@Table(name="asset_type")
public class AssetType {

    @JsonProperty(value = "id")
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "com.sbr.ms.springdata.keygenerator.KeyGenerator")
    private String id;

    /**
     *系统父节点0
     */
    @JsonProperty(value = "parent_id")
    private String parentId;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "root_id")
    private AssetType parent;


    @Transient
    private String root_id;


    /**
    *当前资产类型的父级节点ID,顶级节点为0
    */
    /**
    *资产类型名称
    */
    @JsonProperty(value = "asset_type_name")
    private String assetTypeName;

    /**
    *资产类型编码
    */
    @JsonProperty(value = "code")
    private String code;

    /**
    *资产类型的图标名称
    */
    @JsonProperty(value = "icon")
    private String icon;

    /**
    *使用fonticon显示图标
    */
    @JsonProperty(value = "iconclass")
    private String iconClass;

    /**
    *资产类型节点级次码，包括本节点ID,格式为:/1/22/85/
    */
    @JsonProperty(value = "levelcode")
    private String levelcode;

    /**
    *是否内置类型
    */
    @JsonProperty(value = "is_builtin")
    private Integer isBuiltin;
    /**
    *是否支持配置核查
    */
    @JsonProperty(value = "is_cvs")
    private Integer isCvs;
    /**
    *是否为通用类型
    */
    @JsonProperty(value = "is_common")
    private Integer isCommon;
    /**
    *显示顺序
    */
    @JsonProperty(value = "display_index")
    private Integer displayIndex;

    /**
    *创建时间
    */
    @JsonProperty(value = "created")
    private Date created;
    /**
    *最后修改时间
    */
    @JsonProperty(value = "modified")
    private Date modified;
    /**
    *资产类型描述
    */
    @JsonProperty(value = "description")
    private String description;

    //用于传递给前端到数据，不作为数据库字段映射
//  	@Transient
//    private List<AssetType> children= new ArrayList<AssetType>();

    @JsonIgnore
    @OneToMany(mappedBy="parent")
    private Set<AssetType> children;


    /**
     * 子节点
     */
    @JsonIgnore
    @Transient
    private List<AssetType> typeChildren = new ArrayList<AssetType>();

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

    public AssetType getParent() {
        return parent;
    }

    public void setParent(AssetType parent) {
        this.parent = parent;
    }

    public String getAssetTypeName() {
        return assetTypeName;
    }

    public void setAssetTypeName(String assetTypeName) {
        this.assetTypeName = assetTypeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getLevelcode() {
        return levelcode;
    }

    public void setLevelcode(String levelcode) {
        this.levelcode = levelcode;
    }

    public Integer getIsBuiltin() {
        return isBuiltin;
    }

    public void setIsBuiltin(Integer isBuiltin) {
        this.isBuiltin = isBuiltin;
    }

    public Integer getIsCvs() {
        return isCvs;
    }

    public void setIsCvs(Integer isCvs) {
        this.isCvs = isCvs;
    }

    public Integer getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(Integer isCommon) {
        this.isCommon = isCommon;
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

    public Set<AssetType> getChildren() {
        return children;
    }

    public void setChildren(Set<AssetType> children) {
        this.children = children;
    }

    public List<AssetType> getTypeChildren() {
        return typeChildren;
    }

    public void setTypeChildren(List<AssetType> typeChildren) {
        this.typeChildren = typeChildren;
    }

    public String getRoot_id() {
        return root_id;
    }

    public void setRoot_id(String root_id) {
        this.root_id = root_id;
    }
}