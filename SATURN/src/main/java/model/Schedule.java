package model;

public class Schedule {
        int day;
        int startTime;
        int finishTime;
        int group;
        int classroom;

        public Schedule() {}
        
        public Schedule(int day, int startTime, int finishTime, int group, int classroom) {
            this.day = day;
            this.startTime = startTime;
            this.finishTime = finishTime;
            this.group = group;
            this.classroom = classroom;
        }
        
        public int getDay() {
                return day;
        }

        public int getStart_Time() {
                return startTime;
        }

        public int getFinish_Time() {
                return finishTime;
        }

        public int getGroup() {
                return group;
        }

        public int getClassroom() {
                return classroom;
        }

        public void setDay(int day) {
            this.day = day;
        }
        
        public void setStart_Time(int startTime) {
            this.startTime = startTime;
        }
        
        public void setFinish_Time(int finishTime) {
            this.finishTime = finishTime;
        }
        
        public void setGroup(int group) {
            this.group = group;
        }
        
        public void setClassroom(int classroom) {
            this.classroom = classroom;
        }
}
