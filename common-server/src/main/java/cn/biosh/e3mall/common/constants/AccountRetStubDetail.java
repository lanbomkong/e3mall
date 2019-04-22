package cn.biosh.e3mall.common.constants;

import cn.biosh.e3mall.common.interfaces.RetStub;

/**
 * @description
 * @date 2019/4/16
 */
public enum AccountRetStubDetail implements RetStub {
  ACCOUNT_USER_LOGIN_FAIL(100101, "user or password error!"),

  ACCOUNT_USER_USERNAME_EXIT(200101, "username already exit!"),
  ACCOUNT_USER_EMAIL_EXIT(200102, "email already bind!"),
  ACCOUNT_USER_PHONE_EXIT(200103, "username already bind!"),

  ACCOUNT_USER_REGISTER_MQMESSAGE_SEND_FAIL(300101, "register message send fail!"),
  ;

  private int code;

  private String msg;

  AccountRetStubDetail(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public String getMsg() {
    return msg;
  }
}
