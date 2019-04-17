package cn.biosh.e3mall.common.constants;

import cn.biosh.e3mall.common.interfaces.RetStub;

/**
 * @description
 * @date 2019/4/16
 */
public enum FileRetStubDetail implements RetStub {
  FILE_UPLOAD_FAIL(200101, "file upload fail!"),

  ;

  private int code;

  private String msg;

  FileRetStubDetail(int code, String msg) {
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
