package com.xy.apollo.demo.spring.springBootDemo.refresh;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.xy.apollo.demo.spring.springBootDemo.config.SampleRedisConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringBootApolloRefreshConfig
 * @Description @ConfigurationProperties形式时，启用热更新配置
 * @Author tangchao@mfexcel.com
 * @Version 1.0
 */
@ConditionalOnProperty("redis.cache.enabled")
@Component
public class SpringBootApolloRefreshConfig {
  private static final Logger logger = LoggerFactory.getLogger(SpringBootApolloRefreshConfig.class);

  private final SampleRedisConfig sampleRedisConfig;
  private final RefreshScope refreshScope;

  public SpringBootApolloRefreshConfig(
      final SampleRedisConfig sampleRedisConfig,
      final RefreshScope refreshScope) {
    this.sampleRedisConfig = sampleRedisConfig;
    this.refreshScope = refreshScope;
  }

  /**
   * 指定监听的namespace注入优先级高于配置文件中，interestedKeys代表要热更新的key
   * @param changeEvent
   */
  @ApolloConfigChangeListener(value = {"application", "another"}, interestedKeys = "redis.cache.")
  public void onChange(ConfigChangeEvent changeEvent) {
    logger.info("before refresh {}", sampleRedisConfig.toString());
    refreshScope.refresh("sampleRedisConfig");
    logger.info("after refresh {}", sampleRedisConfig.toString());
  }
}
