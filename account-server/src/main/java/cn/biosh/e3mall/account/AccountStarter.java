package cn.biosh.e3mall.account;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description
 * @date 2019/4/15
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.biosh.e3mall.dal.mapper"})
@EnableDubboConfiguration
public class AccountStarter {

  public static void main(String[] args) {
    SpringApplication.run(AccountStarter.class, args);
  }
}
