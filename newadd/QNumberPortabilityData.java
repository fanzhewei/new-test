package com.tydic.cloud.billing.intf.pojo;

/**
 * Created by fzw on 19/5/22.
 */
public class QNumberPortabilityData extends NumberPortabilityData {
    private String rowid;

    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid;
    }

    @Override
    public String toString() {
        return "QNumberPortabilityData{" +
                "rowid='" + rowid + '\'' +
                "} " + super.toString();
    }
}
