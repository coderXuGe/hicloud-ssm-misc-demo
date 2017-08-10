package com.huawei.hicloud.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * RabbitMQ producer client send message
 * @author dell
 *
 */
public class RabbitMQProducer {
	private static final String QUEUE_NAME = "HI_CLOUD";
	
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setUsername("root");
		factory.setPassword("root");
		factory.setPort(5672);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		String message = "Hello World! Rabbit guest 10002";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		
		System.out.println("[RabbitMQ producer]: " + message);
		
		channel.close();
		connection.close();
	}

}
