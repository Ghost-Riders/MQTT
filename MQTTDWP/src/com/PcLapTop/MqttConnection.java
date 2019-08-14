package com.PcLapTop;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.JMSTopicEx.ConsumerMessageListener;

public class MqttConnection {
	static String uri = ActiveMQConnection.DEFAULT_BROKER_URL;
	TopicConnection topicConnection=null;
	TopicSession topicConsumerSession=null;
	Topic topic=null;
	public TopicConnection getconnection(String name) {
		
		try {
			TopicConnectionFactory connectionFactory=new ActiveMQConnectionFactory(uri);
			topicConnection = connectionFactory.createTopicConnection();
			 topicConsumerSession=topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			 topic=topicConsumerSession.createTopic(name);
			System.out.println("Topic Verified......");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			System.out.println("Error---MqttConnection--getconnection.");
			e.printStackTrace();
		}
		
		return topicConnection;
	}
	public void MqttConsumer(String consumername) {
		try {
			MessageConsumer consumer=topicConsumerSession.createSubscriber(topic);
			consumer.setMessageListener(new ConsumerMessageListener(consumername));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			System.out.println("Error--MqttConnection-mqttConsumer");
			e.printStackTrace();
		}
	}
	
	public void MqttcloseConnection() {
		 try {
			topicConnection.close();
			System.out.println("Connection Closed sucessfully");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
