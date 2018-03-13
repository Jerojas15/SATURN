package databaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ClassNow;
import model.Schedule;

public class ScheduleConnector {
    public Boolean insertNewSchedule(Connection conn, Schedule s) throws ClassNotFoundException{
        boolean state = false;
        try{
        Class.forName("com.mysql.jdbc.Driver");

        String sql = "INSERT INTO Timetables(Day, StartHour, EndHour, GroupId, ClassroomId, TableVersion, ClassroomType) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, s.getDay());
        statement.setInt(2, s.getStart_Time());
        statement.setInt(3, s.getFinish_Time());
        statement.setInt(4, s.getGroup());
        statement.setInt(5, s.getClassroom());
        statement.setInt(6, s.getVersion());
        statement.setInt(7, s.getType());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new Schedule was inserted successfully!");
            state = true;
        }

        } catch(SQLException ex) {
         ex.printStackTrace();
        }
        return state;
    }
    
    public ResultSet getScheduler(Connection conn) throws ClassNotFoundException{
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Timetables");
            rs = stmt.executeQuery();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    public int getVersion(Connection conn, int type) throws ClassNotFoundException {
         ResultSet rs = null;
         int version = -1;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT TableVersion FROM Timetables where ClassroomType = ?");
            stmt.setInt(1, type);
            rs = stmt.executeQuery();
            while(rs.next()){
                version = rs.getInt("TableVersion");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return version;
    }
    
    //Saca todas las clases de una version del horario
    public ResultSet getClass(Connection conn, int id, int type) throws ClassNotFoundException {
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT distinct CourseName, University, StartHour, EndHour, Day "
                    + "from ((((Timetables inner join Groups using (GroupId)) inner join Courses using(CourseId)) inner join Careers using(CareerId) inner join Users))"
                    + "where TableVersion=? and ClassroomType = ?");
            stmt.setInt(1, id);
            stmt.setInt(2, type);
            rs = stmt.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return rs;
    }

    public ResultSet getClassNow(Connection conn, ClassNow c, int id) throws ClassNotFoundException {
        ResultSet rs = null;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT distinct CourseName, University, StartHour, EndHour "
                    + "from ((((Timetables inner join Groups using (GroupId)) inner join Courses using(CourseId)) inner join Careers using(CareerId) inner join Users))"
                    + " where ProfessorId = UserId and Day = ? and TableVersion=? and ClassroomId = ?");
            stmt.setInt(1, c.getDay());
            stmt.setInt(2, id);
            stmt.setInt(3, c.getClassroom());
            rs = stmt.executeQuery();
           
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    public int getLeftVersion(Connection conn, int type) throws ClassNotFoundException {
        ResultSet rs = null;
        int version = -1;
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT TableVersion FROM LeftSessions where ClassroomType = ?");
            stmt.setInt(1, type);
            rs = stmt.executeQuery();
            while(rs.next()){
                version = rs.getInt("TableVersion");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return version;
    }

    
}
