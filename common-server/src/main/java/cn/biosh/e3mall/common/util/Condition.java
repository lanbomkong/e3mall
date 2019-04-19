package cn.biosh.e3mall.common.util;

import java.io.Serializable;

/**
 * @description
 * @date 2019/4/12
 */
public class Condition implements Serializable {

  private String key; // 数据筛选条件字段

  private Object value; // 数据筛选条件值

  private String operate; // 数据筛选条件

  public Condition(String key, Object value, String operate) {
    this.key = key;
    this.value = value;
    this.operate = operate;
  }

  public Condition(String key, Object value) {
    this.key = key;
    this.value = value;
    this.operate = "=";
  }

  public void setKey(String key) {
    this.key = key;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public void setOperate(String operate) {
    this.operate = operate;
  }

  public String getKey() {
    return key;
  }

  public Object getValue() {
    return value;
  }

  public String getOperate() {
    return operate;
  }
}
