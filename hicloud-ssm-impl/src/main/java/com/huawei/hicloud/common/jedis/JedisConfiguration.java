package com.huawei.hicloud.common.jedis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis 配置
 * 
 * @author dell
 *
 */
@Configuration
public class JedisConfiguration {

	@Bean(name = "jedisPoolConfig")
	@ConfigurationProperties(prefix = "spring.redis")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		return config;
	}
	
	@Bean
	@ConfigurationProperties(prefix = "spring.redis")
	public JedisConnectionFactory jedisConnectionFactory(@Qualifier("jedisPoolConfig") JedisPoolConfig poolConfig) {
		JedisConnectionFactory factory = new JedisConnectionFactory(poolConfig);
		return factory;
	}
	
	@Bean(name = "jedisPool")
	public JedisPool jedisPool(@Qualifier("jedisPoolConfig") JedisPoolConfig poolConfig, @Value("${spring.redis.host}") String host, @Value("${spring.redis.port}") Integer port) {
		return new JedisPool(poolConfig, host, port);
	}

	@Bean
	public RedisClient redisClient(@Qualifier("jedisPool") JedisPool jedisPool) {
		RedisClient redisClient = new RedisClient(jedisPool);
		return redisClient;
	}
}
