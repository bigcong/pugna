package com.cc.entity;

public class ChartCallRecordsData {
    private String ownerMobile;//通话记录拥有者

    private String date;//日期时间

    private Integer callOut;//呼出

    private Integer callIn;//呼入

    private Integer missed;//未接

    private String name;//通话者

    private String number;//通话者号码

    private Integer total;//总共

    private Double point;


    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getMissed() {
        return missed;
    }

    public void setMissed(Integer missed) {
        this.missed = missed;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setCallOut(Integer callOut) {
        this.callOut = callOut;
    }

    public void setCallIn(Integer callIn) {
        this.callIn = callIn;
    }

    public void setOwnerMobile(String ownerMobile) {
        this.ownerMobile = ownerMobile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getOwnerMobile() {
        return ownerMobile;
    }

    public Integer getCallOut() {
        return callOut;
    }

    public Integer getCallIn() {
        return callIn;
    }

    public void setName(String name) {
        this.name = name;
    }

}
