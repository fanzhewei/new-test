package com.tydic.cloud.billing.api.cache;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by fzw on 19/5/23.
 */
public class NumberPortability implements Serializable {
    private String deviceNumber; // 设备号码
    private String dealerCode;//运营商代码
    private Timestamp effDate; // 生效时间
    private Timestamp expDate; // 失效时间

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public Timestamp getEffDate() {
        return effDate;
    }

    public void setEffDate(Timestamp effDate) {
        this.effDate = effDate;
    }

    public Timestamp getExpDate() {
        return expDate;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }
    @Override
    public String toString() {
        return "NumberPortabilityData{" +
                "deviceNumber='" + deviceNumber + '\'' +
                ", dealerCode=" + dealerCode +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                '}';
    }
}
