package com.eight.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Demo {

	public static void main(String[] args) {

		// DURATION
		Duration oneHour = Duration.ofHours(1);
		System.out.println(oneHour.getSeconds() + " seconds");
		Duration oneHour2 = Duration.of(1, ChronoUnit.HOURS);
		System.out.println(oneHour2.getSeconds() + " seconds");

		LocalDateTime start = LocalDateTime.of(1900, Month.APRIL, 1, 18, 45, 00);
		LocalDateTime end = LocalDateTime.of(2020, Month.APRIL, 2, 18, 45, 00);
		Duration duration = Duration.between(start, end);
		System.out.println(duration.getSeconds() + " seconds");
		// PERIOD
		Period oneYearTwoMonthsTenDays = Period.of(1, 2, 10);
		System.out.println(oneYearTwoMonthsTenDays.getYears() + " Year");
		System.out.println(oneYearTwoMonthsTenDays.getMonths() + " Month");
		System.out.println(oneYearTwoMonthsTenDays.getDays() + " Days");

		LocalDate startD = LocalDate.of(2020, Month.JANUARY, 1);
		LocalDate endD = LocalDate.of(2020, Month.DECEMBER, 31);
		Period period = Period.between(startD, endD);
		System.out.print(period.getYears() + " years,");
		System.out.print(period.getMonths() + " months,");
		System.out.print(period.getDays() + " days");
		System.out.println();

		// ChronoUnit
		long years = ChronoUnit.YEARS.between(start, end);
		long months = ChronoUnit.MONTHS.between(start, end);
		long weeks = ChronoUnit.WEEKS.between(start, end);
		long days = ChronoUnit.DAYS.between(start, end);
		long hours = ChronoUnit.HOURS.between(start, end);
		long minutes = ChronoUnit.MINUTES.between(start, end);
		long seconds = ChronoUnit.SECONDS.between(start, end);
		long milis = ChronoUnit.MILLIS.between(start, end);
		long nano = ChronoUnit.NANOS.between(start, end);
		System.out.println(years + " years");
		System.out.println(months + " months");
		System.out.println(weeks + " weeks");
		System.out.println(days + " days");
		System.out.println(hours + " hours");
		System.out.println(minutes + " minutes");
		System.out.println(seconds + " seconds");
		System.out.println(milis + " milis");
		System.out.println(nano + " nano");

		// DateTimeFormatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "30/06/2020";
		LocalDate localDate = LocalDate.parse(date1, formatter); // convert
																	// string to
																	// date
		String date2 = "1930-06-20";
		LocalDate localDate2 = LocalDate.parse(date2); // default formate string
														// to date, no need
														// formate
		System.out.println(formatter.format(localDate2)); // output:20/06/1930

		// Locale.US FRANCE
		Locale.setDefault(Locale.FRANCE);
		// DateTimeFormatter formatter1 =
		// DateTimeFormatter.ofPattern("d-MMM-yyyy");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("E, d-MMM-yyyy", Locale.US);
		String date = "Tue, 16-Aug-2016"; // can't parse English month name by
											// France month
		LocalDate localDate3 = LocalDate.parse(date, formatter1);
		System.out.println(localDate3);
		System.out.println(formatter.format(localDate3));

		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a", Locale.US);
		String date4 = "Tuesday, Aug 16, 2016 12:10:56 PM";
		LocalDateTime localDateTime = LocalDateTime.parse(date4, formatter4);
		System.out.println(localDateTime);
		System.out.println(formatter.format(localDateTime));

		// Instant ZoneDateTime
		Instant instant = Instant.now();
		ZonedDateTime asiaDateTime = instant.atZone(ZoneId.of("Asia/Tokyo"));
		System.out.println(asiaDateTime);
		ZonedDateTime europDateTime = instant.atZone(ZoneId.of("Europe/Athens"));
		System.out.println(europDateTime);
		ZonedDateTime atlanticDateTime = instant.atZone(ZoneId.of("Canada/Atlantic"));
		System.out.println(atlanticDateTime);
		ZonedDateTime pacificDateTime = instant.atZone(ZoneId.of("Canada/Pacific"));
		System.out.println(pacificDateTime);

		// toLocalDate
		LocalDateTime local = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println("System Default ZoneId:" + ZoneId.systemDefault());
		System.out.println(local);

		// DateTimeParseException
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.CANADA);
		try {
			LocalDate localDate5 = LocalDate.parse("8-Abc-2015", dtf);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		}
		
		
	}

}
