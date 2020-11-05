package com.tydic.cloud.billing.intf.dao;

import com.tydic.cloud.billing.api.ds.DataSourcePhysical;
import com.tydic.cloud.billing.api.ds.IBaseGenericDao;
import com.tydic.cloud.billing.intf.pojo.QNumberPortabilityData;

/**
 * Created by fzw on 19/5/22.
 */
@DataSourcePhysical
public interface IQNumberPortabilityDao extends IBaseGenericDao<QNumberPortabilityData> {
}
