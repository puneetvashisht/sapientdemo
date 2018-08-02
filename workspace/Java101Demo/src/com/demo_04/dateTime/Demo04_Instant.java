package com.demo_04.dateTime;

import java.time.Instant;


public class Demo04_Instant {
	public static void main(String[] args) {
		//Current timestamp
		Instant timestamp = Instant.now();
		
		//Instant of previous timestamp
		Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
		
		System.out.println("Current Timestamp: "+timestamp);
		System.out.println("Specific Time from timestamp: "+specificTime);
	}
}
