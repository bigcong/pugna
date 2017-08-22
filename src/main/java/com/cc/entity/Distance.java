package com.cc.entity;

/**
 * distance
 */
public class Distance {

    /**

     */
    private String createTime;

    /**

     */
    private Double amount;


    //分页
    private Page page;


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
