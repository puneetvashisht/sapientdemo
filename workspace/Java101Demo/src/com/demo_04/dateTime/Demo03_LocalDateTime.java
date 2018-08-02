package com.demo_04.dateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Demo03_LocalDateTime {
	public static void main(String[] args) {

  		System.out.println("Current date : "+getCurrentDateTime());


		System.out.println("Convert to a valid date: "+convertDateTime(2017, Month.FEBRUARY, 10, 23, 23, 23));		
//		System.out.println("Convert to a valid date: "+convertDate(2017, Month.FEBRUARY, 29, 23, 23, 23));

		System.out.println("Current DateTime in Kolkata: "+getZoneCurrentDateTime("Asia/Kolkata"));
		System.out.println("Current DateTime in Auckland: "+getZoneCurrentDateTime("Pacific/Auckland"));
		System.out.println("Current DateTime in Honolulu: "+getZoneCurrentDateTime("Pacific/Honolulu"));
		System.out.println("Current DateTime in Canada/Eastern: "+getZoneCurrentDateTime("Canada/Eastern"));
//		System.out.println("Current DateTime in IST: "+getZoneCurrentDate("India"));//java.time.zone.ZoneRulesException: Unknown time-zone ID: India

		long timeInSeconds = 60*60*24*365*46;
		System.out.println("From base date(01/01/1970), after "+timeInSeconds+" seconds: "+getDateTimeFromBase(timeInSeconds, 0, ZoneOffset.UTC));
		
		System.out.println("Format LocalDateTime");
		formatLocalDateTime(getCurrentDateTime());

	}
	
	public static LocalDateTime getCurrentDateTime(){
		return LocalDateTime.of(LocalDate.now(), LocalTime.now());
//		return LocalDateTime.now();
	}
	
	public static LocalDateTime convertDateTime(int year, Month month, int dayOfMonth, int hour, int minute, int second) {
		return LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
	}
	
	public static LocalDateTime getZoneCurrentDateTime(String zone){
		return LocalDateTime.now(ZoneId.of(zone));
	}
	
//	base date = 01/01/1970
	public static LocalDateTime getDateTimeFromBase(long timeInSeconds, int nanoSeconds, ZoneOffset zoneOffset){
		return LocalDateTime.ofEpochSecond(timeInSeconds, 0, ZoneOffset.UTC);
	}
	
	public static void formatLocalDateTime(LocalDateTime dateTime){
		System.out.println("\tDD:MM:YYYY = \t"+dateTime.format(DateTimeFormatter.ofPattern("dd:MM:uuuu")));
		System.out.println("\tDD:MMM:YYYY = \t"+dateTime.format(DateTimeFormatter.ofPattern("dd:MMM:uuuu")));
		System.out.println("\tMMM:DD:YY = \t"+dateTime.format(DateTimeFormatter.ofPattern("MMM:dd:uu")));
		System.out.println("\tDD/MM/YY = \t"+dateTime.format(DateTimeFormatter.ofPattern("dd/MM/uu")));
	}

}
