package com.parallelRuns;

import java.time.LocalTime;
import java.time.ZoneId;

public class StartRUn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		ZoneId zone1 = ZoneId.of("Asia/Kolkata");

		LocalTime start = LocalTime.now(zone1);
		System.out.println("Start Time for first : " + start);
		trun();
		
	}
	public static void trun() {
		para1 d1 = new para1();
		para2 d2 = new para2();
		para3 d3 = new para3();
		para4 d4 = new para4();
		para5 d5 = new para5();
		
		d1.start();d2.start();d3.start();d4.start();d5.start();
		
		
		
	}

}
