package com.JMSTopicEx;

import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class JmsTopicE {

	public static void main(String[] args) throws URISyntaxException, Exception {
		// TODO Auto-generated method stub
		BrokerService broker=BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
		broker.start();
		
		Connection connection=null;
		
		try {
			ConnectionFactory connectionFactory= new ActiveMQConnectionFactory("tcp://localhost:61616");
			
			connection=connectionFactory.createConnection();
			
			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Topic topic= session.createTopic("customerTopic");
			
			MessageConsumer consumer1=session.createConsumer(topic);
			consumer1.setMessageListener(new ConsumerMessageListener("Consumer1"));
			
			MessageConsumer consumer2=session.createConsumer(topic);
			consumer2.setMessageListener(new ConsumerMessageListener("Consumer2"));
			
			connection.start();
			
			//publish msg
			String payload="Imp TaSK";
			Message msg=session.createTextMessage(payload);
			MessageProducer producer=session.createProducer(topic);
			System.out.println("Sending text '"+ payload +"'");
			producer.send(msg);
			
			Thread.sleep(3000);
			session.close();
		} finally {
			if(connection !=null) {
				connection.close();
			}
			broker.stop();
		}
	}

}
