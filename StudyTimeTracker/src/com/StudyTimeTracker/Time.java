package com.StudyTimeTracker;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m:s");
	
	public static void currentTime() {
		Thread clock = new Thread() {
			public void run() {
				LocalTime.now().format(formatter); 
			}
		};
		
	}
}
