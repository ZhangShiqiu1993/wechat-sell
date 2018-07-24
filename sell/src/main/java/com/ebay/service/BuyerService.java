package com.ebay.service;

import com.ebay.dto.OrderDTO;

public interface BuyerService {
    OrderDTO findOrderOne(String openid, String orderId);

    OrderDTO cancelOrder(String openid, String orderId);
}
