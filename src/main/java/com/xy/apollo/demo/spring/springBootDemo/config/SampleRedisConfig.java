package com.xy.apollo.demo.spring.springBootDemo.config;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SampleRedisConfig
 * @Description @ConfigurationProperties形式
 *              若想热更新，需要配合使用EnvironmentChangeEvent或RefreshScope。相关代码实现见SpringBootApolloRefreshConfig
 * @Author tangchao@mfexcel.com
 * @Version 1.0
 */
@ConditionalOnProperty("redis.cache.enabled")  // redis.cache.enabled = true 时，此配置加载生效
@ConfigurationProperties(prefix = "redis.cache")
@Component
@RefreshScope
public class SampleRedisConfig {

  private static final Logger logger = LoggerFactory.getLogger(SampleRedisConfig.class);

  private int expireSeconds;
  private String clusterNodes;
  private int commandTimeout;

  private Map<String, String> someMap = Maps.newLinkedHashMap();
  private List<String> someList = Lists.newLinkedList();

  @PostConstruct
  private void initialize() {
    logger.info(
        "SampleRedisConfig initialized - expireSeconds: {}, clusterNodes: {}, commandTimeout: {}, someMap: {}, someList: {}",
        expireSeconds, clusterNodes, commandTimeout, someMap, someList);
  }

  public void setExpireSeconds(int expireSeconds) {
    this.expireSeconds = expireSeconds;
  }

  public void setClusterNodes(String clusterNodes) {
    this.clusterNodes = clusterNodes;
  }

  public void setCommandTimeout(int commandTimeout) {
    this.commandTimeout = commandTimeout;
  }

  public Map<String, String> getSomeMap() {
    return someMap;
  }

  public List<String> getSomeList() {
    return someList;
  }

  @Override
  public String toString() {
    return String.format(
        "[SampleRedisConfig] expireSeconds: %d, clusterNodes: %s, commandTimeout: %d, someMap: %s, someList: %s",
            expireSeconds, clusterNodes, commandTimeout, someMap, someList);
  }
}
