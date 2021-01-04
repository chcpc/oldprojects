package com.woniu.pmsdemo.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/10/8
 */
@Configuration
public class RabbitMQConfig {

        @Bean
        public FanoutExchange fanoutExchange(){
            FanoutExchange fanoutExchange = new FanoutExchange("order_exchange");
            return fanoutExchange;
        }


}
