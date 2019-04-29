package cn.biosh.e3mall.test;


import cn.biosh.e3mall.common.util.EmailUtil;
import org.junit.Test;

/**
 * @description
 * @date 2019/4/24
 */
public class AccountTest {

  @Test
  public void name() {
    System.out.println(
        EmailUtil.sendEmail("konglingbiao@haylion.cn", "test for email", "hello world!"));;
  }
}
