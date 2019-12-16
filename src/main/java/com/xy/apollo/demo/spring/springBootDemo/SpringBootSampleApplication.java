package com.xy.apollo.demo.spring.springBootDemo;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.xy.apollo.demo.spring.common.bean.AnnotatedBean;
import com.xy.apollo.demo.spring.springBootDemo.config.SampleRedisConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName SpringBootSampleApplication
 * @Description SpringBoot测试启动类
 * @Author tangchao@mfexcel.com
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.xy.apollo.demo.spring.common",
    "com.xy.apollo.demo.spring.springBootDemo"
})
public class SpringBootSampleApplication {

  public static void main(String[] args) throws IOException {
    ApplicationContext context = new SpringApplicationBuilder(SpringBootSampleApplication.class).run(args);
    AnnotatedBean annotatedBean = context.getBean(AnnotatedBean.class);
    SampleRedisConfig redisConfig = null;
    try {
      redisConfig = context.getBean(SampleRedisConfig.class);
    } catch (NoSuchBeanDefinitionException ex) {
      System.out.println("SampleRedisConfig is null, redis.cache.enabled = false");
    }

    while (true) {
      System.out.print("> ");
      String input = new BufferedReader(new InputStreamReader(System.in, Charsets.UTF_8)).readLine();
      if (!Strings.isNullOrEmpty(input) && input.trim().equalsIgnoreCase("quit")) {
        System.exit(0);
      }

      System.out.println(annotatedBean.toString());
      if (redisConfig != null) {
        System.out.println(redisConfig.toString());
      }
    }
  }
}
