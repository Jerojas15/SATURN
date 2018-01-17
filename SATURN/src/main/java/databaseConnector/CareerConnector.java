package databaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Career;

public class CareerConnector {
    public String getPlanName(Connection conn, Career c) throws ClassNotFoundException, SQLException{
        ResultSet rs = null;
        String result = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT PlanName FROM Plans where PlanId = (SELECT PlanId FROM CareersPlans WHERE CareerId = (SELECT CareerId FROM Careers where CareerName = ? and University = ?))");
            stmt.setString(1, c.getCareerName());
            stmt.setString(2, c.getUniversity());

            rs = stmt.executeQuery();
            while(rs.next()){
                result = rs.getString("PlanName");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public ResultSet getAllPlans(Connection conn) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM CareersPlans");
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
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
            sql = "Insert INTO Plans(PlanName) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getPlan());
            rowsInserted = stmt.executeUpdate();
            if(rowsInserted>0){
                System.out.println("A new Plan was inserted successfully!");
            
                sql = "Insert INTO CareersPlans(CareerId, PlanId) VALUES (?,?)";
                PreparedStatement stmt2 = conn.prepareStatement(sql);
                stmt2.setInt(1, getCareerId(conn,c));
                stmt2.setInt(2, getPlanId(conn,c));
                rowsInserted = stmt2.executeUpdate();
                if(rowsInserted>0){
                    System.out.println("A new Plan was linked successfully!");
            
                }
            }
            state = true;
        }

        } catch(SQLException ex) {
         ex.printStackTrace();
        }
        return state;
    }
    
    private int getCareerId(Connection conn,Career c) throws ClassNotFoundException{
        ResultSet rs = null;
        int id = -1;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT CareerId FROM Careers WHERE CareerName = ? and University = ?");
            stmt.setString(1, c.getCareerName());
            stmt.setString(2, c.getUniversity());
            rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("CareerId");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }
    
    private int getPlanId(Connection conn,Career c) throws ClassNotFoundException{
        ResultSet rs = null;
        int id = -1;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT PlanId FROM Plans WHERE PlanName = ?");
            stmt.setString(1, c.getPlan());
            rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("PlanId");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return id;
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
    
     /*
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

        */
    
    public boolean updateCareer(Connection conn, Career c, int id) throws ClassNotFoundException{
        boolean state =  false;
        int cont = 1, contUni, contName, contId;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "UPDATE Careers SET University = ? CareerName = ? WHERE CareerId = ?";
            if(c.getUniversity()!=null)sql.concat(" ");contUni = cont++;
            if(c.getCareerName()!=null)sql.concat(" ");contName = cont++;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, c.getUniversity());
            statement.setString(2, c.getCareerName());
            statement.setInt(3, id);
        
      

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
