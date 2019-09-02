package com.sbr.asset.preparation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
* 描述：预备资产对象表模型
* @author YLQ
* @date 2019-07-26 10:02:04
*/
//@Data
@Entity
@Table(name="asset_object_pre")
public class AssetObjectPre {

    /**   
    *资产uuid_id
    */
    @JsonProperty(value = "id")
    @Id
    private String id;


    /**
    *资产类型ID
    */
    @JsonProperty(value = "type_id")
    private String typeId;
    /**
    *资产类型Code
    */
    @JsonProperty(value = "type_code")
    private String typeCode;

    /**
    *资产型号
    */
    @JsonProperty(value = "code")
    private String code;

    /**
    *操作系统
    */
    @JsonProperty(value = "os")
    private String os;

    /**
    *操作系统版本
    */
    @JsonProperty(value = "os_version")
    private String osVersion;

    /**
    *固件
    */
    @JsonProperty(value = "firmware")
    private String firmware;

    /**
    *资产名称
    */
    @JsonProperty(value = "asset_name")
    private String assetName;

    /**
    *资产主IP
    */
    @JsonProperty(value = "ip")
    private String ip;

    /**
    *资产管理IP或主IP默认网关
    */
    @JsonProperty(value = "mask")
    private String mask;

    /**
    *资产管理IP接口的MAC地址
    */
    @JsonProperty(value = "mac")
    private String mac;

    /**
    *资产主机名
    */
    @JsonProperty(value = "hostname")
    private String hostname;

    /**
    *资产联系人
    */
    @JsonProperty(value = "contact")
    private String contact;

    /**
    *资产地理位置
    */
    @JsonProperty(value = "location")
    private String location;

    /**
    *资产生产厂商
    */
    @JsonProperty(value = "manufacturer")
    private String manufacturer;

    /**
    *资产质保开始日期
    */
    @JsonProperty(value = "warranty_from")
    private Date warrantyFrom;
    /**
    *资产质保结束日期
    */
    @JsonProperty(value = "warranty_to")
    private Date warrantyTo;
    /**
    *资产序列号
    */
    @JsonProperty(value = "sn")
    private String sn;

    /**
    *资产形态：0物理设备/1虚拟设备
    */
    
    @JsonProperty(value = "is_virtual")
    private Integer isVirtual;
    
    /**
    *当资产为数据库、中间件、虚拟资产时，宿主主机资产ID
    */
    
    @JsonProperty(value = "host_on")
    private Integer hostOn;
    /**
    *资产所属区域/单位
    */
    @JsonProperty(value = "area")
    private String area;

    /**
    *资产状态：1在线，0下线
    */
    @JsonProperty(value = "status")
    private Integer status;
    
    /**
    *资产描述
    */
    @JsonProperty(value = "description")
    private String description;

    /**
    *资产创建时间
    */
    @JsonProperty(value = "created")
    private Date created;
    /**
    *资产最后修改时间
    */
    @JsonProperty(value = "modified")
    private Date modified;
    /**
    *资产机密性 低：0，中等：2，高：3，极高：4
    */
    @JsonProperty(value = "confidentiality")
    private Integer confidentiality;
    /**
    *资产完整性 低：0，中等：2，高：3，极高：4
    */
    @JsonProperty(value = "integrity")
    private Integer integrity;
    /**
    *资产可用性 低：0，中等：2，高：3，极高：4
    */
    @JsonProperty(value = "availability")
    private Integer availability;
    /**
    *资产价值，NULL时代表自动计算资产价值，资产价值划分为五个等级：低：0、中低：1、高：2、中高：3、高：4
    */
    @JsonProperty(value = "value")
    private Integer value;
    /**
    *资产等保级别：xxx即代表SxAxGx  
    */
    @JsonProperty(value = "grade")
    private Integer grade;

    /**
    *资产所属资产组级次码，格式为: /1/22/85/+资产ID 
    */
    @JsonProperty(value = "levelcode")
    private String levelcode;

    /**
    *当资产从第三方同步时记录的第三方资产编号
    */
    @JsonProperty(value = "third_code")
    private String thirdCode;

