package com.tydic.cloud.billing.api.dao;

import com.tydic.cloud.billing.api.IBaseTargetDao;
import com.tydic.cloud.billing.api.ds.DataSourceMemory;
import com.tydic.cloud.billing.api.pojo.NumberPortabilityData;

/**
 * Created by fzw on 19/5/23.
 * 查找携号转网的运营商信息
 */
@DataSourceMemory
public interface INumberPortabilityDao extends IBaseTargetDao<NumberPortabilityData> {
}
