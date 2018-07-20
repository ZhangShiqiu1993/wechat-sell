package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import com.imooc.service.PayService;
import com.imooc.utils.JsonUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】发起支付，request={}", JsonUtil.toJson(payRequest));

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】发起支付，response={}", JsonUtil.toJson(payResponse));

        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData) {

        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知，payResponse={}", JsonUtil.toJson(payResponse));

        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());

        if (orderDTO == null) {
            log.error("【微信支付】异步通知, 订单不存在， orderId={}", payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        if (!orderDTO.getOrderAmount().equals(payResponse.getOrderAmount())) {
            log.error("【微信支付】异步通知，订单金额不一致，orderId={}, 微信通知金额={}， 系统金额={}",
                    payResponse.getOrderId(), payResponse.getOrderAmount(), orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }

        orderService.paid(orderDTO);

        return payResponse;
    }
}
