package com.Controller_Entity;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class E_sender {
	private static String url=ActiveMQConnection.DEFAULT_BROKER_URL;

	private static String subject="CDAC";
	static int num=0;
	public static int sends(String msg) {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		try {
			Connection connection=connectionFactory.createConnection();
			connection.start();
			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination=session.createQueue(subject);
			
			MessageProducer producer=session.createProducer(destination);
			
			TextMessage message=session.createTextMessage(msg);
			
			producer.send(message);
			num+=1;
			System.out.println("JCG printing@@ '"+ message.getText()+"'");
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			num=0;
			e.printStackTrace();
			
		}
		return num;
		
	}
	
	
}
