package com.woniuxy.springbootredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * 原本默认序列化方式为JDK的方式，但传输的数据可视化差
 * 该配置类使得redis的缓存数据传输方式（序列化和反序列化）变为json，可以在redis中直接查看实际结果
 */
@Configuration
public class RedisConfig {
//  将其作为Bean添加到容器中
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(){
//      使用Redis默认缓存配置
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();

        return redisCacheConfiguration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }
}
