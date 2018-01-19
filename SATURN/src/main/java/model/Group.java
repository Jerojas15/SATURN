package model;

import java.util.List;
import javax.json.Json;
import org.codehaus.jettison.json.JSONObject;

public class Group {
        int capacity;
        int courseId;
        int teacher;
        int period;
        int number;
        String teacherName;
        String courseName;
        int groupId;
        List<Session> sessions;

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
        public Group() {}
        
        public Group(int capacity, int courseId, int teacher, int period, int number) {
            this.capacity = capacity;
            this.courseId = courseId;
            this.teacher = teacher;
            this.period = period;
            this.number = number;
        }       
        
        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }
        
        public String getTeacherName() {
            return teacherName;
        }

        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
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
