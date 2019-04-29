package cn.biosh.e3mall.mq.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @date 2019/4/22
 */
@Configuration
public class ProducerConfigure {

  private Logger logger = LoggerFactory.getLogger(ProducerConfigure.class);

  @Value("${rocketmq.producer.namesrvAddr}")
  private String namesrvAddr;

  @Value("${rocketmq.producer.registerGroupName}")
  private String producerGroup;

  @Bean
  public DefaultMQProducer defaultMQProducer() throws MQClientException {
   DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
   producer.setNamesrvAddr(namesrvAddr);
   producer.setVipChannelEnabled(false);
   producer.setRetryTimesWhenSendAsyncFailed(10);
   producer.start();
   logger.info("----------------------------rocketmq producer start success!----------------------------");
   return producer;
  }
}
