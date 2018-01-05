package model;

public class Course {
        int code;
        String name;
        int semester;
        int careerId;

        public Course(int code, String name, int semester, int careerId) {
            this.code = code;
            this.name = name;
            this.semester = semester;
            this.careerId = careerId;
        }

        public int getCode() {
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

        public void setCode(int code){
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
