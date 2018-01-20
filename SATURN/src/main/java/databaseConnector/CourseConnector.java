package databaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Course;

public class CourseConnector {
    public Boolean insertNewCourse(Connection conn, Course c) throws ClassNotFoundException{
        boolean state = false;
        try{
        Class.forName("com.mysql.jdbc.Driver");

        String sql = "INSERT INTO Courses(CourseCode, CourseName, Semester, CareerId) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, c.getCode());
        statement.setString(2, c.getName());
        statement.setInt(3, c.getSemester());
        statement.setInt(4, c.getCareerId());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new Course was inserted successfully!");
            state = true;
        }

        } catch(SQLException ex) {
         ex.printStackTrace();
        }
        return state;
    }
    
    public boolean updateCourse(Connection conn, Course c, int id) throws ClassNotFoundException{
        boolean state =  false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "UPDATE Courses SET CourseCode = ?, CourseName = ?, Semester = ? where CourseId = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, c.getCode());
            statement.setString(2, c.getName());
            statement.setInt(3, c.getSemester());
            statement.setInt(4, id);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Course was updated!");
                state = true;
            }

        } catch(SQLException ex) {
           ex.printStackTrace();
        }
        return state;
    }
    
    public boolean deleteCourse(Connection conn, int id) throws ClassNotFoundException{
        boolean state = false;
            try{
                Class.forName("com.mysql.jdbc.Driver");

                String sql = "delete FROM Courses WHERE CourseId = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, id);
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Course was deleted!");
                    state = true;
                }

            } catch(SQLException ex) {
               ex.printStackTrace();
            }
           return state;
    }
    
    public ResultSet getCourses(Connection conn, int careerId) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Courses where CareerId = ?");
            stmt.setInt(1, careerId);
            
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(rs);
        return rs;
    }
    
    public ResultSet getCoursebyCareer(Connection conn, int careerId) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Courses where CareerId = ?");
            stmt.setInt(1, careerId);
            
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getCoursebyUniversity(Connection conn, String university) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * "
                                                            + "FROM Courses natural join Careers"
                                                            + "WHERE University = ?");
            stmt.setString(1, university);  
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getCoursebyId(Connection conn, int id) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Courses WHERE CourseId = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    public String getCourseName(Connection conn, int courseId) throws ClassNotFoundException {
        ResultSet rs = null;
        String result = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT CourseName FROM Courses where CourseId = ?");
            stmt.setInt(1, courseId);
            
            rs = stmt.executeQuery();
            while(rs.next()){
                result = rs.getString("CourseName");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
