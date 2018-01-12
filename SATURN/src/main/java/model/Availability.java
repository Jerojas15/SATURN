package model;

public class Availability {
	
	public static enum DAY {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

	private int teacherId;
	private int startHour;
	private int endHour;
	private int day;

	public Availability() {}

	public Availability(int teacherId, int day, int startHour, int endHour) {
		this.teacherId = teacherId;
		this.day = day;
		this.startHour = startHour;
		this.endHour = endHour;
	}

	public int getTeacher() {
		return teacherId;
	}
	public int getStartHour() {
		return startHour;
	}
	public int getEndHour() {
		return endHour;
	}
	public int getDay() {
		return day;
	}

	public void setTeacher(int teacherId) {
		this.teacherId = teacherId;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	public void setDay(int day) {
		this.day = day;
	}

}
