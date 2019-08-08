package com.useless;

import java.net.URISyntaxException;

import com.JmsTopicConnectionE.JmsTopicConnectionE;

public class Demo {
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

					if (counter >= 1 && counter <= 100) {
						System.out.println("Topic Name: " + raw + " :" + counter);
						// jm.JmsTopicEM(raw);
						jt.JmsTopicConnectionEM("zAnir", raw);
						System.out.println(raw);

					}
				}
			}
		}
		System.out.println("count :" + counter);

	}
}
