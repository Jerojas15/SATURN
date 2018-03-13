/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jose
 */
public class ClassGroup {
    String CourseName;
    String University;
    int StartHour;
    int EndHour;
    int Day;    
    public ClassGroup(){}
    
    public String getCourseName() {
        return CourseName;
    }
    public String getUniversity() {
        return University;
    }
    public int getStartHour() {
        return StartHour;
    }
    public int getEndHour() {
        return EndHour;
    }
    public int getDay() {
        return Day;
    }
    
    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }
    public void setUniversity(String University) {
        this.University = University;
    }
    public void setStartHour(int StartHour) {
        this.StartHour = StartHour;
    }
    public void setEndHour(int EndHour) {
        this.EndHour = EndHour;
    }
    public void setDay(int Day) {
        this.Day = Day;
    }
  
            
}
