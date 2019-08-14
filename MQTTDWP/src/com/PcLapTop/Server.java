package com.PcLapTop;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Server {
	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(2000);
		Socket sk = ss.accept();
		Lapreceive receive = new Lapreceive();
		PCsend send=new PCsend();
		Scanner scanner = new Scanner(System.in);

		String s = null;
		String inputString=null;
		while (true) {
			System.out.println(".................................");
			
			s = receive.receives();
			System.out.println("Message from Client : " + s);
			if (!s.equals(null)) {
				System.out.println("Send Aknowledge to Client : ");
				inputString = scanner.nextLine();
				send.sends(inputString);
			}

			if (inputString.equalsIgnoreCase("END")) {

				break;
			}

		}
		ss.close();
		sk.close();

	}
}