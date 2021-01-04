package com.woniuxy.springbootrabbitmqconsumer.config;

import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

/**
 * 配置RabbitMQ的消息反序列化接收格式
 * 实现接口RabbitListenerConfigurer
 * 重写接口方法configureRabbitListener，注json序列化方式的消息转换器到其中
 */
@Configuration
public class RabbitMQConfig implements RabbitListenerConfigurer {
//  重写rabiit监听器方法方法
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
//      注册反序列化使用的消息转换器
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }

//  配置以json为数据序列化格式
    @Bean
    public MappingJackson2MessageConverter mappingJackson2MessageConverter(){
        return new MappingJackson2MessageConverter();
    }
//  配置消息处理方法工厂，并调用json序列化格式方法
    @Bean
    public MessageHandlerMethodFactory messageHandlerMethodFactory(){
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(mappingJackson2MessageConverter());
        return factory;
    }


}
