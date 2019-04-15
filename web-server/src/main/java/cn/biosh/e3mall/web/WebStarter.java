package cn.biosh.e3mall.web;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description
 * @date 2019/4/15
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.biosh.e3mall.*"})
@EnableDubboConfiguration
public class WebStarter {

  public static void main(String[] args) {
    SpringApplication.run(WebStarter.class, args);
  }

}
