/*
 * SATURN 2017
 * Autors: blah blah
 */

package model;

public class Classroom implements Entity {
    int ID;
    int Capacity;
    String Type;

    public int getID() {
        return ID;
    }
    public int getCapacity() {
        return Capacity;
    }
    public String getType() {
        return Type;
    }



    public void setId(int ID){
        this.ID = ID;
    }
    public void setCapacity(int Capacity){
        this.Capacity = Capacity;
    }
    public void setType(String Type){
        this.Type = Type;
    }

    public Classroom() {	
    }
    public Classroom(int ID, int Capacity, String Type) {
        this.ID = ID;
        this.Capacity = Capacity;
        this.Type = Type;
    }
	
}
