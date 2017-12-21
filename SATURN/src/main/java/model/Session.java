/*
 * SATURN 2017
 * Autors: blah blah
 */

package model;

public class Session implements Entity {
	int Group_ID;
	int Hours;
	String Classroom_Type;
	
	public int getGroup_ID() {
		return Group_ID;
	}
	public int getHours() {
		return Hours;
	}
	public int getClassroom_Type() {
		return Classroom_Type;
	}
	
	
	
	public void setGroup_ID() {
		this.Group_ID = Group_ID;
	}
	public void setHours() {
		this.Hours = Hours;
	}
	public void setClassroom_Type() {
		this.Classroom_Type = Classroom_Type;
	}
	
	
	public Session() {	
	}
	public Session(int Group_ID, int Hours, String Classroom_Type) {
		this.Group_ID = Group_ID;
		this.Hours = Hours;
		this.Classroom_Type = Classroom_Type;
	}
}
