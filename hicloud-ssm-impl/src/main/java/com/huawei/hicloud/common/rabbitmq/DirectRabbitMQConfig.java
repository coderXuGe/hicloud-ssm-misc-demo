package com.huawei.hicloud.common.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.huawei.hicloud.common.constants.IRabbitMQConstants;


@Configuration
public class DirectRabbitMQConfig {
	
	/* direct queue */
	@Bean
	public Queue queueDirect() {
		return new Queue(IRabbitMQConstants.QUEUE_NAME_DIRECT);
	}
	
}
