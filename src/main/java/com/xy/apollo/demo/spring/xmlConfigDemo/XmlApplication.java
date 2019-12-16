package com.xy.apollo.demo.spring.xmlConfigDemo;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.xy.apollo.demo.spring.xmlConfigDemo.bean.XmlBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName XmlApplication
 * @Description xml形式配置测试启动类
 * @Author tangchao@mfexcel.com
 * @Version 1.0
 */
public class XmlApplication {
  public static void main(String[] args) throws IOException {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    XmlBean xmlBean = context.getBean(XmlBean.class);

    while (true) {
      System.out.print("> ");
      String input = new BufferedReader(new InputStreamReader(System.in, Charsets.UTF_8)).readLine();
      if (!Strings.isNullOrEmpty(input) && input.trim().equalsIgnoreCase("quit")) {
        System.exit(0);
      }
      System.out.println(xmlBean.toString());
    }
  }
}
