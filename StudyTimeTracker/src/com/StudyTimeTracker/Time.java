package com.StudyTimeTracker;

import java.time.LocalDate;
import java.time.LocalTime;

public class Time {
	
	private LocalTime timeStartedStudying;
	private LocalTime timeStoppedStudying;
	private LocalTime totalStudyTimeToday;
	private LocalTime totalStudyTime;
	private LocalDate today;
	
	public Time() {
		
	}
	
	public Time(LocalTime timeStartedStudying, LocalTime timeStoppedStudying, LocalTime totalStudyTimeToday,
			LocalTime totalStudyTime, LocalDate today) {
		
		setTimeStartedStudying(timeStartedStudying);
		setTimeStoppedStudying(timeStoppedStudying);
		setTotalStudyTimeToday(totalStudyTimeToday);
		setTotalStudyTime(totalStudyTime);
		setToday(today);		
	}

	public LocalTime getTimeStartedStudying() {
		return timeStartedStudying;
	}

	public void setTimeStartedStudying(LocalTime timeStartedStudying) {
		this.timeStartedStudying = timeStartedStudying;
	}

	public LocalTime getTimeStoppedStudying() {
		return timeStoppedStudying;
	}

	public void setTimeStoppedStudying(LocalTime timeStoppedStudying) {
		this.timeStoppedStudying = timeStoppedStudying;
	}

	public LocalTime getTotalStudyTimeToday() {
		return totalStudyTimeToday;
	}

	public void setTotalStudyTimeToday(LocalTime totalStudyTimeToday) {
		this.totalStudyTimeToday = totalStudyTimeToday;
	}

	public LocalTime getTotalStudyTime() {
		return totalStudyTime;
	}

	public void setTotalStudyTime(LocalTime totalStudyTime) {
		this.totalStudyTime = totalStudyTime;
	}

	public LocalDate getToday() {
		return today;
	}

	public void setToday(LocalDate today) {
		this.today = today;
	}
}
