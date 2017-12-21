/*
 * SATURN 2017
 * Autors: blah blah
 */

package model;

public class User implements Entity {
	int ID;
	String User;
	Sring Name;
	String Last_Name;
	String Type;
	
	public int getID() {
		return ID;
	}
	public String getUser() {
		return User;
	}
	public String getName() {
		return Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public String getType() {
		return Type;
	}
	
	
	
	public void setID() {
		this.ID = ID;
	}
	public void setUser() {
		this.User = User;
	}
	public void setName() {
		this.Name = Name;
	}
	public void setLast_Name() {
		this.Last_Name = Last_Name;
	}
	public void setType() {
		this.Type = Type;
	}
	
	
	public User() {	
	}
	public User(int ID, String User, Sring Name, String Last_Name, String Type) {
		this.ID = ID;
		this.User = User;
		this.Name = Name;
		this.Last_Name = Last_Name;
		this.Type = Type;
	}
}
