package model;

import model.Career;

public class User {
	
	private int id;
	private String userName;
	private String name;
	private String lastName;
	private int type;
        private String university;
        private Career career;
	
	public User() {}

	public User(int id, String userName, String name, String lastName, int type, Career career) {
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
		this.type = type;
                this.career = career;
	}
	
	public int getID() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public int getType() {
		return type;
	}
	
        public Career getCareer() {
		return career;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastName(String lastName) {
		this.lastName= lastName;
	}
	public void setType(int type) {
		this.type = type;
	}
        
        public void setCareer(Career career) {
		this.career = career;
	}
}
