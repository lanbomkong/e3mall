package cn.biosh.e3mall.fastdfs;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @description
 * @date 2019/4/17
 */
@SpringBootApplication
@Import(FdfsClientConfig.class)
@EnableDubboConfiguration
@ComponentScan(basePackages = {"cn.biosh.e3mall.*"})
public class FastdfsStarter {

  public static void main(String[] args) {
    SpringApplication.run(FastdfsStarter.class, args);
  }

}