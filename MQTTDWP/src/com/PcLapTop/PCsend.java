package com.PcLapTop;

import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class PCsend {
	private static String url=ActiveMQConnection.DEFAULT_BROKER_URL;

	private static String subject="Device1";

	public static String sends(String msg) throws URISyntaxException {
		URI u=new URI("tcp://10.226.35.172:61616");
				String uri=u.toString();
		String text=null;
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(uri);
		try {
			Connection connection=connectionFactory.createConnection();
			connection.start();
			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination=session.createQueue(subject);
			
			MessageProducer producer=session.createProducer(destination);
			
			TextMessage message=session.createTextMessage(msg);
			
			producer.send(message);
			
		//	System.out.println("PCsend : '"+ message.getText()+"'");
			text=message.getText();
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			
		}
		return text;
		
	}
	
	
}
