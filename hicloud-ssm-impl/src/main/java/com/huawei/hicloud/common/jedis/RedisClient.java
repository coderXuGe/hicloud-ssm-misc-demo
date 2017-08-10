package com.huawei.hicloud.common.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis client
 * @author dell
 *
 */
public class RedisClient implements IRedisClient{

	private Logger logger = LoggerFactory.getLogger(RedisClient.class);

	private JedisPool jedisPool;

	public RedisClient(JedisPool jedisPool) {
		super();
		this.jedisPool = jedisPool;
	}

	/** string */
	public void set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(key, value);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}

	public String get(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.get(key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}

	/** hash set */
	public Long hset(String key, String field, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hset(key, field, value);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}

	public String hset(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hget(key, field);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}

	/** atomic incr by integer */
	public Long incrBy(String key, long integer) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.incrBy(key, integer);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}

	/** atomic incr 1 */
	public Long incr(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.incr(key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}

	/** atomic decr by integer */
	public Long decrBy(String key, long integer) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.decrBy(key, integer);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}

	/** atomic decr 1 */
	public Long decr(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.decr(key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}

	/** exists key */
	public Boolean exists(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.exists(key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}

	/** expire key */
	public Long expire(String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.expire(key, seconds);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}

	/** expire ttl */
	public Long ttl(String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.ttl(key);
		} finally {
			try {
				jedis.close();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}

}
