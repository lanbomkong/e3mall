package cn.biosh.e3mall.web.controller;

import cn.biosh.e3mall.common.interfaces.RedisOperator;
import cn.biosh.e3mall.web.dto.input.LoginForm;
import cn.biosh.e3mall.web.service.AccountServiceImpl;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2019/4/15
 */
@RestController
@Validated
@RequestMapping("/account")
public class AccountController {

  @Autowired
  private AccountServiceImpl accountService;

  @Autowired
  private RedisOperator redisOperator;

  @PostMapping("/login")
  public String userLogin(@RequestBody @Valid LoginForm form) {
    return accountService.login(form);
  }

}
