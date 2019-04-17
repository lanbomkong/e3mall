package cn.biosh.e3mall.dal.base;

import java.io.Serializable;

/**
 * @description
 * @date 2019/4/12
 */
public class BaseModel implements Serializable {

  protected Long id;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}
