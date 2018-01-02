/*
 * SATURN 2017
 * Autors: blah blah
 */

package model;

public class Career implements Entity {
	
	private int	id;
	private String university;
	private String career;
	private String plan;
	
	public Career() {}
	
    public Career(int id, String university, String career, String plan) {
    	this.id = id;
        this.university = university;
        this.career = career;
        this.plan = plan;
    }
    
    public int getId() {
    	return id;
    }
    public String getUniversity() {
    	return university;
    }
    public String getCareer() {
        return career;
    }
    public String getPlan() {
        return plan;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    public void setUniversity(String university) {
        this.university = university;
    }
    public void setCareer(String career) {
        this.career = career;
    }
    public void setPlan(String plan) {
        this.plan = plan;
    }
}
