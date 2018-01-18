package databaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Group;

public class GroupConnector {
    public Boolean insertNewGroup(Connection conn, Group g) throws ClassNotFoundException{
        boolean state = false;
        try{
        Class.forName("com.mysql.jdbc.Driver");

        String sql = "INSERT INTO Groups(Capacity, CourseId, ProfessorId, Period, GroupNumber) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, g.getCapacity());
        statement.setInt(2, g.getCourseId());
        statement.setInt(3, g.getTeacher());
        statement.setInt(4, g.getPeriod());
        statement.setInt(5, g.getNumber());
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new Group was inserted successfully!");
            state = true;
        }

        } catch(SQLException ex) {
         ex.printStackTrace();
        }
        return state;
    }
    
    public ResultSet getGroupbyId(Connection conn, int id) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Groups where GroupId = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    
        public ResultSet getGroupCapacity(Connection conn) throws ClassNotFoundException{
            ResultSet rs = null;
            try{    
                Class.forName("com.mysql.jdbc.Driver");
                PreparedStatement stmt = conn.prepareStatement("SELECT Capacity, GroupId FROM Groups");
                rs = stmt.executeQuery();

            } catch (SQLException e){
                e.printStackTrace();
            }
            return rs;
        }
}
