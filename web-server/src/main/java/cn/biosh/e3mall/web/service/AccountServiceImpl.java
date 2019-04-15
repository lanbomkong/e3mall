package cn.biosh.e3mall.web.service;

import cn.biosh.e3mall.dubbo.AccountInterface;
import cn.biosh.e3mall.web.dto.input.LoginForm;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @description
 * @date 2019/4/15
 */
@Service
public class AccountServiceImpl {

  @Reference(version = "1.0.0")
  private AccountInterface accountInterface;

  public String login(LoginForm loginForm) {
    return accountInterface.login(loginForm.getUsername(), loginForm.getPassword());
  }

}
