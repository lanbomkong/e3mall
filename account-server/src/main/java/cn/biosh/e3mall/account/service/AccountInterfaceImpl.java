package cn.biosh.e3mall.account.service;

import cn.biosh.e3mall.account.msg.Constant;
import cn.biosh.e3mall.common.constants.AccountRetStubDetail;
import cn.biosh.e3mall.common.dubbo.AccountInterface;
import cn.biosh.e3mall.common.dubbo.SystemException;
import cn.biosh.e3mall.common.interfaces.RedisOperator;
import cn.biosh.e3mall.common.util.JsonUtil;
import cn.biosh.e3mall.common.util.StringUtil;
import cn.biosh.e3mall.dal.mapper.TbUserMapper;
import cn.biosh.e3mall.dal.model.TbUser;
import cn.biosh.e3mall.mq.config.Producer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @description
 * @date 2019/4/15
 */
@Component
//@Service(interfaceClass = AccountInterface.class, version = "1.0.0")
public class AccountInterfaceImpl implements AccountInterface<TbUser> {

  private Logger logger = LoggerFactory.getLogger(AccountInterfaceImpl.class);

  @Autowired
  private TbUserMapper userMapper;

  @Autowired
  @Qualifier("redisUtil")
  private RedisOperator redisOperator;

  @Autowired
  private Producer producer;

  @Override
  public List<TbUser> getUsers(Map<String, Object> map) {
    return userMapper.getByConditions(map);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void registUser(TbUser tbUser) {
    if (checkUserExit(tbUser.getUsername()) != 0L) {
      throw new SystemException(AccountRetStubDetail.ACCOUNT_USER_USERNAME_EXIT);
    }
    if (checkUserExit(tbUser.getEmail()) != 0L) {
      throw new SystemException(AccountRetStubDetail.ACCOUNT_USER_EMAIL_EXIT);
    }
    if (!StringUtils.isEmpty(tbUser.getPhone()) && checkUserExit(tbUser.getPhone()) != 0L) {
      throw new SystemException(AccountRetStubDetail.ACCOUNT_USER_PHONE_EXIT);
    }
    tbUser.setCreated(new Date());
    userMapper.insertSelective(tbUser);

    producer.sendMessage("testMessage", JsonUtil.objectToJsonString(tbUser));
//    try {
//      Message message = new Message("konglingbiao", "register", "123456" ,
//          JsonUtil.objectToJsonString(tbUser).getBytes());
//      producer.send(message, new SendCallback() {
//        @Override
//        public void onSuccess(SendResult sendResult) {
//          logger.info("消息发送成功！");
//          logger.info(JsonUtil.objectToJsonString(sendResult));
//        }
//
//        @Override
//        public void onException(Throwable throwable) {
//          logger.error("消息发送失败：" + throwable);
//        }
//      });
//    } catch (Exception e) {
//      e.printStackTrace();
//      throw new SystemException(AccountRetStubDetail.ACCOUNT_USER_REGISTER_MQMESSAGE_SEND_FAIL);
//    }


  }

  @Override
  public String login(String username, String password) {
    long userId = checkUserExit(username);
    TbUser tbUser = userMapper.selectByPrimaryKey(userId);
    if (tbUser != null && password.equals(tbUser.getPassword())) {
      String userToken = StringUtil.generatorToken();
      String token = redisOperator
          .get(String.format(Constant.ACCOUNT_USER_TOKEN, userId), String.class);
      // 删除原来的缓存
      if (!StringUtils.isEmpty(token)) {
        redisOperator.del(String.format(Constant.ACCOUNT_USER_TOKEN, userId));
        redisOperator.del(String.format(Constant.ACCOUNT_TOKEN_USER, token));
      }
      redisOperator.set(String.format(Constant.ACCOUNT_USER_TOKEN, userId), userToken);
      redisOperator.set(String.format(Constant.ACCOUNT_TOKEN_USER, userToken), userId);
      return userToken;
    }
    throw new SystemException(AccountRetStubDetail.ACCOUNT_USER_LOGIN_FAIL);
  }

  /**
   * 校验用户是否存在
   *
   * @param ：username 可以是username、phone、email中的一个
   *          password 密码
   */
  public Long checkUserExit(String username) {
    Map<String, Object> map = new HashMap<>();
    map.put("otherOperate", String
        .format("where username = '%s' or phone = '%s' or email = '%s'", username, username,
            username));
    List<TbUser> users = userMapper.getByConditions(map);
    return users.size() > 0 ? users.get(0).getId().intValue() : 0L;
  }

}
