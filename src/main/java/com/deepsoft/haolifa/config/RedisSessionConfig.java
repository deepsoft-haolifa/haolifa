package com.deepsoft.haolifa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600 * 4)
public class RedisSessionConfig extends AbstractHttpSessionApplicationInitializer {
//
//    @Bean
//    public JedisConnectionFactory connectionFactory() {
//        return new JedisConnectionFactory();
//    }

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }

}
