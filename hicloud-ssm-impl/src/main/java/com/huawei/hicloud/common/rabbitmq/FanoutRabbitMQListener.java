package com.huawei.hicloud.common.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.huawei.hicloud.common.constants.IRabbitMQConstants;

@Component
public class FanoutRabbitMQListener {
	private Logger logger = LoggerFactory.getLogger(FanoutRabbitMQListener.class);
	
	@RabbitListener(queues=IRabbitMQConstants.QUEUE_NAME_FANOUT01)
	public void process_01(@Payload String msg) {
		logger.info("Fanout RabbitMQ process_01 receive: " + msg);
	}
	
	@RabbitListener(queues=IRabbitMQConstants.QUEUE_NAME_FANOUT02)
	public void process_02(@Payload String msg) {
		logger.info("Fanout RabbitMQ process_02 receive: " + msg);
	}
	
	@RabbitListener(queues=IRabbitMQConstants.QUEUE_NAME_FANOUT03)
	public void process_03(@Payload String msg) {
		logger.info("Fanout RabbitMQ process_03 receive: " + msg);
	}
}
