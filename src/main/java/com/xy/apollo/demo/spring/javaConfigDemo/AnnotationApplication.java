package com.xy.apollo.demo.spring.javaConfigDemo;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.xy.apollo.demo.spring.common.bean.AnnotatedBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @ClassName AnnotationApplication
 * @Description 基于注解形式的测试启动类
 * @Author tangchao@mfexcel.com
 * @Version 1.0
 */
public class AnnotationApplication {

  public static void main(String[] args) throws IOException {
    ApplicationContext context = new AnnotationConfigApplicationContext("com.xy.apollo.demo.spring.common");
    AnnotatedBean annotatedBean = context.getBean(AnnotatedBean.class);

    while (true) {
      System.out.print("> ");
      String input = new BufferedReader(new InputStreamReader(System.in, Charsets.UTF_8)).readLine();
      if (!Strings.isNullOrEmpty(input) && input.trim().equalsIgnoreCase("quit")) {
        System.exit(0);
      }
      System.out.println(annotatedBean.toString());
    }
  }
}
