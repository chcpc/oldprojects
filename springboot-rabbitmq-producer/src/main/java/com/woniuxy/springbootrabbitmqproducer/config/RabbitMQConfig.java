package com.woniuxy.springbootrabbitmqproducer.config;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ的配置类
 *  配置交换机：Topic-exchange，名为springboot-exchange
 *  配置序列化格式，并将格式修改到RabbitTemplate当中
 */
@Configuration
public class RabbitMQConfig {
//  创建一个Bean为TopicExchange（交换机），并给它命名
    @Bean
    public TopicExchange topicExchange(){
        TopicExchange topicExchange = new TopicExchange("springboot-exchange");
        return topicExchange;
    }

//  转换为json格式序列化数据
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        return converter;
    }
//  创建RabbitTemplate,开启并使用消息退回处理机制
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory){
        RabbitTemplate template = new RabbitTemplate(factory);
        template.setMessageConverter(messageConverter());
//      修改消息处理机制，调用本地的处理方法
        template.setConfirmCallback(confirmCallback);
        template.setReturnCallback(returnCallback);
//      开启强制退回消息
        template.setMandatory(true);
//      注意：必须要在这里设置为true才能开启，因为这里的@Bean会替代默认的。
        return template;
    }
//  调用RabbitTemplate中的静态参数ConfirmCallback，并修改内容
    RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
//      获取producer发送的附加消息
        System.out.println("消息Id："+correlationData.getId());
//      假如未接受
        if(!b){
            System.out.println("拒收原因："+s);
        }else{
            System.out.println("被borker接受");
        }
    }
};
//  调用RabbitTemplate中的静态参数ReturnCallback，并修改内容
    RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("错误编号："+i);
        System.out.println("错误原因："+s);
        System.out.println("交换机："+s1);
        System.out.println("路由key："+s2);
        System.out.println("返回的消息："+new String(message.getBody()));
    }
};
}
