package com.tydic.cloud.billing.ie.busi;

import com.tydic.cloud.billing.api.Loggable;
import com.tydic.cloud.billing.api.cache.INumberPortabilityCache;
import com.tydic.cloud.billing.api.cache.NumberPortability;
import com.tydic.cloud.billing.ie.IEnhanceBusiService;
import com.tydic.cloud.billing.share.exception.BusiException;

import javax.annotation.Resource;

/**
 * Created by fzw on 19/5/23.
 */
public class NumberPortServiceImpl extends Loggable implements IEnhanceBusiService<NumberPortRequest, NumberPortAnswer> {
    @Resource
    private INumberPortabilityCache numberPortabilityCache;

    @Override
    public NumberPortAnswer call(NumberPortRequest request) throws BusiException {
        NumberPortAnswer answer = new NumberPortAnswer();
        NumberPortability result = numberPortabilityCache.getEntity(request.getServiceNumber(), request.getBeginTime());
        if (result != null)
            answer.setDealerCode(result.getDealerCode());
        else
            answer.setDealerCode(request.getDealerCode());
        return answer;
    }
}
