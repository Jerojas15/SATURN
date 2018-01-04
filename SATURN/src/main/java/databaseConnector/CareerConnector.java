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

        String sql = "INSERT INTO Career(University, CareerName, Plan) VALUES (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, c.getUniversity());
        statement.setString(2, c.getCareer());
        statement.setString(3, c.getPlan());

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
    
    public ResultSet getCareer(Connection conn) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Career");
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public boolean updateCareer(Connection conn, Career c, String Career, String Plan) throws ClassNotFoundException{
        boolean state =  false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "UPDATE Career SET University = ?, CareerName = ?, Plan = ? WHERE CareerName = ? and Plan = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, c.getUniversity());
            statement.setString(2, c.getCareer());
            statement.setString(3, c.getPlan());
            statement.setString(4, Career);
            statement.setString(5, Plan);
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

                String sql = "delete From Career WHERE CareerName = ? and Plan = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, c.getCareer());
                statement.setString(2, c.getPlan());
                
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
