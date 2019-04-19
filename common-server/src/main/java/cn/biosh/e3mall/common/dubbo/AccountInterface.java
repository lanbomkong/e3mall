package cn.biosh.e3mall.common.dubbo;

import java.util.List;
import java.util.Map;

/**
 * @description
 * @date 2019/4/15
 */
public interface AccountInterface<T> {

  // 用户密码登录
  String login(String username, String password);

  // 获取所有用户
  List<T> getUsers(Map<String,Object> map);
}
