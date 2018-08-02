package com.demo_03.stream;

public class Task {
	private final Status status;
	private final Integer points;
	
	Task(Status status, Integer points ) {
		this.status = status;
		this.points = points;
	}
	
	public Integer getPoints() {
		return points;
	}
	
	public Status getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return "["+status+", "+points+"]";
	}

}
