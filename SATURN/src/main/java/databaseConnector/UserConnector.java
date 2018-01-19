package databaseConnector;

import model.User;
import java.sql.*;

public class UserConnector {
    
    public ResultSet getCareerId(Connection conn, int id) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT CareerId FROM Users where UserId = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
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
    
    public ResultSet getUserbyUserName(Connection conn, String userName) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT USerId FROM Users Where UserName = ?");
            stmt.setString(1, userName);
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
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
            PreparedStatement stmt = conn.prepareStatement("SELECT UserId,Name,UserType,LastName,UserName, CareerId FROM Users Where UserType = ? and CareerId = ?");
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
        int cont = 1;
        boolean first = true;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "UPDATE Users SET";
            if(u.getName()!=null)sql = sql.concat(" Name = ?");first = false;
            if(u.getLastName()!=null)if(!first)sql = sql.concat(",");else first = false; sql = sql.concat(" LastName = ?");
            if(u.getUserName()!=null)if(!first)sql = sql.concat(",");else first = false; sql = sql.concat(" UserName = ?");
            if(u.getPassword()!=null)if(!first)sql = sql.concat(",");else first = false; sql = sql.concat(" Password = ?");
            sql = sql.concat(" WHERE UserId = ?");
            
            PreparedStatement statement = conn.prepareStatement(sql);
            if(u.getName()!=null)statement.setString(cont++, u.getName());
            if(u.getLastName()!=null)statement.setString(cont++, u.getLastName());
            if(u.getUserName()!=null)statement.setString(cont++, u.getUserName());
            if(u.getPassword()!=null)statement.setString(cont++, u.getPassword());
                statement.setInt(cont++, id);
                System.out.println(statement.toString());
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

    public int getUserByGroup(Connection conn, int id) throws ClassNotFoundException {
        ResultSet rs = null;
        int result = 0;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT ProfessorId from Groups where GroupId = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while(rs.next()){
                result = rs.getInt("ProfessorId");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

}
  