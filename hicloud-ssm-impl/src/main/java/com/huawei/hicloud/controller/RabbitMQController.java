package com.huawei.hicloud.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.hicloud.common.ResponseResult;
import com.huawei.hicloud.common.constants.IRabbitMQConstants;

@RestController
public class RabbitMQController {

	private Logger logger = LoggerFactory.getLogger(RabbitMQController.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@RequestMapping(value="/rabbitmq/send", method=RequestMethod.GET)
	public ResponseResult sendRabbitMQMessage(String msg, String routingKey) {
		logger.info("RabbitMQ send: " + msg);
		//System.out.println("SendRabbitMQ: ------" + connectionFactory);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		/* direct */
		//rabbitTemplate.convertAndSend(IConstants.RABBITMQ_QUEUE, sdf.format(new Date()) + " SendRabbitMQMessage: " + msg);
		
		/* topic> param1: exchange name, param2: routing key, param3: content */
		//rabbitTemplate.convertAndSend(IRabbitMQConstants.EXCHANGE_TOPIC, routingKey, sdf.format(new Date()) + " SendRabbitMQTopicMessage: " + msg);
		
		/* fanout */
		rabbitTemplate.convertAndSend(IRabbitMQConstants.EXCHANGE_FANOUT, "", sdf.format(new Date()) + " SendRabbitMQFanoutMessage: " + msg);
		
		
		return ResponseResult.build(200, "Send a message to RabbitMQ broker.", msg);
	}
}
