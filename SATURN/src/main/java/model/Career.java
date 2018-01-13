package model;

public class Career {
	
	private int id;
	private String university;
	private String careerName;
	private String plan;

	public Career() {}
	
        public Career(String plan, String university, String careerName) {
            this.plan = plan;
            this.university = university;
            this.careerName = careerName;
        }

        public int getCareerId() {
            return id;
        }
        public String getUniversity() {
            return university;
        }
        public String getCareerName() {
            return careerName;
        }

        public void setCareerId(int id) {
            this.id = id;
        }
        public void setUniversity(String university) {
            this.university = university;
        }
        public void setCareerName(String careerName) {
            this.careerName = careerName;
        }
        
        public String getPlan() {
            return plan;
        }

        public void setPlan(String plan) {
            this.plan = plan;
        }
}
