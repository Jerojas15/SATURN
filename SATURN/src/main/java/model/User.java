package model;

public class User {

	public static enum TYPE {MANAGER, ASSISTANT, COORDINATOR, TEACHER}

	private int id;
	private String userName;
	private String password;
	private String name;
	private String lastName;
	private int type;
	private int careerId;

	public User() {}

	public User(int id, String userName, String password, String name, String lastName, int type, int careerId) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.type = type;
		this.careerId = careerId;
	}

	public int getId() {
		return id;
	}
        
	public String getUserName() {
		return userName;
	}
        
	public String getPassword() {
		return password;
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

	public int getCareerId() {
		return careerId;
	}

	public void setId(int id) {
		this.id = id;
	}
        
	public void setUserName(String userName) {
		this.userName = userName;
	}
        
	public void setPassword(String password) {
		this.password = password;
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

	public void setCareerId(int careerId) {
		this.careerId = careerId;
	}
}
