package cn.biosh.e3mall.common.util;

import cn.biosh.e3mall.common.exception.SysStubInfo;

/**
 * @description
 * @date 2019/4/16
 */
public class ResultView<T> {

  private int code;

  private String message;

  private T data;

  public ResultView(SysStubInfo info, String detail, T data) {
    this.code = info.getCode();
    this.message = info.getMsg() + ((detail == null || detail.trim().length() == 0) ? ""
        : " --> " + detail);
    this.data = data;
  }

  public ResultView(SysStubInfo info, T data) {
    this.code = info.getCode();
    this.message = info.getMsg();
    this.data = data;
  }

  public ResultView() {
  }

  public void setCode(int code) {
    this.code = code;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setData(T data) {
    this.data = data;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public T getData() {
    return data;
  }
}
