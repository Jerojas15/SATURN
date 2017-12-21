/*
 * SATURN 2017
 * Autors: blah blah
 */

package model;

public class Course implements Entity {
    int Code;
    String Name;
    String Semester;
    String Career;
    String Plan;

    public int getCode() {
        return Code;
    }
    public String getName() {
        return Name;
    }
    public String getSemester() {
        return Semester;
    }
    public String getCareer() {
        return Career;
    }
    public String getPlan() {
        return Plan;
    }



    public void setCode(int Code){
        this.Code = Code;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setSemester(String Semester){
        this.Semester = Semester;
    }
    public void setCareer(String Career){
        this.Career = Career;
    }
    public void setPlan(String Plan){
        this.Plan = Plan;
    }


    public Course() {
    }
    public Course(int Code, String Name, String Semester, String Career, String Plan) {
        this.Code = Code;
        this.Name = Name;
        this.Semester = Semester;
        this.Career = Career;
        this.Plan = Plan;
    }
}
