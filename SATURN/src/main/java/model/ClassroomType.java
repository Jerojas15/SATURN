package model;

public class ClassroomType {
    
    private int classroomTypeId;
    private String  name,
                    description;

    public int getClassroomTypeId() {
        return classroomTypeId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setClassroomTypeId(int classroomTypeId) {
        this.classroomTypeId = classroomTypeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

}
