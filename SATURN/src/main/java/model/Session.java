package model;

public class Session {
    
	int groupId;
	int hours;
	String classroomType;
	
        public Session() {}
        
	public Session(int groupId, int hours, String classroomType) {
		this.groupId = groupId;
		this.hours = hours;
		this.classroomType = classroomType;
	}
        
	public int getGroup_ID() {
		return groupId;
	}
	public int getHours() {
		return hours;
	}
	public String getClassroom_Type() {
		return classroomType;
	}
	
	public void setGroup_ID(int groupId) {
		this.groupId = groupId;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public void setClassroom_Type(String classroomType) {
		this.classroomType = classroomType;
	}
}
