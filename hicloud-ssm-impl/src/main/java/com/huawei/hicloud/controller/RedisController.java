package com.huawei.hicloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.hicloud.common.ResponseResult;
import com.huawei.hicloud.common.jedis.RedisClient;

import redis.clients.jedis.JedisPool;

@RestController
public class RedisController {

	private Logger logger = LoggerFactory.getLogger(RedisController.class);
	
	@Autowired
	private RedisClient redisClient;
	
	@Autowired
	private JedisPool jedisPool;
	
	
	@RequestMapping(value="/redis/string", method=RequestMethod.GET)
	public ResponseResult saveRedisString(String key, String value) throws Exception {
		logger.info("saveRedisString: key = " + key + ", value = " + value);
		
		
		logger.info(">jedisPool = " + jedisPool);
		
		redisClient.set(key, value);
		return ResponseResult.build(200, "Redis string.", "{" + key + " : " + value + "}");
	}
}
