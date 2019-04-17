package cn.biosh.e3mall.common.exception;

import cn.biosh.e3mall.common.interfaces.RetStub;

public enum SysStubInfo implements RetStub {
  DEFAULT_SUCCESS(200, "success"),
  PARAMETER_IS_NULL(400, "parameter is null "),
  NEED_LOGIN(401, "need login"),
  REQUEST_BODY_INVALID(402, "request body invalid"),
  CONTENT_TYPE_INVALID(415, "Content-Type invalid"),
  RESOURCE_INVALID(404, "source not exist"),
  METHOD_INVALID(405, "unsupported method"),
  PARAMETER_TYPE_INVALID(406, "parameter type error"),
  DEFAULT_FAIL(500, "system is busy");

  private int code;
  private String msg;

  SysStubInfo(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

}
