package com.huawei.hicloud.common.constants;

public interface IRabbitMQConstants {
	
	/** 交换机名称 */
	public static final String EXCHANGE_TOPIC = "EXCHANGE_TOPIC";
	public static final String EXCHANGE_FANOUT = "EXCHANGE_FANOUT";
	
	/* 直接转发 direct */
	public static final String QUEUE_NAME_DIRECT = "QUEUE_HICLOUD";
	
	/* topic */
	public static final String QUEUE_NAME_TOPIC01 = "QUEUE_HICLOUD_TOPIC01";
	public static final String QUEUE_NAME_TOPIC02 = "QUEUE_HICLOUD_TOPIC02";
	public static final String QUEUE_ROUTING_KEY_TOPIC01 = "topic.message";
	public static final String QUEUE_ROUTING_KEY_TOPIC02 = "topic.#";
	
	/* fanout */
	public static final String QUEUE_NAME_FANOUT01 = "QUEUE_HICLOUD_FANOUT01";
	public static final String QUEUE_NAME_FANOUT02 = "QUEUE_HICLOUD_FANOUT02";
	public static final String QUEUE_NAME_FANOUT03 = "QUEUE_HICLOUD_FANOUT03";
	
	
}
