package com.tydic.cloud.billing.ie.busi;

import com.tydic.cloud.billing.ie.common.BusiAnswer;

/**
 * Created by fzw on 19/5/23.
 */
public class NumberPortAnswer extends BusiAnswer {
    private String dealerCode;

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    @Override
    public String toString() {
        return "NumberPortAnswer{" +
                "dealerCode='" + dealerCode + '\'' +
                "} " + super.toString();
    }
}
