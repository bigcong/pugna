package com.cc.entity;

/**
 * currency
 */
public class Currency {

    /**

     */
    private Long id;

    /**

     */
    private Short currency_id;

    /**

     */
    private String currency_name;

    /**

     */
    private String create_time;

    /**

     */
    private Double amount;

    /**

     */
    private Double prepare_sub_amount;

    /**

     */
    private Double freeze_cash_amount;

    /**

     */
    private Double cash_amount;

    /**

     */
    private Double price = 0.0;


    //分页
    private Page page;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getCurrencyId() {
        return currency_id;
    }

    public void setCurrencyId(Short currency_id) {
        this.currency_id = currency_id;
    }

    public String getCurrencyName() {
        return currency_name;
    }

    public void setCurrencyName(String currency_name) {
        this.currency_name = currency_name;
    }

    public String getCreateTime() {
        return create_time;
    }

    public void setCreateTime(String create_time) {
        this.create_time = create_time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrepareSubAmount() {
        return prepare_sub_amount;
    }

    public void setPrepareSubAmount(Double prepare_sub_amount) {
        this.prepare_sub_amount = prepare_sub_amount;
    }

    public Double getFreezeCashAmount() {
        return freeze_cash_amount;
    }

    public void setFreezeCashAmount(Double freeze_cash_amount) {
        this.freeze_cash_amount = freeze_cash_amount;
    }

    public Double getCashAmount() {
        return cash_amount;
    }

    public void setCashAmount(Double cash_amount) {
        this.cash_amount = cash_amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
