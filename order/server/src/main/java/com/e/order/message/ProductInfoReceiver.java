package com.e.order.message;

import com.e.order.utils.JsonUtil;
import com.e.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductInfoReceiver {
    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        ProductInfoOutput productInfoOutput = (ProductInfoOutput) JsonUtil.fromJson(message, ProductInfoOutput.class);
        log.info("从队列【{}】接收到消息: {}", "productInfo", productInfoOutput);
    }
}
