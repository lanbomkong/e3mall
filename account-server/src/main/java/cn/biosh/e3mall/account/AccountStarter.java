package cn.biosh.e3mall.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description
 * @date 2019/4/15
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.biosh.e3mall.dal.mapper"})
//@EnableDubboConfiguration
@ComponentScan(basePackages = {"cn.biosh.e3mall.*"})
public class AccountStarter {

  public static void main(String[] args) {
    SpringApplication.run(AccountStarter.class, args);
  }
}
