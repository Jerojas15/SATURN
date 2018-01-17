package model;

public class Course {
        String code;
        String name;
        int semester;
        int careerId;
        int courseId;
        public Course(){}
        
        public Course(String code, String name, int semester, int careerId, int courseId) {
            this.code = code;
            this.name = name;
            this.semester = semester;
            this.careerId = careerId;
            this.courseId = courseId;
        }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
