package com.example.ISA2023.back.models;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(CustomMessage message){
        //System.out.println(message);
        if (!MQConfig.QUEUE_SENDING.equals(message)) {
            System.out.println(message.getMessage());
        }
    }
}
