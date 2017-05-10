package com.cc.entity;

/**
 * location
 */
public class Location {

    /**

     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 经度
     */
    private double lng;

    /**
     * 纬度
     */
    private double lat;

    /**
     * 创建时间
     */
    private String createtime;

    /**

     */
    private String address;

    //分页
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
