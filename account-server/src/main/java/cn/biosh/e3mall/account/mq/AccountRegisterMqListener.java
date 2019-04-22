package cn.biosh.e3mall.account.mq;

import cn.biosh.e3mall.mq.config.ConsumerConfigure;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @description
 * @date 2019/4/22
 */
public class AccountRegisterMqListener extends ConsumerConfigure implements
    ApplicationListener<ContextRefreshedEvent> {

  private Logger logger = LoggerFactory.getLogger(AccountRegisterMqListener.class);

  @Override
  public ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs) {
    for (MessageExt msg: msgs) {
      try {
        logger.info("成功消费消息：" + new String(msg.getBody(), "UTF-8"));
      } catch (UnsupportedEncodingException e) {
        logger.error("body转字符串解析失败！");
      }
    }
    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    try {
      super.listener("account", "register");
    } catch (MQClientException e) {
      logger.error("account-register 消息监听失败!");
    }
  }
}
