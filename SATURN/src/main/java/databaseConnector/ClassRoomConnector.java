package databaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Classroom;

public class ClassRoomConnector {
        public Boolean insertNewClassroom(Connection conn, Classroom c) throws ClassNotFoundException{
            boolean state = false;
            try{
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "INSERT INTO Classrooms(ClassroomId, Capacity, ClassroomType) VALUES (?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, c.getID());
            statement.setInt(2, c.getCapacity());
            statement.setInt(3, c.getType());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Classroom was inserted successfully!");
                state = true;
            }

            } catch(SQLException ex) {
             ex.printStackTrace();
            }
            return state;
        }

        public ResultSet getClassroombyType(Connection conn, String Type) throws ClassNotFoundException{
            ResultSet rs = null;
            try{    
                Class.forName("com.mysql.jdbc.Driver");
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Classrooms where Type = ?");
                stmt.setString(1, Type);
                rs = stmt.executeQuery();

            } catch (SQLException e){
                e.printStackTrace();
            }
            return rs;
        }
    
        public ResultSet getClassroomCapacity(Connection conn) throws ClassNotFoundException{
            ResultSet rs = null;
            try{    
                Class.forName("com.mysql.jdbc.Driver");
                PreparedStatement stmt = conn.prepareStatement("SELECT Capacity FROM Classrooms");
                rs = stmt.executeQuery();

            } catch (SQLException e){
                e.printStackTrace();
            }
            return rs;
        }
}
