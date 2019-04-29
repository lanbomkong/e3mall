package cn.biosh.e3mall.account.mq;

import cn.biosh.e3mall.common.util.EmailUtil;
import cn.biosh.e3mall.common.util.JsonUtil;
import cn.biosh.e3mall.dal.model.TbUser;
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
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/4/22
 */
@Component
public class AccountRegisterMqListener extends ConsumerConfigure implements
    ApplicationListener<ContextRefreshedEvent> {

  private static final String registerTitle = "铁道口皇家男子自建网站会员注册成功！";
  private static final String registerMessage = "牛逼轰轰的%s你好， 恭喜你已成功注册为铁道口皇家男子自建网站会员，你将走向人生巅峰！";

  private Logger logger = LoggerFactory.getLogger(AccountRegisterMqListener.class);
  @Override
  public ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs) {
    for (MessageExt msg: msgs) {
      try {
        logger.info("成功消费消息：" + new String(msg.getBody(), "UTF-8"));
        TbUser tbUser = JsonUtil
            .jsonStringToObject(new String(msg.getBody(), "UTF-8"), TbUser.class);

        logger.info(EmailUtil.sendEmail(tbUser.getEmail(), registerTitle, registerMessage)?"邮件通知成功！":"邮件通知失败！");
      } catch (UnsupportedEncodingException e) {
        logger.error("body转字符串解析失败！");
      }
    }
    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    try {
      super.listener("konglingbiao", "register", "registerConsumer");
    } catch (MQClientException e) {
      logger.error("account-register 消息监听失败!");
    }
  }
}
