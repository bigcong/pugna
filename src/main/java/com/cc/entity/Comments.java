package com.cc.entity;

/**
 * comments
 */
public class Comments {

    /**
     * ����id
     */
    private Integer commentsId;

    /**
     * ����id
     */
    private Integer blogId;

    /**
     * ��������
     */
    private String commentsTitle;

    /**
     * ��������
     */
    private String commentContent;

    /**
     * �ٱ�����
     */
    private Integer reportNum;

    /**
     * ϲ������
     */
    private Integer startNum;

    /**
     * ������id
     */
    private Integer parentId;

    /**
     * ����·��
     */
    private String commentsUrl;

    /**
     * ״̬
     */
    private String status;

    /**

     */
    private String ip;

    /**
     * ������
     */
    private Integer commentUser;

    /**

     */
    private java.util.Date createTime;

    /**
     * ������
     */
    private Integer createUser;

    /**

     */
    private java.util.Date updateTime;

    /**

     */
    private Integer updateUser;

    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getCommentsTitle() {
        return commentsTitle;
    }

    public void setCommentsTitle(String commentsTitle) {
        this.commentsTitle = commentsTitle;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getReportNum() {
        return reportNum;
    }

    public void setReportNum(Integer reportNum) {
        this.reportNum = reportNum;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(Integer commentUser) {
        this.commentUser = commentUser;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public java.util.Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

}
