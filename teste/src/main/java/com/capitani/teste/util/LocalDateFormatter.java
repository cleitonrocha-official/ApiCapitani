package com.capitani.teste.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class LocalDateFormatter {
	
	static final private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public static DateTimeFormatter getFormat() {
		return formatter;
	}
	
	public static LocalDate parseData(String dataAte) {
		return LocalDate.parse(dataAte,LocalDateFormatter.getFormat());
	}
	
	public static String maxDate() {
		return LocalDate.MAX.format(getFormat());
		
	}
	
	public static String minDate() {
		return LocalDate.MIN.format(getFormat());
		
	}
}
