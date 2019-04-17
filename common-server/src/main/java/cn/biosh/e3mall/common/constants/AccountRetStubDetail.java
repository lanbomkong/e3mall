package cn.biosh.e3mall.common.constants;

import cn.biosh.e3mall.common.interfaces.RetStub;

/**
 * @description
 * @date 2019/4/16
 */
public enum AccountRetStubDetail implements RetStub {
  ACCOUNT_USER_LOGIN_FAIL(100101, "user or password error!"),

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
