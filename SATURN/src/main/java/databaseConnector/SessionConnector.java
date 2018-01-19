package databaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Session;

public class SessionConnector {
    public Boolean insertSession(Connection conn, Session s) throws ClassNotFoundException{
        boolean state = false;
        try{
        Class.forName("com.mysql.jdbc.Driver");

        String sql = "INSERT INTO Sessions(GroupId, Hour, Type) VALUES (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, s.getGroup_ID());
        statement.setInt(2, s.getHours());
        statement.setString(3, s.getClassroom_Type());


        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new Session was inserted successfully!");
            state = true;
        }

        } catch(SQLException ex) {
         ex.printStackTrace();
        }
        return state;
    }
    public ResultSet getSessionbyId(Connection conn) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sessions");
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet getSessionbyType(Connection conn, String Type) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sessions where Type = ?");
            stmt.setString(1, Type);
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getSessions(Connection conn) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sessions");
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    public int getGroupBySession(Connection conn, int activeSession) throws ClassNotFoundException {
        ResultSet rs = null;
        int group = 0;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT GroupId FROM Sessions where SessionId = ?");
            stmt.setInt(1, activeSession);
            rs = stmt.executeQuery();
            while(rs.next()){
                group = rs.getInt("GroupId");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return group;
    }
    public boolean deleteSession(Connection conn, int id) throws ClassNotFoundException{
        boolean state = false;
            try{
                Class.forName("com.mysql.jdbc.Driver");

                String sql = "delete From Sessions WHERE GroupId = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, id);
                       
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Session was deleted!");
                    state = true;
                }

            } catch(SQLException ex) {
               ex.printStackTrace();
            }
           return state;
    }

    public ResultSet getSessionbyId(Connection conn, int id) throws ClassNotFoundException {
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sessions where GroupId = ?");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
}
