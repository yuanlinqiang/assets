package com.sbr.asset.tag.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
* 描述：标签表模型
* @author yuan
* @date 2019-07-26 17:39:52
*/
//@Data
@Entity
@Table(name="asset_tag")
public class AssetTag {

    /**
    *主键ID
    */
    @JsonProperty(value = "id")
    @Id
    private String id;

    /**
    *标签组
    */

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="group_id")
    private AssetTagGroup groupTagId;

    @Transient
    private String group_id;




    /**
     *标签名称
     */
    @JsonProperty(value = "tag_name")
    private String tagName;



    /**
    *标签颜色值(十六进制)
    */
    @JsonProperty(value = "color")
    private String color;

    /**
    *标签显示顺序
    */
    @JsonProperty(value = "display_index")
    private Integer displayIndex;

    /**
    *标签创建时间
    */  
    @JsonProperty(value = "created")
    private Date created;
    /**
    *标签创建人员ID
    */
    @JsonProperty(value = "creator_id")
    private Integer creatorId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AssetTagGroup getGroupTagId() {
        return groupTagId;
    }

    public void setGroupTagId(AssetTagGroup groupTagId) {
        this.groupTagId = groupTagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }


}