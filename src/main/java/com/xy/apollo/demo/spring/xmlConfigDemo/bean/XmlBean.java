package com.xy.apollo.demo.spring.xmlConfigDemo.bean;

/**
 * @ClassName XmlBean
 * @Description xml配置bean
 * @Author tangchao@mfexcel.com
 * @Version 1.0
 */
public class XmlBean {

  private int timeout;
  private int batch;

  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }

  public void setBatch(int batch) {
    this.batch = batch;
  }

  public int getTimeout() {
    return timeout;
  }

  public int getBatch() {
    return batch;
  }

  @Override
  public String toString() {
    return String.format("[XmlBean] timeout: %d, batch: %d", timeout, batch);
  }
}
