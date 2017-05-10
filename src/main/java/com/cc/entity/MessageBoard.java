package com.cc.entity;

/**
 * message_board
 */
public class MessageBoard {

    /**
     * 主键id
     */
    private Integer boardId;

    /**
     * 留言板内容
     */
    private String messageContent = "";

    /**
     * 创建时间
     */
    private String creatTime = "";

    /**

     */
    private String ip = "";

    /**
     * 城市
     */
    private String ipCity = "";

    /**
     * 关联user表
     */
    private Integer userId;

    /**
     * 国家
     */
    private String ipCountry = "";

    /**
     * 纬度
     */
    private String lat = "";

    /**
     * 经度
     */
    private String lon = "";

    /**
     * 国家编号
     */
    private String countryCode = "";

    /**
     * 地区
     */
    private String region = "";

    /**
     * 地区名字
     */
    private String regionName = "";

    /**
     * 状态
     */
    private String status = "";

    /**
     * 状态类型 关联config表
     */
    private String statusType = "";


    //分页
    private Page page;


    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpCity() {
        return ipCity;
    }

    public void setIpCity(String ipCity) {
        this.ipCity = ipCity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIpCountry() {
        return ipCountry;
    }

    public void setIpCountry(String ipCountry) {
        this.ipCountry = ipCountry;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
