package model;

public class User {

	public static enum TYPE {MANAGER, ASSISTANT, COORDINATOR, TEACHER}


	private int id;
	private String userName;
	private String password;
	private String name;
	private String lastName;
	private int type;
	private String careerName;
	private String plan;

	public User() {}

	public User(int id, String userName, String password, String name, String lastName, int type, String careerName) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.type = type;
		this.careerName = careerName;
		this.plan = plan;
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

	public String getCareerName() {
		return careerName;
	}

	public String getPlan() {
		return plan;
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

	public void setCareerName(String careerName) {
		this.careerName = careerName;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}
}
