/*
 * SATURN 2017
 * Autors: blah blah
 */

package model;

public class Career implements Entity {
    String University;
    String Career;
    String Plan;
    
    public String getUniversity() {
		return University;
	}
    public String getCareer() {
		return Career;
	}
	public String getPlan() {
		return Plan;
	}
	
	
	
	public void setUniversity(String University) {
		this.University = University;
	}
	public void setCareer(String Career) {
		this.Career = Career;
	}
	public void setPlan(String Plan) {
		this.Plan = Plan;
	}
	
	public Career() {
	}
	public Career(String University, String Career, String Plan) {
		this.University = University;
		this.Career = Career;
		this.Plan = Plan;
	}
}
