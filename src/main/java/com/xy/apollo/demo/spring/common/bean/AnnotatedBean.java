package com.xy.apollo.demo.spring.common.bean;

import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName AnnotatedBean
 * @Description 注解形式，支持直接在字段上和set方法上，也可直接注入对象
 * @Author tangchao@mfexcel.com
 * @Version 1.0
 */
@Component
public class AnnotatedBean {

  private int timeout;
  private int batch;
  private List<JsonBean> jsonBeans;

  @ApolloJsonValue("${jsonBeanProperty:[]}")
  private List<JsonBean> anotherJsonBeans;

  @Value("${batch:100}")
  public void setBatch(int batch) {
    this.batch = batch;
  }

  @Value("${timeout:200}")
  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }

  @ApolloJsonValue("${jsonBeanProperty:[]}")
  public void setJsonBeans(List<JsonBean> jsonBeans) {
    this.jsonBeans = jsonBeans;
  }

  @Override
  public String toString() {
    return String.format("[AnnotatedBean] timeout: %d, batch: %d, jsonBeans: %s", timeout, batch, jsonBeans);
  }

  private static class JsonBean{

    private String someString;
    private int someInt;

    @Override
    public String toString() {
      return "JsonBean{" +
          "someString='" + someString + '\'' +
          ", someInt=" + someInt +
          '}';
    }
  }
}
