package databaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Plan;

public class PlanConnector {
    
        public boolean insertNewPlan(Connection conn, Plan p) throws ClassNotFoundException{
        boolean state = false;
        try{
        Class.forName("com.mysql.jdbc.Driver");

        String sql = "INSERT INTO Plans(PlanId, PlanName) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, p.getPlanId());
        statement.setString(2, p.getPlanName());
        
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
    
    public ResultSet getPlan(Connection conn) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Plans");
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public boolean updatePlan(Connection conn, Plan p) throws ClassNotFoundException{
        boolean state =  false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "UPDATE Plans SET PlanId = ?, PlanName = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, p.getPlanId());
            statement.setString(2, p.getPlanName());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Plan was updated!");
                state = true;
            }

        } catch(SQLException ex) {
           ex.printStackTrace();
        }
        return state;
    }
    
    public boolean deletePlan(Connection conn, Plan p) throws ClassNotFoundException{
        boolean state = false;
            try{
                Class.forName("com.mysql.jdbc.Driver");

                String sql = "delete FROM Plans WHERE PlanId = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, p.getPlanId());
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Plan was deleted!");
                    state = true;
                }

            } catch(SQLException ex) {
               ex.printStackTrace();
            }
           return state;
    }
}
