package com.writeTimeToFile;

import java.time.Duration;
import java.time.Period;
import java.time.Instant;
import java.time.LocalDate;

public class Time {
	
	private Instant timeStartedStudying = Instant.now();
	private Instant timeStoppedStudying;
	private Duration totalStudyTime;
	private LocalDate today;

	
	public Time() {
		this(Instant.now(), LocalDate.now());
	}
	
	public Time(Instant timeStartedStudying, LocalDate today) {
		
		setTimeStartedStudying(timeStartedStudying);
		setToday(today);		
	}

	public Instant getTimeStartedStudying() {
		return timeStartedStudying;
	}

	public void setTimeStartedStudying(Instant timeStartedStudying) {
		this.timeStartedStudying = timeStartedStudying;
	}

	public Instant getTimeStoppedStudying() {
		return timeStoppedStudying;
	}

	public void setTimeStoppedStudying(Instant timeStoppedStudying) {
		this.timeStoppedStudying = timeStoppedStudying;
	}

	public Duration getTotalStudyTimeToday() {
		return Duration.between(getTimeStartedStudying(), getTimeStoppedStudying());
	}

	public Duration getTotalStudyTime() {
		return totalStudyTime;
	}

	public void setTotalStudyTime() {
		totalStudyTime.plus(getTotalStudyTimeToday());
	}

	public LocalDate getToday() {
		return today;
	}

	public void setToday(LocalDate today) {
		this.today = today;
	}
}
