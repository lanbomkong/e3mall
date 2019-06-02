package cn.biosh.e3mall.mq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/5/31
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     *  消息发送：
     */
    public void sendMessage(String topic,String message) {

        amqpTemplate.convertAndSend(topic, message);
    }

}
