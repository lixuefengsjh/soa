package com.lxf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ExecutorConfig {
    @Bean
    public ThreadPoolTaskExecutor  defaultThreadPool(){
        int cpu=Runtime.getRuntime().availableProcessors();
        ThreadPoolTaskExecutor   threadPools=new ThreadPoolTaskExecutor();
        threadPools.setCorePoolSize(5);
        //配置最大线程数
        threadPools.setMaxPoolSize(10);
        //配置队列大小
        threadPools.setQueueCapacity(400);
        //配置线程池中的线程的名称前缀
        threadPools.setThreadNamePrefix("thread-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        threadPools.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化暂时不执行初始化工作
       // threadPools.initialize();
        return  threadPools;
    }
}
