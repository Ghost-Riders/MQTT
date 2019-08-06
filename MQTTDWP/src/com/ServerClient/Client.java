package com.ServerClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import com.useless.Demo;

public class  Client
{
	public static void main(String args[]) throws Exception
	{
		Socket sk=new Socket("10.226.35.172",2000);
		BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream sout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
//		while (  true )
//		{
//			System.out.print("Client : ");
//			s=stdin.readLine();
//			sout.println(s);
//			s=sin.readLine();
//			System.out.print("Server : "+s+"\n");
//  			if ( s.equalsIgnoreCase("BYE") )
// 			   break;
//		}
		System.out.println("Start ------------------------");
		Demo d=new Demo();
		d.demo();
		System.out.println("End ------------------------");
		 sk.close();
		 sin.close();
		 sout.close();
 		stdin.close();
	}
}