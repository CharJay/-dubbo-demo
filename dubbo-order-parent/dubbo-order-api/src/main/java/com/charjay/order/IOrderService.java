package com.charjay.order;

/**
 */
public interface IOrderService {

    /*
     * 下单操作
     */
    DoOrderResponse doOrder(DoOrderRequest request);

}
