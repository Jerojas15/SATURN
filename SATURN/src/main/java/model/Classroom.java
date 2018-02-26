package model;

public class Classroom {
    
    private int classroomId,
                classroomType,
                capacity;
    private String  name,
                    classroomTypeName;

    public int getClassroomId() {
        return classroomId;
    }

    public int getClassroomType() {
        return classroomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public String getClassroomTypeName() {
        return classroomTypeName;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public void setClassroomType(int classroomType) {
        this.classroomType = classroomType;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassroomTypeName(String classroomTypeName) {
        this.classroomTypeName = classroomTypeName;
    }
}
