package cn.biosh.e3mall.mq.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @date 2019/4/22
 */
//@ConfigurationProperties(prefix = "rocketmq.producer")
@Configuration
public class ProducerConfig {

  @Value("rocketmq.producer.namesrvAddr")
  private String namesrvAddr;

  @Value("rocketmq.producer.namesrvAddr")
  private String groupName;

  public void setNamesrvAddr(String namesrvAddr) {
    this.namesrvAddr = namesrvAddr;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getNamesrvAddr() {
    return namesrvAddr;
  }

  public String getGroupName() {
    return groupName;
  }
}
