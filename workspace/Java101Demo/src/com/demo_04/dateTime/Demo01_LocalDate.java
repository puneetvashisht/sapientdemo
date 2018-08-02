package com.demo_04.dateTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;
import java.util.TreeSet;

public class Demo01_LocalDate {
	public static void main(String[] args) {

  		System.out.println("Current date : "+getToday());
  		getEach(getToday());


		System.out.println("Convert to a valid date: "+convertDate(2017, Month.FEBRUARY, 10));		
//		System.out.println("Convert to a valid date: "+convertDate(2017, Month.FEBRUARY, 29)); //java.time.DateTimeException: Invalid date 'February 29' as '2017' is not a leap year

//		displayValidTimeZones();
		
		System.out.println("Current Date in Kolkata: "+getZoneCurrentDate("Asia/Kolkata"));
		System.out.println("Current Date in Auckland: "+getZoneCurrentDate("Pacific/Auckland"));
		System.out.println("Current Date in Honolulu: "+getZoneCurrentDate("Pacific/Honolulu"));
		System.out.println("Current Date in Canada/Eastern: "+getZoneCurrentDate("Canada/Eastern"));
//		System.out.println("Current Date in IST: "+getZoneCurrentDate("India"));//java.time.zone.ZoneRulesException: Unknown time-zone ID: India

		int numOfDays = 6055;
		System.out.println("From base date(01/01/1970), after "+numOfDays+" days: "+getDateFromBase(numOfDays));

		System.out.println("100th day of current year: "+getNthDay(2017, 100));
		
		formatLocalDate(getToday());
		localDateUtilities(getToday());
	}
	
	public static LocalDate getToday(){
		return LocalDate.now();
	}
	
	public static void getEach(LocalDate date) {
		System.out.println("From LocalDate: ");
		System.out.println("\tYear: "+date.getYear());
		System.out.println("\tMonth: "+date.getMonthValue());
		System.out.println("\tDate: "+date.getDayOfMonth());
		System.out.println("\tDay: "+date.getDayOfWeek());
	}
	
	public static LocalDate convertDate(int year, Month month, int dayOfMonth){
		return LocalDate.of(year, month, dayOfMonth);
	}
	
	public static LocalDate getZoneCurrentDate(String zone){
		return LocalDate.now(ZoneId.of(zone));

		//java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		//LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));
	}
	
//	base date = 01/01/1970
	public static LocalDate getDateFromBase(int days){
		return LocalDate.ofEpochDay(days);
//		System.out.println("365th day from base date= "+dateFromBase);
	}
	public static LocalDate getNthDay(int year, int day){
		return LocalDate.ofYearDay(year, day);
	}
	
	public static void formatLocalDate(LocalDate date){
		System.out.println("Format LocalDate");

		System.out.println("\tDD:MM:YYYY = \t"+date.format(DateTimeFormatter.ofPattern("dd:MM:uuuu")));
		System.out.println("\tDD:MMM:YYYY = \t"+date.format(DateTimeFormatter.ofPattern("dd:MMM:uuuu")));
		System.out.println("\tMMM:DD:YY = \t"+date.format(DateTimeFormatter.ofPattern("MMM:dd:uu")));
		System.out.println("\tDD/MM/YY = \t"+date.format(DateTimeFormatter.ofPattern("dd/MM/uu")));
	}
	
	public static void localDateUtilities(LocalDate date){
		System.out.println("LocalDate utilities");
		System.out.println("\tDay of current date is : "+date.getDayOfWeek());
		
		System.out.println("\tYear "+date.getYear()+" is Leap Year? "+date.isLeapYear());
		
		System.out.println("\tToday is after 01/01/2019? "+date.isBefore(LocalDate.of(2015,1,1)));
		
		System.out.println("\tCurrent Time="+date.atTime(LocalTime.now()));
		
		System.out.println("\t5 months after today: "+date.plusMonths(5));
		System.out.println("\t16 weeks after today: "+date.plusWeeks(16));
		System.out.println("\t55 days after today: "+date.plusDays(55));

		System.out.println("\t4 months before today: "+date.minusMonths(4));
		System.out.println("\t5 weeks before today: "+date.minusWeeks(5));
		System.out.println("\t13 days before today: "+date.minusDays(13));
		
		System.out.println("\tFirst date of current month: "+date.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println("\tLast date of current year: "+date.with(TemporalAdjusters.lastDayOfYear()));
		System.out.println("\tFirst Sunday of this month: "+date.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)));
	}
	
	public static void displayValidTimeZones(){
		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
		TreeSet<String> sortedZones = new TreeSet<>(availableZoneIds);
        
        System.out.println("Number of zones: " + sortedZones.size());
        System.out.println("\nAvailable Zones");
 
        for (String zone : sortedZones) {
            System.out.println("\t"+zone);
        }
	}
}
