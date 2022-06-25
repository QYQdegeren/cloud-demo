package cn.itcast.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

//配置类
public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level loglevel(){
        return Logger.Level.BASIC;
    }
}
