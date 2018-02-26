package model;

public class Schedule {
        int day;
        int startTime;
        int finishTime;
        int group;
        int classroom;
        int version;
        int type;
        
        public Schedule() {}
        
        public Schedule(int day, int startTime, int finishTime, int group, int classroom, int version, int type) {
            this.day = day;
            this.startTime = startTime;
            this.finishTime = finishTime;
            this.group = group;
            this.classroom = classroom;
            this.version = version;
            this.type = type;
        }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
