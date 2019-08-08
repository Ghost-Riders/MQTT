package com.parallelRuns;

import java.net.URISyntaxException;

import com.JmsTopicConnectionE.JmsTopicConnectionE;

public class para4 extends Thread{
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

					if (counter >= 301 && counter <= 400) {
						System.out.println("para2 Topic Name: " + raw + " :" + counter);
						// jm.JmsTopicEM(raw);
						try {
							jt.JmsTopicConnectionEM("welcome", raw);
							System.out.println(raw);
							System.out.println("para2 count :" + counter);
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
