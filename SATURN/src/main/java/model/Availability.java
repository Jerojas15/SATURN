package model;

public class Availability {
        int teacher;
        int startTime;
        int finishTime;
        int day;

        public Availability() {}
        
        public Availability(int teacher, int startTime, int finishTime, int day) {
            this.teacher = teacher;
            this.startTime = startTime;
            this.finishTime = finishTime;
            this.day = day;
        }
        
        public int getTeacher() {
            return teacher;
        }
        public int getStart_Time() {
            return startTime;
        }
        public int getFinish_Time() {
            return finishTime;
        }
        public int getDay() {
            return day;
        }

        public void setTeacher(int teacher) {
            this.teacher = teacher;
        }
        public void setStart_Time(int startTime) {
            this.startTime = startTime;
        }
        public void setFinish_Time(int finishTime) {
            this.finishTime = finishTime;
        }
        public void setDay(int day) {
            this.day = day;
        }

}
