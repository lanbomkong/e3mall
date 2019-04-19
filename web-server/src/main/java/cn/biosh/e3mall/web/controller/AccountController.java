package cn.biosh.e3mall.web.controller;

import cn.biosh.e3mall.common.dubbo.AccountInterface;
import cn.biosh.e3mall.common.interfaces.RedisOperator;
import cn.biosh.e3mall.common.util.Condition;
import cn.biosh.e3mall.web.dto.input.LoginForm;
import com.alibaba.dubbo.config.annotation.Reference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
  private RedisOperator redisOperator;

  @Reference(version = "1.0.0")
  private AccountInterface accountInterface;

  @PostMapping("/login")
  public String userLogin(@RequestBody @Valid LoginForm form) {
    return accountInterface.login(form.getUsername(), form.getPassword());
  }

  @GetMapping("/users")
  public Object getUsers() {
    Map<String,Object> map = new HashMap<>();
    List<Condition> conditions = new ArrayList<>();
//    conditions.add(new Condition("id", 1));
    conditions.add(new Condition("DATE_FORMAT(created, \"%Y-%m-%d\")", "CURDATE()"));
    map.put("conditions", conditions);
    return accountInterface.getUsers(map);
  }

}
