package model;

public class Group {
        int id;
        int capacity;
        int courseId;
        int teacher;
        int period;
        int number;

        public Group(int id, int capacity, int courseId, int teacher, int period, int number) {
            this.id = id;
            this.capacity = capacity;
            this.courseId = courseId;
            this.teacher = teacher;
            this.period = period;
            this.number = number;
        }
        
        public int getID() {
            return id;
        }
        
        public int getCapacity() {
            return capacity;
        }
        
        public int getCourseId() {
            return courseId;
        }
        
        public int getTeacher() {
            return teacher;
        }
        
        public int getPeriod() {
            return period;
        }
        
        public int getNumber() {
            return number;
        }

        public void setID(int id) {
            this.id = id;
        }
        
        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }
        
        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }
        
        public void setTeacher(int Teacher) {
            this.teacher = Teacher;
        }
        
        public void setPeriod(int period) {
            this.period = period;
        }
        
        public void setNumber(int number) {
            this.number = number;
        }

}
