package cn.biosh.e3mall.mq.config;

import cn.biosh.e3mall.mq.properties.ConsumerConfig;
import java.util.List;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @date 2019/4/22
 */
@Configuration
public abstract class ConsumerConfigure {

  @Autowired
  private ConsumerConfig consumerConfig;

  private Logger logger = LoggerFactory.getLogger(ConsumerConfigure.class);

  public void listener(String topic, String tag) throws MQClientException {
    logger.info("开启消息监听：" + topic + "-->" + tag);
    logger.info(consumerConfig.toString());

    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerConfig.getGroupName());
    consumer.setNamesrvAddr(consumerConfig.getNamesrvAddr());
    consumer.subscribe(topic, tag);
    consumer.registerMessageListener(new MessageListenerConcurrently() {
      @Override
      public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
          ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        return ConsumerConfigure.this.dealBody(list);
      }
    });
    consumer.start();
    logger.info("-------------rocketmq 启动成功！-------------");
  }

  public abstract ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs);
}
