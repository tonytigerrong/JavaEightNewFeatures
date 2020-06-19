package com.eight.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Demo {

	public static void main(String[] args){
		
		//DURATION/////////////////////////////////////////////////////
		Duration oneHour = Duration.ofHours(1);
		System.out.println(oneHour.getSeconds()+" seconds");
		Duration oneHour2 = Duration.of(1, ChronoUnit.HOURS);
		System.out.println(oneHour2.getSeconds()+" seconds");
		
		LocalDateTime start = LocalDateTime.of(1900,Month.APRIL,1, 18,45,00);
		LocalDateTime end   = LocalDateTime.of(2020, Month.APRIL,2, 18,45,00);
		Duration duration = Duration.between(start,end);
		System.out.println(duration.getSeconds()+" seconds");
		//PERIOD//////////////////////////////////////////////////////
		Period oneYearTwoMonthsTenDays = Period.of(1, 2, 10);
		System.out.println(oneYearTwoMonthsTenDays.getYears() + " Year");
		System.out.println(oneYearTwoMonthsTenDays.getMonths() + " Month");
		System.out.println(oneYearTwoMonthsTenDays.getDays() + " Days");
		
		LocalDate startD = LocalDate.of(2020, Month.JANUARY, 1);
		LocalDate endD   = LocalDate.of(2020, Month.DECEMBER, 31);
		Period period = Period.between(startD, endD);
		System.out.print(period.getYears() + " years,");
        System.out.print(period.getMonths() + " months,");
        System.out.print(period.getDays() + " days");
        System.out.println();
        
        //ChronoUnit///////////////////////////////////////////////////
        long years = ChronoUnit.YEARS.between(start, end);
        long months = ChronoUnit.MONTHS.between(start, end);
        long weeks = ChronoUnit.WEEKS.between(start, end);
        long days  = ChronoUnit.DAYS.between(start, end);
        long hours = ChronoUnit.HOURS.between(start,end);
        long minutes = ChronoUnit.MINUTES.between(start, end);
        long seconds = ChronoUnit.SECONDS.between(start,end);
        long milis  = ChronoUnit.MILLIS.between(start, end);
        long nano  = ChronoUnit.NANOS.between(start, end);
        System.out.println(years + " years");
        System.out.println(months + " months");
        System.out.println(weeks + " weeks");
        System.out.println(days + " days");
        System.out.println(hours + " hours");
        System.out.println(minutes + " minutes");
        System.out.println(seconds + " seconds");
        System.out.println(milis + " milis");
        System.out.println(nano + " nano");
		
		
	}
}
