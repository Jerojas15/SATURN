package model;

public class Classroom {
        int id;
        int capacity;
        String type;

        public Classroom() {}

        public Classroom(int id, int capacity, String type) {
            this.id = id;
            this.capacity = capacity;
            this.type = type;
        }

        public int getID() {
            return id;
        }
        
        public int getCapacity() {
            return capacity;
        }
        
        public String getType() {
            return type;
        }

        public void setId(int ID){
            this.id = ID;
        }
        
        public void setCapacity(int capacity){
            this.capacity = capacity;
        }
        
        public void setType(String type){
            this.type = type;
        }	
}
