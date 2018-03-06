package model;

public class Session {
    int sessionId;
    int groupId;
    int hours;
    int classroomType;

    public Session() {
    }

    public Session(int groupId, int hours, int classroomType) {
        this.groupId = groupId;
        this.hours = hours;
        this.classroomType = classroomType;
    }
    
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setClassroomType(int classroomType) {
        this.classroomType = classroomType;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getHours() {
        return hours;
    }

    public int getClassroomType() {
        return classroomType;
    }
}
