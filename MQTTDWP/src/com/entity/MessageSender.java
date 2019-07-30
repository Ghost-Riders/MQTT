package com.entity;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {
private static String url=ActiveMQConnection.DEFAULT_BROKER_URL;

private static String subject="JCG_QUEUE";

public static void MessageSenderM() {
	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
	try {
		Connection connection=connectionFactory.createConnection();
		connection.start();
		Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination=session.createQueue(subject);
		
		MessageProducer producer=session.createProducer(destination);
		
		TextMessage message=session.createTextMessage("Hello- this is activeMQ");
		
		producer.send(message);
		
		System.out.println("JCG printing@@ '"+ message.getText()+"'");
		connection.close();
	} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
