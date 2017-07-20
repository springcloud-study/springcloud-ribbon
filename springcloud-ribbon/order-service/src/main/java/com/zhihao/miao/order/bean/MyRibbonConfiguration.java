package com.zhihao.miao.order.bean;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRibbonConfiguration {

//    @Bean
//    public IRule ribbonRule(){
//        return new RandomRule();
//    }

    @Bean
    public IRule ribbonRule(){
        return new WeightedResponseTimeRule();
    }

}
