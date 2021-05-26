package com.example.demo.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {

    @Value("${snow.worker}")
    private long worker;

    @Value("${snow.datacenter}")
    private long dataCenter;

    // id 生成器
    @Bean
    public Snowflake snowflake() {
        return IdUtil.createSnowflake(worker, dataCenter);
    }
}
