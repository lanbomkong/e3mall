package cn.biosh.e3mall.mq.config;

import cn.biosh.e3mall.mq.properties.ProducerConfig;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @date 2019/4/22
 */
@Configuration
public class ProducerConfigure {

  @Autowired
  private ProducerConfig producerConfig;

  private Logger logger = LoggerFactory.getLogger(ProducerConfigure.class);

  @ConditionalOnProperty(prefix = "rocketmq.producer", value = "default", havingValue = "true")
  public DefaultMQProducer defaultMQProducer() throws MQClientException {
   logger.info(producerConfig.toString());
   DefaultMQProducer producer = new DefaultMQProducer(producerConfig.getGroupName());
   producer.setNamesrvAddr(producerConfig.getNamesrvAddr());
   producer.setVipChannelEnabled(false);
   producer.setRetryTimesWhenSendAsyncFailed(10);
   producer.start();
   logger.info("----------------------------rocketmq producer start success!----------------------------");
   return producer;
  }
}
