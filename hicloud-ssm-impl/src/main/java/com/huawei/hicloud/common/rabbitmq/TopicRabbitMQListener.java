package com.huawei.hicloud.common.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.huawei.hicloud.common.constants.IRabbitMQConstants;

@Component
public class TopicRabbitMQListener {
	private Logger logger = LoggerFactory.getLogger(TopicRabbitMQListener.class);
	
	@RabbitListener(queues=IRabbitMQConstants.QUEUE_NAME_TOPIC01)
	public void process_01(@Payload String msg) {
		logger.info("Topic RabbitMQ " + IRabbitMQConstants.QUEUE_NAME_TOPIC01 + " receive: " + msg);
	}
	
	@RabbitListener(queues=IRabbitMQConstants.QUEUE_NAME_TOPIC02)
	public void process_02(@Payload String msg) {
		logger.info("Topic RabbitMQ " + IRabbitMQConstants.QUEUE_NAME_TOPIC02 + " receive: " + msg);
	}
}
