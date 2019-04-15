package cn.biosh.e3mall.common.util;

/**
 * @description
 * @date 2019/4/12
 */
public class Sorter {

  private String column; // 需要排序的字段

  private String downUp; // 排序方式，asc or desc

  public Sorter(String column, String downUp) {
    this.column = column;
    this.downUp = downUp;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public void setDownUp(String downUp) {
    this.downUp = downUp;
  }

  public String getColumn() {
    return column;
  }

  public String getDownUp() {
    return downUp;
  }
}
