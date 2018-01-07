package model;

public class Plan {
    
        private int id;
        private String planName;
    
        public Plan () {}   
        
        public Plan (int id, String planName) {
            this.id = id;
            this.planName = planName;
        }
        
        public int getPlanId() {
            return id;
        }
        
        public void setPlanId(int id) {
            this.id = id;
        }
        
        public String getPlanName() {
            return planName;
        }
        
        public void setPlanName(String planName) {
            this.planName = planName;
        }
}
