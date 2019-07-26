package com.JMSTopicEx;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener {
	private String consumerName;
	public ConsumerMessageListener(String consumerName) {
		// TODO Auto-generated constructor stub
		this.consumerName=consumerName;
	}

	
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		TextMessage textMessage = (TextMessage) message;
		
		try {
			System.out.println(consumerName +" received: "+ textMessage.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
