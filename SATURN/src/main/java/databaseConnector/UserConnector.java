package databaseConnector;

import model.User;
import java.sql.*;

public class UserConnector {
    public ResultSet checkLogin(Connection conn) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT UserName, Password, UserType FROM Users");
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public Boolean insertNewUser(Connection conn, User u) throws ClassNotFoundException{
        boolean state = false;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        	
        String sql = "INSERT INTO Users(UserType, UserName, Password, Name, LastName, CareerId) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, u.getType());
        statement.setString(2, u.getUserName());
        statement.setString(3, u.getPassword());
        statement.setString(4, u.getName());
        statement.setString(5, u.getLastName());
        statement.setInt(6, u.getCareerId());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new User was inserted successfully!");
            state = true;
        }

        } catch(SQLException ex) {
         ex.printStackTrace();
        }
        return state;
    }
    
    public ResultSet getUserbyId(Connection conn, int id) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT UserName,Name,UserType,LastName FROM Users Where UserId = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getAllUsers(Connection conn) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT UserId,Name,UserType,LastName FROM Users");
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getUserbyType(Connection conn, int Type, int career) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT UserId,Name,UserType,LastName,UserName FROM Users Where UserType = ? and CareerId = ?");
            stmt.setInt(1, Type);
            stmt.setInt(2,career);
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getUserbyCareerId(Connection conn, int careerId) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT UserId,Name,UserType,LastName"
                                                            + "FROM Users"
                                                            + "Where careerId = ?");
            stmt.setInt(1, careerId);

            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getUserbyUniversity(Connection conn, String university) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT UserId,Name,UserType,LastName"
                                                            + "FROM Users natural join Careers "
                                                            + "Where University = ?");
            stmt.setString(1, university);
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public Boolean updateUser(Connection conn, User u, int id) throws ClassNotFoundException{
        boolean state =  false;
        int cont = 1, contName, contLast, contUser, contPass, contId;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "UPDATE Users SET";
            if(u.getName()!=null)sql.concat(" Name = ?");contName = cont++;
            if(u.getLastName()!=null)sql.concat(" LastName = ?");contLast = cont++;
            if(u.getUserName()!=null)sql.concat(" UserName = ?");contUser = cont++;
            if(u.getPassword()!=null)sql.concat(" Password = ?");contPass = cont++;
            sql.concat(" WHERE UserId = ?");contId = cont++;
            PreparedStatement statement = conn.prepareStatement(sql);
            if(u.getName()!=null)statement.setString(contName, u.getName());
            if(u.getLastName()!=null)statement.setString(contLast, u.getLastName());
            if(u.getUserName()!=null)statement.setString(contUser, u.getUserName());
            if(u.getPassword()!=null)statement.setString(contPass, u.getPassword());
                statement.setInt(contId, id);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("User was updated!");
                    state = true;
                }

        } catch(SQLException ex) {
           ex.printStackTrace();
        }
        return state;
    }
    public boolean deleteUser(Connection conn, int id) throws ClassNotFoundException{
        boolean state = false;
            try{
                Class.forName("com.mysql.jdbc.Driver");

                String sql = "delete From Users WHERE UserId = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, id);
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Users was deleted!");
                    state = true;
                }

            } catch(SQLException ex) {
               ex.printStackTrace();
            }
           return state;
    }
}
  