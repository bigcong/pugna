package com.cc.entity;

/**
 * blog
 */
public class Blog {

    /**
     * ����id������
     */
    private Integer blogId;

    /**
     * ���ͱ���
     */
    private String blogTitle;

    /**
     * ��������
     */
    private String blogDescription;

    /**
     * ������
     */
    private Integer createUser;

    /**
     * ����ʱ��
     */
    private java.util.Date createTime;

    /**
     * ������
     */
    private Integer updateUser;

    /**
     * ����ʱ��
     */
    private java.util.Date updateTime;

    /**
     * ��������
     */
    private Integer blogger;

    /**
     * ��������
     */
    private Integer blogType;

    /**

     */
    private Integer start;

    /**
     * ��������
     */
    private String blogContent;

    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public java.util.Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getBlogger() {
        return blogger;
    }

    public void setBlogger(Integer blogger) {
        this.blogger = blogger;
    }

    public Integer getBlogType() {
        return blogType;
    }

    public void setBlogType(Integer blogType) {
        this.blogType = blogType;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

}
