package com.PcLapTop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import com.useless.Demo;

public class Client {
	public static void main(String args[]) throws Exception {
		Socket sk = new Socket("10.226.35.172", 2000);
		Lapsend send = new Lapsend();
		PCreceive receive = new PCreceive();
		Scanner scanner = new Scanner(System.in);

		String s = null;
		while (true) {
			
			System.out.println("Enter Message to send Server");
			String inputString = scanner.nextLine();
			send.sends(inputString);
			
			s = receive.receives();
			if (!s.equals(null)) {
				System.out.println("Message Receiver from Server: " + s);
			}
			
			if (inputString.equalsIgnoreCase("BYE")) {
				System.out.println("Connection Closed....");
			break;
			}
		}
		sk.close();
	}
}