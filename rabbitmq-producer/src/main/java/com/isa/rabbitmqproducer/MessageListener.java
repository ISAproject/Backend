package com.isa.rabbitmqproducer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @RabbitListener(queues = MQConfig.QUEUE_RECEIVING)
    public void listener(CustomMessage message){
        //System.out.println(message);
        System.out.println(message.getMessage());
    }
}
