package model;

public class Course {
        String code;
        String name;
        int semester;
        int careerId;

        public Course(){}
        
        public Course(String code, String name, int semester, int careerId) {
            this.code = code;
            this.name = name;
            this.semester = semester;
            this.careerId = careerId;
        }

        public String getCode() {
            return code;
        }
        
        public String getName() {
            return name;
        }
        
        public int getSemester() {
            return semester;
        }
        
        public int getCareerId() {
            return careerId;
        }

        public void setCode(String code){
            this.code = code;
        }
        
        public void setName(String name){
            this.name = name;
        }
        
        public void setSemester(int semester){
            this.semester = semester;
        }
        
        public void setCareerId(int careerId){
            this.careerId = careerId;
        }
    
}
