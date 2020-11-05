package com.tydic.cloud.billing.ie.busi;

import java.sql.Timestamp;

/**
 * Created by fzw on 19/5/23.
 */
public class NumberPortRequest {
    private String serviceNumber;
    private String dealerCode;
    private Timestamp beginTime;

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    @Override
    public String toString() {
        return "NumberPortRequest{" +
                "serviceNumber='" + serviceNumber + '\'' +
                ", dealerCode=" + dealerCode +
                ", beginTime=" + beginTime +
                '}';
    }
}
