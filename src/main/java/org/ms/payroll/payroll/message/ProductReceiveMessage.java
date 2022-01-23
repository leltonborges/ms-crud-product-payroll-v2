package org.ms.payroll.payroll.message;

import org.ms.payroll.payroll.dtos.ProductDTO;
import org.ms.payroll.payroll.services.ProductService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProductReceiveMessage {

    @Value("${app_payrool.rabbitmq.exchange}")
    private String exchange;

    @Autowired
    private ProductService productService;

    @RabbitListener(queues = {"${app_payrool.rabbitmq.queue}"})
    public void receiveMessage(@Payload ProductDTO productDTO){
        productService.save(productDTO);
    }


}
