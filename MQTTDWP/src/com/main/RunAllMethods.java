package com.main;

import java.net.URISyntaxException;

import javax.jms.JMSException;

import com.JMSTopicEx.JmsTopicE;
import com.JmsTopicConnectionE.JmsTopicConnectionE;
import com.Quelist_Topiclist_Trials.Quelist;
import com.Quelist_Topiclist_Trials.Topic_list;
import com.useless.Demo;

public class RunAllMethods {

	public static void main(String[] args) throws URISyntaxException, Exception {
		// TODO Auto-generated method stub

//		System.out.println("Quelist from ActiveMQ");
//		Quelist q=new Quelist();
//		q.Qulist();
//		
//		System.out.println("Topic list from ActiveMQ");
//		Topic_list t= new Topic_list();
//		t.Topic_listM();
//		
//		JmsTopicE j=new JmsTopicE();
//		j.JmsTopicEM();

		System.out.println("welcome");
//		 JmsTopicConnectionE jt = new JmsTopicConnectionE();
//		 jt.JmsTopicConnectionEM("welcome", "welcome");
		Demo d=new Demo();
		d.demo();
	}

	

}
