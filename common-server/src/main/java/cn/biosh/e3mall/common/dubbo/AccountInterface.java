package cn.biosh.e3mall.common.dubbo;

import cn.biosh.e3mall.common.util.Condition;
import cn.biosh.e3mall.dal.model.TbUser;
import java.util.List;

/**
 * @description
 * @date 2019/4/15
 */
public interface AccountInterface {

  // 用户密码登录
  String login(String username, String password) throws SystemException;

  // 获取所有用户
  List<TbUser> getUsers(List<Condition> conditions);
}
