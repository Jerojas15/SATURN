package databaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Career;
import model.Plan;

public class CareerPlanConnector {
        public boolean insertNewCareerPlan(Connection conn, Career c, Plan p) throws ClassNotFoundException{
        boolean state = false;
        try{
        Class.forName("com.mysql.jdbc.Driver");

        String sql = "INSERT INTO CareersPlans(CareerId, PlanId) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, c.getCareerId());
        statement.setInt(2, p.getPlanId());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new Career-Plan relation was inserted successfully!");
            state = true;
        }

        } catch(SQLException ex) {
         ex.printStackTrace();
        }
        return state;
    }
    
    public boolean deleteCareerPlan(Connection conn, Career c, Plan p) throws ClassNotFoundException{
        boolean state = false;
            try{
                Class.forName("com.mysql.jdbc.Driver");

                String sql = "delete FROM CareersPlans WHERE CareerId = ? AND PlanId = ?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, c.getCareerId());
                statement.setInt(2, p.getPlanId());
                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Career-Plan relation was deleted!");
                    state = true;
                }

            } catch(SQLException ex) {
               ex.printStackTrace();
            }
           return state;
    }
}
