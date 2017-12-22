/*
 * SATURN 2017
 * Autors: blah blah
 */

package model;

public class Priority implements Entity {
    int Teacher;
    String Career;
    int Priority_Level;

    public int getTeacher() {
        return Teacher;
    }
    public String getCareer() {
        return Career;
    }
    public int getPriority_Level() {
        return Priority_Level;
    }



    public void setTeacher(int Teacher) {
        this.Teacher = Teacher;
    }
    public void setCareer(String Career) {
        this.Career = Career;
    }
    public void setPriority_Level(int Priority_Level) {
        this.Priority_Level = Priority_Level;
    }

    public Priority(){

    }
    public Priority(int Teacher, String Career, int Priority_Level){
        this.Teacher = Teacher;
        this.Career = Career;
        this.Priority_Level = Priority_Level;
    }
    
}
