package cn.biosh.e3mall.common.dubbo;

import cn.biosh.e3mall.common.interfaces.RetStub;

/**
 * @description
 * @date 2019/4/16
 */
public class SystemException extends RuntimeException {

  private RetStub retStub;

  public SystemException(RetStub retStub) {
    this.retStub = retStub;
  }

  public void setRetStub(RetStub retStub) {
    this.retStub = retStub;
  }

  public RetStub getRetStub() {
    return retStub;
  }

  @Override
  public String getMessage() {
    return retStub.getCode() + ":" + retStub.getMsg();
  }
}
