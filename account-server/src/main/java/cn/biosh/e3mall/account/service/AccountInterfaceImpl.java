package cn.biosh.e3mall.account.service;

import cn.biosh.e3mall.dal.mapper.TbUserMapper;
import cn.biosh.e3mall.dubbo.AccountInterface;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/4/15
 */
@Component
@Service(interfaceClass = AccountInterface.class, version = "1.0.0")
public class AccountInterfaceImpl implements AccountInterface {

  @Autowired
  private TbUserMapper userMapper;

  @Override
  public String login() {
    return "login success!";
  }
}
