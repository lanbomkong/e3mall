//package cn.biosh.e3mall.mq.config;
//
//import java.util.List;
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
///**
// * @description
// * @date 2019/4/22
// */
//@Configuration
//@Component
//public abstract class ConsumerConfigure {
//
//  private Logger logger = LoggerFactory.getLogger(ConsumerConfigure.class);
//
//  @Value("${rocketmq.consumer.registerNamesrvAddr}")
//  private String namesrvAdd;
//
//  public void listener(String topic, String tag, String consumerGroup) throws MQClientException {
//    logger.info("开启消息监听：" + topic + "-->" + tag);
//
//    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
//    consumer.setNamesrvAddr(namesrvAdd);
//    consumer.subscribe(topic, tag);
//    consumer.registerMessageListener(new MessageListenerConcurrently() {
//      @Override
//      public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
//          ConsumeConcurrentlyContext consumeConcurrentlyContext) {
//        return ConsumerConfigure.this.dealBody(list);
//      }
//    });
//    consumer.start();
//    logger.info("-------------rocketmq 消息监听启动成功！-------------");
//  }
//
//  public abstract ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs);
//}
