package com.PcLapTop;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class PCreceive {

private static String url=ActiveMQConnection.DEFAULT_BROKER_URL;
	
	private static String subject="Device1";
	static String rec;
	public static String receives() {
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(url);
		
		try {
			Connection connection=connectionFactory.createConnection();
			connection.start();
			
			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue(subject);
			
			MessageConsumer consumer=session.createConsumer(destination);
			
			Message message=consumer.receive();
			
			if(message instanceof TextMessage) {
				TextMessage textMessage=(TextMessage)message;
			
				rec=textMessage.getText();
			//	System.out.println("PCreceive : " + rec);
					}
			connection.close();
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rec;
		
	}
}
