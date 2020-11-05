package com.tydic.cloud.billing.api.cache;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by fzw on 19/5/23.
 */
public interface INumberPortabilityCache extends ICacheEvict {
    /**
     * 获取最近的对象
     *
     * @param deviceNumber
     * @return
     */
    NumberPortability getEntity(String deviceNumber);

    /**
     * 获取设备对象
     *
     * @param deviceNumber
     * @param effDate
     * @return
     */
    NumberPortability getEntity(String deviceNumber, Timestamp effDate);

    /**
     * 获取设备相关的所有对象
     *
     * @param deviceNumber
     * @return
     */
    List<NumberPortability> getEntities(String deviceNumber);

    /**
     * 删除缓存
     *
     * @param deviceNumber
     */
    void evict(String deviceNumber);
}
