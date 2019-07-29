package com.Controller_Entity;

import java.util.*;

import javax.jms.JMSException;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.advisory.DestinationSource;
import org.apache.activemq.command.ActiveMQTopic;

public class E_Topic_list {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static List<String> tlist() throws JMSException {
		List<String> ls = new ArrayList<String>();
		ActiveMQConnectionFactory connectionFatory = new ActiveMQConnectionFactory(url);

		ActiveMQConnection connection = (ActiveMQConnection) connectionFatory.createConnection();

		connection.start();

		DestinationSource ds = connection.getDestinationSource();
		Set<ActiveMQTopic> topi = ds.getTopics();

		for (ActiveMQTopic top : topi) {
			try {
				System.out.println(top.getTopicName());
				ls.add(top.getTopicName());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return ls;

	}

}
