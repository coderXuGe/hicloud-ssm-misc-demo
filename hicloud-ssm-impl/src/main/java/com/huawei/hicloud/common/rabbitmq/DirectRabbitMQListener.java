package com.huawei.hicloud.common.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.huawei.hicloud.common.constants.IRabbitMQConstants;



@Component
@RabbitListener(queues=IRabbitMQConstants.QUEUE_NAME_DIRECT)
public class DirectRabbitMQListener {
	private Logger logger = LoggerFactory.getLogger(DirectRabbitMQListener.class);
	
	@RabbitHandler
	public void rabbitHandler(@Payload String msg) {
		logger.info("Direct RabbitMQ receive: " + msg);
	}
}
