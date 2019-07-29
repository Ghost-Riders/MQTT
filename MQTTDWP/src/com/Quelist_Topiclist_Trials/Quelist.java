package com.Quelist_Topiclist_Trials;

import java.util.*;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.advisory.DestinationSource;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

public class Quelist {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory connectionFatory=new ActiveMQConnectionFactory(url);
		
		ActiveMQConnection connection=(ActiveMQConnection) connectionFatory.createConnection();
		
		connection.start();
		
		DestinationSource ds=connection.getDestinationSource();
		Set<ActiveMQQueue> queues= ds.getQueues();
		
		for(ActiveMQQueue queue: queues) {
			try {
				System.out.println(queue.getQueueName());
			} catch (Exception e) {	
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}

}
