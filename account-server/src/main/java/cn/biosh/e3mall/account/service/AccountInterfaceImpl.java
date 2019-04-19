package cn.biosh.e3mall.account.service;

import cn.biosh.e3mall.account.msg.Constant;
import cn.biosh.e3mall.common.constants.AccountRetStubDetail;
import cn.biosh.e3mall.common.dubbo.AccountInterface;
import cn.biosh.e3mall.common.dubbo.SystemException;
import cn.biosh.e3mall.common.interfaces.RedisOperator;
import cn.biosh.e3mall.common.util.StringUtil;
import cn.biosh.e3mall.dal.mapper.TbUserMapper;
import cn.biosh.e3mall.dal.model.TbUser;
import com.alibaba.dubbo.config.annotation.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @description
 * @date 2019/4/15
 */
@Component
@Service(interfaceClass = AccountInterface.class, version = "1.0.0")
public class AccountInterfaceImpl implements AccountInterface<TbUser> {

  @Autowired
  private TbUserMapper userMapper;

  @Autowired
  @Qualifier("redisUtil")
  private RedisOperator redisOperator;

  @Override
  public List<TbUser> getUsers(Map<String,Object> map) {
    return userMapper.getByConditions(map);
  }

  @Override
  public String login(String username, String password) {
    long userId = checkUserExit(username, password);
    if (userId != 0L) {
      String userToken = StringUtil.generatorToken();
      String token = redisOperator.get(String.format(Constant.ACCOUNT_USER_TOKEN, userId), String.class);
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
   * @param ：username 可以是username、phone、email中的一个 password 密码
   */
  public Long checkUserExit(String username, String password) {
    Map<String, Object> map = new HashMap<>();
    map.put("otherOperate", String.format("where username = '%s' or phone = '%s' or email = '%s'", username, username, username));
    List<TbUser> users = userMapper.getByConditions(map);
    return users.size() > 0 && password.equals(users.get(0).getPassword()) ? users.get(0).getId().intValue() : 0L;
  }
}
