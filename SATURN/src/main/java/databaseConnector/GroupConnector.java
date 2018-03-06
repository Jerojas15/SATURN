package databaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Group;

public class GroupConnector {
    public int getGroupId(Connection conn) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        ResultSet rs;
        String sql2 = "SELECT GroupId from Groups ORDER BY GroupId DESC LIMIT 1";
        PreparedStatement stmt = conn.prepareStatement(sql2);
        rs = stmt.executeQuery();
        int id = 0;
        while(rs.next()){
            id = rs.getInt("GroupId");
        }
        return id;
    }
    
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
   
    public boolean updateGroup(Connection conn, Group g, int id) throws ClassNotFoundException{
        
        boolean state =  false;
        int cont = 1;
        boolean first = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            String sql = "UPDATE Groups SET ";
            if(g.getCapacity() != 0){
                sql += " Capacity = ?";
                first = true;
            }
            if(g.getCourseId() != 0){
                if(first)
                    sql += ",";
                sql += " CourseId = ?";
                first = true;
            }
            if(g.getTeacher() != 0){
                if(first)
                    sql += ","; 
                sql += " ProfessorId = ?";
                first = true;
            }
            if(g.getPeriod() != 0){
                if(first)
                    sql += ","; 
                sql += " Period = ?";
                first = true;
            }
            if(g.getNumber() != 0){
                if(first)
                    sql += ","; 
                sql += " GroupNumber = ?";
            }
            sql += "  WHERE GroupId = ?;";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            
            if(g.getCapacity() != 0){
                statement.setInt(cont++, g.getCapacity());
            }
            if(g.getCourseId() != 0){
                statement.setInt(cont++, g.getCourseId());
            }
            if(g.getTeacher() != 0){
                statement.setInt(cont++, g.getTeacher());
            }
            if(g.getPeriod() != 0){
                statement.setInt(cont++, g.getPeriod());
            }
            if(g.getNumber() != 0){
                statement.setInt(cont++, g.getNumber());
            }
            
            statement.setInt(cont++, id);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(statement.toString());
            System.out.println();
            System.out.println();
            System.out.println();
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Group was updated!");
                state = true;
            }

        } catch(SQLException ex) {
           ex.printStackTrace();
        }
        return state;
    }
    public boolean deleteGroup(Connection conn, int id) throws ClassNotFoundException{
        boolean state = false;
            try{
                Class.forName("com.mysql.jdbc.Driver");

                String sql = "delete From Groups WHERE GroupId = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, id);
                       
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Group was deleted!");
                    state = true;
                }

            } catch(SQLException ex) {
               ex.printStackTrace();
            }
           return state;
    }
    
    public ResultSet getGroups(Connection conn) throws ClassNotFoundException{
            ResultSet rs = null;
            try{    
                Class.forName("com.mysql.jdbc.Driver");
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Groups");
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
        public ResultSet getGroups(Connection conn, int id) throws ClassNotFoundException {
            ResultSet rs = null;
            try{    
                Class.forName("com.mysql.jdbc.Driver");
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Groups inner join Courses using (CourseId) where CareerId = ?");
                stmt.setInt(1,id);
                rs = stmt.executeQuery();

            } catch (SQLException e){
                e.printStackTrace();
            }
            return rs;
        }

    public int getLastGroupId(Connection conn) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        int result = 0;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT MAX(GroupId) FROM Groups");
            rs = stmt.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
        while(rs.next()){
            result = rs.getInt("MAX(GroupId)");
        }
        return result;
    }
}
