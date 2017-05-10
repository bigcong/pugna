package com.cc.entity;

/**
 * transaction_record
 */
public class TransactionRecord {

    /**
     * 交易号
     */
    private String transationNo;

    /**
     * 商户订单号
     */
    private String businessOrderNumber;

    /**
     * 交易创建时间
     */
    private String transationCreateTime;


    private String transationCreateTimeBegin="";
    private String transationCreateTimeEnd="";

    public String getTransationCreateTimeBegin() {
        return transationCreateTimeBegin;
    }

    public void setTransationCreateTimeBegin(String transationCreateTimeBegin) {
        this.transationCreateTimeBegin = transationCreateTimeBegin;
    }

    public String getTransationCreateTimeEnd() {
        return transationCreateTimeEnd;
    }

    public void setTransationCreateTimeEnd(String transationCreateTimeEnd) {
        this.transationCreateTimeEnd = transationCreateTimeEnd;
    }

    /**
     * 支付时间
     */
    private String paidTime;

    /**
     * 最近修改时间
     */
    private String lastModifiedTime;

    /**
     * 交易来源
     */
    private String transationSource;

    /**
     * 交易类型
     */
    private String transationType;

    /**
     * 交易对方
     */
    private String counterparty;

    /**
     * 商品名字
     */
    private String goodsName;

    /**
     * 金额
     */
    private Double amount;

    /**
     * 收支
     */
    private String paymentType;

    /**
     * 交易状态
     */
    private String transationStatus;

    /**
     * 服务费
     */
    private Double serviceCharge;

    /**
     * 成功退款
     */
    private Double successRefundAmount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 资金状态
     */
    private String fundStatus;


    //分页
    private Page page;


    public String getTransationNo() {
        return transationNo;
    }

    public void setTransationNo(String transationNo) {
        this.transationNo = transationNo;
    }

    public String getBusinessOrderNumber() {
        return businessOrderNumber;
    }

    public void setBusinessOrderNumber(String businessOrderNumber) {
        this.businessOrderNumber = businessOrderNumber;
    }

    public String getTransationCreateTime() {
        return transationCreateTime;
    }

    public void setTransationCreateTime(String transationCreateTime) {
        this.transationCreateTime = transationCreateTime;
    }

    public String getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getTransationSource() {
        return transationSource;
    }

    public void setTransationSource(String transationSource) {
        this.transationSource = transationSource;
    }

    public String getTransationType() {
        return transationType;
    }

    public void setTransationType(String transationType) {
        this.transationType = transationType;
    }

    public String getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(String counterparty) {
        this.counterparty = counterparty;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getTransationStatus() {
        return transationStatus;
    }

    public void setTransationStatus(String transationStatus) {
        this.transationStatus = transationStatus;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Double getSuccessRefundAmount() {
        return successRefundAmount;
    }

    public void setSuccessRefundAmount(Double successRefundAmount) {
        this.successRefundAmount = successRefundAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFundStatus() {
        return fundStatus;
    }

    public void setFundStatus(String fundStatus) {
        this.fundStatus = fundStatus;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
