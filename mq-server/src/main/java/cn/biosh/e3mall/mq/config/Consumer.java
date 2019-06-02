package cn.biosh.e3mall.mq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/5/31
 */
@Component
@RabbitListener(queues = "testMessage")
public abstract class Consumer {

    Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitHandler
    public void process(String message) {
        logger.info("成功消费消息：" + message);
        dealBody(message);
    }

    public abstract void dealBody(String message);

}
