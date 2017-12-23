/*
 * SATURN 2017
 * Autors: blah blah
 */

package model;

public class User implements Entity {
	int ID;
	String User;
	String Name;
	String Last_Name;
	int Type;
	
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
	public int getType() {
		return Type;
	}
	
	
	
	public void setID(int ID) {
		this.ID = ID;
	}
	public void setUser(String User) {
		this.User = User;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public void setLast_Name(String Last_Name) {
		this.Last_Name = Last_Name;
	}
	public void setType(int Type) {
		this.Type = Type;
	}
	
	
	public User() {	
	}
	public User(int ID, String User, String Name, String Last_Name, int Type) {
		this.ID = ID;
		this.User = User;
		this.Name = Name;
		this.Last_Name = Last_Name;
		this.Type = Type;
	}
}
