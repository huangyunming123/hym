package com.accu.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
//    发送请求的模板   @LoadBalanced客户端负载均衡
    @LoadBalanced
    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate(){
    return new RestTemplate();
}


//    /**
//     * 如果你设置了这个 那么就会覆盖默认的轮询 写你自己用的
//      * @return
//     */
//    @Bean
//    public IRule setBalance(){
//        return  new RandomRule();
//    }
}
