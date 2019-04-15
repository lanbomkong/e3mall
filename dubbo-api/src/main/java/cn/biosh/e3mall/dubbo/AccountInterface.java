package cn.biosh.e3mall.dubbo;

/**
 * @description
 * @date 2019/4/15
 */
public interface AccountInterface {

  // 用户密码登录
  String login(String username, String password);
}
