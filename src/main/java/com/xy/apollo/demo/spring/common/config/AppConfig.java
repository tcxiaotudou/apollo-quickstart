package com.xy.apollo.demo.spring.common.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AppConfig
 * @Description 启用Apollo配置，请确保@Configuration与@EnableApolloConfig同时存在
 * @Author tangchao@mfexcel.com
 * @Version 1.0
 */
@Configuration
@EnableApolloConfig(value = "application", order = 2) // value为需要加载的namespace，order为namespace的优先级，order越小，优先级越高
public class AppConfig {
}
