/*
 * SATURN 2017
 * Autors: blah blah
 */

package model;

public class Availability implements Entity {
	int Teacher;
	int Start_Time;
	int Finish_Time;
	int Day;
	
	public int getTeacher() {
		return Teacher;
	}
	public int getStart_Time() {
		return Start_Time;
	}
	public int getFinish_Time() {
		return Finish_Time;
	}
	public int getDay() {
		return Day;
	}
	
	
	
	public void setTeacher() {
		this.Teacher = Teacher;
	}
	public void setStart_Time() {
		this.Start_Time = Start_Time;
	}
	public void setFinish_Time() {
		this.Finish_Time = Finish_Time;
	}
	public void setDay() {
		this.Day = Day;
	}
	
	
	public Availability() {
	}
	public Availability(int Teacher, int Start_Time, int Finish_Time, int Day) {
		this.Teacher = Teacher;
		this.Start_Time = Start_Time;
		this.Finish_Time = Finish_Time;
		this.Day = Day;
	}
    
}
