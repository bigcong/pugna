package com.cc.entity;

/**
 * call_records
 */
public class CallRecords {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 通话记录id
     */
    private Integer callId;

    /**
     * 是否查看
     */
    private Integer isRead;

    /**
     * 1 呼入  2  呼出   3 未接
     */
    private Integer type;

    /**
     * 电话号码
     */
    private String number;

    /**
     * 通话人
     */
    private String name;

    /**
     * 通话时长
     */
    private Integer duration;

    /**

     */
    private String date;

    /**

     */
    private Integer callNew;

    /**

     */
    private Integer callCount;

    /**

     */
    private String cachedPhotoUri;

    /**
     * 拥有者id
     */
    private Integer ownerId;

    /**
     * 拥有者电话号码
     */
    private String ownerMobile;

    //分页
    private Page page;
    private String dateEnd;
    private String dateBegin;

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCallId() {
        return callId;
    }

    public void setCallId(Integer callId) {
        this.callId = callId;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCallNew() {
        return callNew;
    }

    public void setCallNew(Integer callNew) {
        this.callNew = callNew;
    }

    public Integer getCallCount() {
        return callCount;
    }

    public void setCallCount(Integer callCount) {
        this.callCount = callCount;
    }

    public String getCachedPhotoUri() {
        return cachedPhotoUri;
    }

    public void setCachedPhotoUri(String cachedPhotoUri) {
        this.cachedPhotoUri = cachedPhotoUri;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerMobile() {
        return ownerMobile;
    }

    public void setOwnerMobile(String ownerMobile) {
        this.ownerMobile = ownerMobile;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