    /**
    *预备资产来源类型：0.录入或导入 1.事件 2.漏洞 3.自动发现 4.流量
    */
    @JsonProperty(value = "third_type")
    private Integer thirdType;
    /**
    *所属组织机构
    */
    @JsonProperty(value = "create_org_id")
    private String createOrgId;

    /**
    *物理位置
    */
    @JsonProperty(value = "physics_position")
    private String physicsPosition;

    /**
    *资产得分
    */ 
    @JsonProperty(value = "asset_score")
    private Float assetScore;
    /**
    *是否国内 是：1，否：0，不确定：9
    */
    @JsonProperty(value = "is_domestic")
    private Integer isDomestic;

    /**
    *所属部门
    */
    @JsonProperty(value = "department")
    private String department;

    /**
    *资产编号
    */
    @JsonProperty(value = "asset_code")
    private String assetCode;

    /**
    *创建人
    */
    @JsonProperty(value = "create_man")
    private String createMan;

    /**
    *创建时间
    */
    @JsonProperty(value = "create_time")
    private Date createTime;
    
    /**
    *修改人
    */
    @JsonProperty(value = "update_man")
    private String updateMan;
    /**
    *更新时间
    */
    @JsonProperty(value = "update_time")
    private Date updateTime;

    /**
     *逻辑删除
     */
//    @JsonProperty(value = "is_del")
//    private Integer is_del;

    /**
     *标签名称
     */
    @JsonProperty(value = "asset_tag_name")
    private String assetTagName;

    /**
     *接口IP
     */
    @JsonProperty(value = "inter_ip")
    private String interIp;

    /**
     *接口MAC
     */
    @JsonProperty(value = "inter_mac")
    private String interMac;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getWarrantyFrom() {
        return warrantyFrom;
    }

    public void setWarrantyFrom(Date warrantyFrom) {
        this.warrantyFrom = warrantyFrom;
    }

    public Date getWarrantyTo() {
        return warrantyTo;
    }

    public void setWarrantyTo(Date warrantyTo) {
        this.warrantyTo = warrantyTo;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Integer isVirtual) {
        this.isVirtual = isVirtual;
    }

    public Integer getHostOn() {
        return hostOn;
    }

    public void setHostOn(Integer hostOn) {
        this.hostOn = hostOn;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getConfidentiality() {
        return confidentiality;
    }

    public void setConfidentiality(Integer confidentiality) {
        this.confidentiality = confidentiality;
    }

    public Integer getIntegrity() {
        return integrity;
    }

    public void setIntegrity(Integer integrity) {
        this.integrity = integrity;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
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

    public String getThirdCode() {
        return thirdCode;
    }

    public void setThirdCode(String thirdCode) {
        this.thirdCode = thirdCode;
    }

    public Integer getThirdType() {
        return thirdType;
    }

    public void setThirdType(Integer thirdType) {
        this.thirdType = thirdType;
    }

    public String getCreateOrgId() {
        return createOrgId;
    }

    public void setCreateOrgId(String createOrgId) {
        this.createOrgId = createOrgId;
    }

    public String getPhysicsPosition() {
        return physicsPosition;
    }

    public void setPhysicsPosition(String physicsPosition) {
        this.physicsPosition = physicsPosition;
    }

    public Float getAssetScore() {
        return assetScore;
    }

    public void setAssetScore(Float assetScore) {
        this.assetScore = assetScore;
    }

    public Integer getIsDomestic() {
        return isDomestic;
    }

    public void setIsDomestic(Integer isDomestic) {
        this.isDomestic = isDomestic;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateMan() {
        return updateMan;
    }

    public void setUpdateMan(String updateMan) {
        this.updateMan = updateMan;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAssetTagName() {
        return assetTagName;
    }

    public void setAssetTagName(String assetTagName) {
        this.assetTagName = assetTagName;
    }

    public String getInterIp() {
        return interIp;
    }

    public void setInterIp(String interIp) {
        this.interIp = interIp;
    }

    public String getInterMac() {
        return interMac;
    }

    public void setInterMac(String interMac) {
        this.interMac = interMac;
    }
}