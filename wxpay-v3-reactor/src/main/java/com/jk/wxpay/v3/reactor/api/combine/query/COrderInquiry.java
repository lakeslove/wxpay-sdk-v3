package com.jk.wxpay.v3.reactor.api.combine.query;

import com.jk.wxpay.v3.commons.Constants;
import com.jk.wxpay.v3.commons.bean.combine.result.COrderQueryResult;
import com.jk.wxpay.v3.commons.bean.direct.result.OrderQueryResult;
import com.jk.wxpay.v3.reactor.api.direct.query.OrderQuery;
import com.jk.wxpay.v3.reactor.request.ApiContext;
import com.jk.wxpay.v3.reactor.request.SingleRequester;
import reactor.core.publisher.Mono;

import static com.jk.wxpay.v3.commons.util.RequestUtils.createHeadersWith;
import static com.jk.wxpay.v3.commons.util.RequestUtils.createParamsWith;

/**
 * 合单查询， 按照订单号查询。
 */
public class COrderInquiry extends SingleRequester<Void, COrderQueryResult>  {

    /**
     * 构造方法。
     * @param apiContext
     */
    public COrderInquiry(ApiContext apiContext) {
        super(apiContext, Constants.PATH_COMBINE_ORDER_GET_OUT_TRADE_NO, Void.class, COrderQueryResult.class);
    }

    public Mono<COrderQueryResult> query(String mchId, String id) {
        return super.get("/" + id, createParamsWith(mchId), createHeadersWith(mchId));
    }
}