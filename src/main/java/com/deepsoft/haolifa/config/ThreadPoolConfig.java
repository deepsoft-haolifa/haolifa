package com.deepsoft.haolifa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @className: ThreadPoolConfig
 * @description: 线程池配置
 * @author: hedong@ibeesaas.com
 * @date: 2018-07-11 21:09
 **/
@EnableAsync
@Configuration
public class ThreadPoolConfig {

    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setKeepAliveSeconds(60);
        //核心线程池数
        executor.setCorePoolSize(10);
        // 最大线程
        executor.setMaxPoolSize(20);
        //队列容量
        executor.setQueueCapacity(200);
        executor.setThreadNamePrefix("haolifa-threadPoolTaskExecutor-");
        //队列满，线程被拒绝执行策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
