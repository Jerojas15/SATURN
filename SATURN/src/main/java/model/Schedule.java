/*
 * SATURN 2017
 * Autors: blah blah
 */

package model;

public class Schedule implements Entity {
	int Day;
	int Start_Time;
	int Finish_Time;
	int Group;
	int Classroom;
	
	public int getDay() {
		return Day;
	}
	public int getStart_Time() {
		return Start_Time;
	}
	public int getFinish_Time() {
		return Finish_Time;
	}
	public int getGroup() {
		return Group;
	}
	public int getClassroom() {
		return Classroom;
	}
	
	
	
	public void setDay() {
		this.Day = Day;
	}
	public void setStart_Time() {
		this.Start_Time = Start_Time;
	}
	public void setFinish_Time() {
		this.Finish_Time = Finish_Time;
	}
	public void setGroup() {
		this.Group = Group;
	}
	public void setClassroom() {
		this.Classroom = Classroom;
	}
	
	
	public Schedule() {
	}
	public Schedule(int Day, int Start_Time, int Finish_Time, int Group, int Classroom) {
		this.Day = Day;
		this.Start_Time = Start_Time;
		this.Finish_Time = Finish_Time;
		this.Group = Group;
		this.Classroom = Classroom;
	}
}
