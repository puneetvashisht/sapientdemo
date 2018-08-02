package com.demo_04.dateTime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class Demo02_LocalTime {
	public static void main(String[] args) {

  		System.out.println("Current time : "+getTime());

		System.out.println("Convert to valid time: "+convertTime(23, 23, 23));		

		
		System.out.println("Current Time in Kolkata: "+getZoneCurrentTime("Asia/Kolkata"));
		System.out.println("Current Time in Auckland: "+getZoneCurrentTime("Pacific/Auckland"));
		System.out.println("Current Time in Honolulu: "+getZoneCurrentTime("Pacific/Honolulu"));
		System.out.println("Current Time in Canada/Eastern: "+getZoneCurrentTime("Canada/Eastern"));


		int timeInSeconds = 60*60*3;
		System.out.println("From base time(00:00:00), after "+timeInSeconds+" seconds: "+getTimeFromBase(timeInSeconds));
		
		// Get duration between two dates
		LocalDateTime from = LocalDateTime.of( 2017, Month.JANUARY, 31, 0, 0, 0 );
		LocalDateTime to = LocalDateTime.of( 2017, Month.FEBRUARY, 13, 23, 59, 59 );

		getDurationBetween(from, to);
	}
	
	public static LocalTime getTime(){
		return LocalTime.now();
	}
	
	public static LocalTime convertTime(int hour, int minute, int second){
		return LocalTime.of(hour, minute, second);
//		return LocalTime.of(hour, minute, second, 00);// last arg is int nanoOfSecond
	}
	
	public static LocalTime getZoneCurrentTime(String zone){
		return LocalTime.now(ZoneId.of(zone));
	}
	
//	base time = 00:00:00
	public static LocalTime getTimeFromBase(int seconds){
		return LocalTime.ofSecondOfDay(seconds);
	}
	
	public static void getDurationBetween(LocalDateTime from, LocalDateTime to){
		Duration duration = Duration.between( from, to );
		System.out.println( "Duration in days: " + duration.toDays() );
		System.out.println( "Duration in hours: " + duration.toHours() );
	}

	
}
