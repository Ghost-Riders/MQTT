package com.parallelRuns;

import java.net.URISyntaxException;

import com.JmsTopicConnectionE.JmsTopicConnectionE;

public class para1 extends Thread{
	public void run(){
		String raw;
		// JmsTopicE jm=new JmsTopicE();
		JmsTopicConnectionE jt = new JmsTopicConnectionE();
		int counter = 0;
		for (char i = 'a'; i <= 'z'; i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				for (char k = 'a'; k <= 'z'; k++) {
					raw = Character.toString(i) + Character.toString(j) + Character.toString(k);
					counter++;

					if (counter >= 1 && counter <= 100) {
						System.out.println("Topic Name: " + raw + " :" + counter);
						// jm.JmsTopicEM(raw);
						try {
							jt.JmsTopicConnectionEM("welcome2", raw);
							System.out.println(raw);
							System.out.println("count :" + counter);
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						

					}
				}
			}
		}
		

	}
}
