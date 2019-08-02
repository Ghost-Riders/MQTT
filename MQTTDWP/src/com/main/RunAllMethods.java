package com.main;

import java.net.URISyntaxException;

import javax.jms.JMSException;

import com.JMSTopicEx.JmsTopicE;
import com.JmsTopicConnectionE.JmsTopicConnectionE;
import com.Quelist_Topiclist_Trials.Quelist;
import com.Quelist_Topiclist_Trials.Topic_list;

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
		// JmsTopicConnectionE jt = new JmsTopicConnectionE();
		// jt.JmsTopicConnectionEM("welcome");
		demo();
	}

	public static void demo() throws URISyntaxException, Exception {
		String raw;
		// JmsTopicE jm=new JmsTopicE();
		JmsTopicConnectionE jt = new JmsTopicConnectionE();
		int counter = 0;
		for (char i = 'a'; i <= 'z'; i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				for (char k = 'a'; k <= 'z'; k++) {
					raw = Character.toString(i) + Character.toString(j) + Character.toString(k);
					counter++;

					if (counter >= 1400 && counter <= 1600) {
						System.out.println("Topic Name: " + raw + " :" + counter);
						// jm.JmsTopicEM(raw);
						jt.JmsTopicConnectionEM(raw);
						System.out.println(raw);

					}
				}
			}
		}
		System.out.println("count :" + counter);

	}

}
