/*
 * SATURN 2017
 * Autors: blah blah
 */

package model;

public class Group implements Entity {
    int ID;
    int Capacity;
    String Career;
    int Teacher;
    int Period;
    int Number;
    
    public int getID() {
        return ID;
    }
    public int getCapacity() {
        return Capacity;
    }
    public String getCareer() {
        return Career;
    }
    public int getTeacher() {
        return Teacher;
    }
    public int getPeriod() {
        return Period;
    }
    public int getNumber() {
        return Number;
    }
    
    
    
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }
    public void setCareer(String Career) {
        this.Career = Career;
    }
    public void setTeacher(int Teacher) {
        this.Teacher = Teacher;
    }
    public void setPeriod(int Period) {
        this.Period = Period;
    }
    public void setNumber(int Number) {
        this.Number = Number;
    }
    
    public Group() {	
    }
    public Group(int ID, int Capacity, String Career, int Teacher, int Period, int Number) {
    	this.ID = ID;
    	this.Capacity = Capacity;
    	this.Career = Career;
    	this.Teacher = Teacher;
    	this.Period = Period;
    	this.Number = Number;
    }
}
