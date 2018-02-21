package model;

public class Classroom {
        int id;
        int capacity;
        int type;
        String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String ClassName) {
        this.className = ClassName;
    }
        public Classroom() {}

        public Classroom(String className, int id, int capacity, int type) {
            this.className = className;
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
        
        public int getType() {
            return type;
        }

        public void setId(int ID){
            this.id = ID;
        }
        
        public void setCapacity(int capacity){
            this.capacity = capacity;
        }
        
        public void setType(int type){
            this.type = type;
            switch(type){
                case 1:
                    this.className = "Aula";
                    break;
                case 2:
                    this.className = "Laboratorio";
                    break;
            }
                    
        }	
}
