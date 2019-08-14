package com.PcLapTop;

import java.net.URI;
import java.net.URISyntaxException;

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

public class Lapreceive {

private static String url=ActiveMQConnection.DEFAULT_BROKER_URL;
	
	private static String subject="queue1";
	static String rec=null;
	public static String receives() throws URISyntaxException {
		URI u=new URI("tcp://10.226.35.172:61616");
				String uri=u.toString();
		ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(uri);
		
		try {
			Connection connection=connectionFactory.createConnection();
			connection.start();
			
			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			String id=connection.getClientID();
			System.out.println(id);
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
