package com.tydic.cloud.billing.api.cache.evict;

import java.io.Serializable;

/**
 * Created by fzw on 19/5/23.
 */
public class NumberPortabilityEvict implements Serializable {

    private String deviceNumber;

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    @Override
    public String toString() {
        return "NumberPortabilityRefresh{" +
                "deviceNumber='" + deviceNumber + '\'' +
                '}';
    }
}
