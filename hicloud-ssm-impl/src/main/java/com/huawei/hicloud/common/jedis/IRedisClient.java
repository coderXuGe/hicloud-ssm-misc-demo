package com.huawei.hicloud.common.jedis;

/**
 * Redis client interface
 * 
 * @author dell
 *
 */
public interface IRedisClient {

	/** [string] key:value */
	public void set(String key, String value);
	public String get(String key) throws Exception;

	/** [hash set] key:field:value */
	public Long hset(String key, String field, String value);
	public String hset(String key, String field);

	/** atomic incr by integer */
	public Long incrBy(String key, long integer);
	/** atomic incr 1 */
	public Long incr(String key);

	/** atomic decr by integer */
	public Long decrBy(String key, long integer);
	/** atomic decr 1 */
	public Long decr(String key);

	/** exists key */
	public Boolean exists(String key);

	/** expire key */
	public Long expire(String key, int seconds);

	/** expire ttl */
	public Long ttl(String key, int seconds);

}
