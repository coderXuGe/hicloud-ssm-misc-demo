package com.huawei.hicloud.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

/**
 * RabbitMQ consumer client receive message
 * 
 * @author dell
 *
 */
@SuppressWarnings("deprecation")
public class RabbitMQConsumer {
	private static final String QUEUE_NAME = "RQ-HELLO";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setUsername("guest");
		factory.setPassword("guest");
		factory.setPort(5672);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);
		System.out.println("[RabbitMQ consumer]: Waiting for message.press CTRL+C to exit");

		while (true) {
			Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println("[RabbitMQ consumer]: Received " + message);
		}

	}

}
