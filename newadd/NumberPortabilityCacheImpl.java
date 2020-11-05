package com.tydic.cloud.billing.api.cache;

import com.tydic.cloud.billing.api.GsonUtils;
import com.tydic.cloud.billing.api.Loggable;
import com.tydic.cloud.billing.api.TimestampUtils;
import com.tydic.cloud.billing.api.cache.evict.NumberPortabilityEvict;
import com.tydic.cloud.billing.api.dao.INumberPortabilityDao;
import com.tydic.cloud.billing.api.pojo.NumberPortabilityData;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzw on 19/5/23.
 */
public class NumberPortabilityCacheImpl  extends Loggable implements INumberPortabilityCache {
    @Resource
    private INumberPortabilityDao numberPortabilityDao;
    @Resource
    private ApplicationContext applicationContext;

    private INumberPortabilityCache self;

    @PostConstruct
    public void init() {self = applicationContext.getBean(INumberPortabilityCache.class);}

    @Override
    public NumberPortability getEntity(String deviceNumber) {
        List<NumberPortability> numberPortabilitys = self.getEntities(deviceNumber);

        NumberPortability target = null;
        for (NumberPortability numberPortability : numberPortabilitys) {
            if (target == null || TimestampUtils.after(numberPortability.getEffDate(), target.getEffDate()))
                target = numberPortability;
        }

        return target;
    }

    @Override
    public NumberPortability getEntity(String deviceNumber, Timestamp effDate) {
        List<NumberPortability> numberPortabilitys = self.getEntities(deviceNumber);

        for (NumberPortability numberPortability : numberPortabilitys) {
            if (TimestampUtils.valid(effDate, numberPortability.getEffDate(), numberPortability.getExpDate()))
                return numberPortability;
        }

        return null;
    }

    @Override
    @Cacheable(value = "numberPortability", key = "#deviceNumber")
    public List<NumberPortability> getEntities(String deviceNumber) {
        NumberPortabilityData request = new NumberPortabilityData();
        request.setDeviceNumber(deviceNumber);

        List<NumberPortability> numberPortabilitys = new ArrayList<>();
        List<NumberPortabilityData> numberPortabilityDatas = numberPortabilityDao.getEntities(request);
        for (NumberPortabilityData numberPortabilityData : numberPortabilityDatas) {
            NumberPortability numberPortability = new NumberPortability();
            numberPortability.setDealerCode(numberPortabilityData.getDealerCode());
            numberPortability.setEffDate(numberPortabilityData.getEffDate());
            numberPortability.setExpDate(numberPortabilityData.getExpDate());

            numberPortabilitys.add(numberPortability);
        }

        return numberPortabilitys;
    }
    @Override
    @CacheEvict(value = "numberPortability", key = "#deviceNumber")
    public void evict(String deviceNumber) {
        logger.debug("NumberPortability cache clear");
    }

    @Override
    public Class<?> getEvictClass() {
        return NumberPortabilityEvict.class;
    }

    @Override
    public void evictObject(String json) {
        NumberPortabilityEvict object = GsonUtils.fromJson(json, NumberPortabilityEvict.class);

        self.evict(object.getDeviceNumber());
    }

    @Override
    @CacheEvict(value = "numberPortability", allEntries = true)
    public void evict() {
        logger.debug("NumberPortability cache clear");
    }
}
