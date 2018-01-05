package databaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Career;

public class CareerConnector {
    public boolean insertNewCareer(Connection conn, Career c) throws ClassNotFoundException{
        boolean state = false;
        try{
        Class.forName("com.mysql.jdbc.Driver");

        String sql = "INSERT INTO Careers(University, CareerName) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, c.getUniversity());
        statement.setString(2, c.getCareerName());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new Career was inserted successfully!");
            state = true;
        }

        } catch(SQLException ex) {
         ex.printStackTrace();
        }
        return state;
    }
    
    public ResultSet getAllCareers(Connection conn) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Careers");
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public boolean updateCareer(Connection conn, Career c) throws ClassNotFoundException{
        boolean state =  false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "UPDATE Careers SET University = ?, CareerName = ? WHERE CareerId = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, c.getUniversity());
            statement.setString(2, c.getCareerName());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Career was updated!");
                state = true;
            }

        } catch(SQLException ex) {
           ex.printStackTrace();
        }
        return state;
    }
    
    public boolean deleteCareer(Connection conn, Career c) throws ClassNotFoundException{
        boolean state = false;
            try{
                Class.forName("com.mysql.jdbc.Driver");

                String sql = "delete FROM Careers WHERE CareerId = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, c.getCareerId());
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Career was deleted!");
                    state = true;
                }

            } catch(SQLException ex) {
               ex.printStackTrace();
            }
           return state;
    }
}
