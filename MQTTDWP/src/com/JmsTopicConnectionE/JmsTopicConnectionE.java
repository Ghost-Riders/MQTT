package com.JmsTopicConnectionE;

import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.advisory.ConsumerEvent;
import org.apache.activemq.advisory.ConsumerListener;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

import com.JMSTopicEx.ConsumerMessageListener;

public class JmsTopicConnectionE {

	public static void JmsTopicConnectionEM(String tt) throws URISyntaxException, Exception {
	//	BrokerService broker=BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
		//broker.setPersistent(true);
		//broker.start();
		//String uri=ActiveMQConnection.DEFAULT_BROKER_URL;
		URI u=new URI("tcp://10.226.35.172:61616");
		String uri=u.toString();
		TopicConnection topicConnection=null;
		
		try {
			TopicConnectionFactory connectionFactory=new ActiveMQConnectionFactory(uri);
			
			topicConnection = connectionFactory.createTopicConnection();
			topicConnection.setClientID(tt);
			
			TopicSession topicConsumerSession=topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Topic topic=topicConsumerSession.createTopic(tt);
			
			//subscribe
			
			MessageConsumer consumer1=topicConsumerSession.createSubscriber(topic);
			consumer1.setMessageListener(new ConsumerMessageListener("Consumer1"));
			
			MessageConsumer consumer2=topicConsumerSession.createSubscriber(topic);
			consumer2.setMessageListener(new ConsumerMessageListener("Consumer2"));
			
			topicConnection.start();
			
			
			TopicSession topicPublisheSession= topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			String payload="Important Task";
			Message msg=topicPublisheSession.createTextMessage(payload);
			TopicPublisher publisher=topicPublisheSession.createPublisher(topic);
			System.out.println("Sending tex : '" +payload +"'");
			publisher.publish(msg);
			
			
			Thread.sleep(3000);
			topicPublisheSession.close();
			topicConsumerSession.close();
		} finally {
			if(topicConnection !=null) {
				topicConnection.close();
			}
		}
	}

}
