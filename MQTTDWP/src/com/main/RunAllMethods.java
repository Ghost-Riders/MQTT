package com.main;

import javax.jms.JMSException;

import com.Quelist_Topiclist_Trials.Quelist;
import com.Quelist_Topiclist_Trials.Topic_list;

public class RunAllMethods {

	public static void main(String[] args) throws JMSException {
		// TODO Auto-generated method stub
		
		System.out.println("Quelist from ActiveMQ");
		Quelist q=new Quelist();
		q.Qulist();
		
		System.out.println("Topic list from ActiveMQ");
		Topic_list t= new Topic_list();
		t.Topic_listM();
	}

}
