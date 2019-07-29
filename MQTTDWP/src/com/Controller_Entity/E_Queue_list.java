package com.Controller_Entity;

import java.util.*;

import javax.jms.JMSException;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.advisory.DestinationSource;
import org.apache.activemq.command.ActiveMQQueue;

public class E_Queue_list {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static List<String> qlist() throws JMSException {
		List<String> ls=new ArrayList<String>();
		ActiveMQConnectionFactory connectionFatory=new ActiveMQConnectionFactory(url);
		
		ActiveMQConnection connection=(ActiveMQConnection) connectionFatory.createConnection();
		
		connection.start();
		
		DestinationSource ds=connection.getDestinationSource();
		Set<ActiveMQQueue> queues= ds.getQueues();
		
		for(ActiveMQQueue queue: queues) {
			try {
				System.out.println(queue.getQueueName());
				ls.add(queue.getQueueName());
			} catch (Exception e) {	
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return ls;
		
	}

}
