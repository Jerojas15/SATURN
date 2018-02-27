package databaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Classroom;
import model.ClassroomType;

public class ClassroomConnector {
    
    public ResultSet getClassrooms(Connection conn) throws ClassNotFoundException {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement( "SELECT Classrooms.ClassroomId, Classrooms.Name, Classrooms.Capacity, ClassroomsTypes.ClassroomType, ClassroomsTypes.Name as ClassroomTypeName " +
                                                            "FROM Classrooms, ClassroomsTypes " +
                                                            "WHERE Classrooms.ClassroomType = ClassroomsTypes.ClassroomType;");
            rs = stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getClassroom(Connection conn, int id) throws ClassNotFoundException {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement( "SELECT ClassroomId, Classrooms.Name, Capacity, ClassroomsTypes.ClassroomType, ClassroomsTypes.Name as ClassroomTypeName " +
                                                            "FROM Classrooms, ClassroomsTypes " +
                                                            "WHERE Classrooms.ClassroomType = ClassroomsTypes.ClassroomType and ClassroomId = ?;");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public Boolean insertNewClassroom(Connection conn, Classroom c) throws ClassNotFoundException {
        boolean state = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            PreparedStatement statement = conn.prepareStatement("INSERT INTO Classrooms (Name, Capacity, ClassroomType) VALUES (?, ?, ?);");
            statement.setString(1, c.getName());
            statement.setInt(2, c.getCapacity());
            statement.setInt(3, c.getClassroomType());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Classroom was created successfully!");
                state = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return state;
    }
    
    public Boolean updateClassroom(Connection conn, int id, Classroom classroom) throws ClassNotFoundException {
        boolean state = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "UPDATE Classrooms SET Name = ?, Capacity = ?, ClassroomType = ? WHERE ClassroomId = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, classroom.getName());
            statement.setInt(2, classroom.getCapacity());
            statement.setInt(3, classroom.getClassroomType());
            statement.setInt(4, id);
            
            System.out.println(statement.toString());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Classroom was updated successfully!");
                state = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return state;
    }

    public Boolean deleteClassroom(Connection conn, int id) throws ClassNotFoundException {
        boolean state = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "DELETE FROM Classrooms WHERE ClassroomId = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Classroom was deleted successfully!");
                state = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return state;
    }

    public ResultSet getClassroombyType(Connection conn, int Type) throws ClassNotFoundException {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Classrooms where ClassroomType = ?");
            stmt.setInt(1, Type);
            rs = stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getClassroomCapacity(Connection conn) throws ClassNotFoundException {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT Capacity FROM Classrooms");
            rs = stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getClassroomCapacity(Connection conn, int type) throws ClassNotFoundException{
            ResultSet rs = null;
            try{    
                Class.forName("com.mysql.jdbc.Driver");
                PreparedStatement stmt = conn.prepareStatement("SELECT Capacity FROM Classrooms where ClassroomType = ?");
                stmt.setInt(1, type);
                rs = stmt.executeQuery();

            } catch (SQLException e){
                e.printStackTrace();
            }
            return rs;
        }

    public int getClassroomQuantity(Connection conn, int type) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT MAX(ClassroomId) FROM Classrooms where ClassroomType = ?");
            stmt.setInt(1, type);
            rs = stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (rs.next()) {
            result = rs.getInt("MAX(ClassRoomId)");
        }
        return result;
    }
    
    public ResultSet getClassroomTypes(Connection conn) throws ClassNotFoundException {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ClassroomsTypes");
            rs = stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getClassroomsType(Connection conn) throws ClassNotFoundException {
        ResultSet rs = null;
            try{    
                Class.forName("com.mysql.jdbc.Driver");
                PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT ClassroomType FROM Classrooms");
                rs = stmt.executeQuery();

            } catch (SQLException e){
                e.printStackTrace();
            }
            return rs;
    }
    
    public ResultSet getClassroomType(Connection conn, int id) throws ClassNotFoundException {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ClassroomsTypes WHERE ClassroomsTypes.ClassroomType = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public Boolean insertNewClassroomType(Connection conn, ClassroomType classroomType) throws ClassNotFoundException {
        boolean state = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            PreparedStatement statement = conn.prepareStatement("INSERT INTO ClassroomsTypes (Name, Description) VALUES (?, ?);");
            statement.setString(1, classroomType.getName());
            statement.setString(2, classroomType.getDescription());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new ClassroomType was inserted successfully!");
                state = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return state;
    }

    public Boolean updateClassroomType(Connection conn, int id, ClassroomType classroomType) throws ClassNotFoundException {
        boolean state = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "UPDATE ClassroomsTypes SET Name = ?, Description = ? WHERE ClassroomType = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, classroomType.getName());
            statement.setString(2, classroomType.getDescription());
            statement.setInt(3, id);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("ClassroomType was updated successfully!");
                state = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return state;
    }

    public Boolean deleteClassroomType(Connection conn, int id) throws ClassNotFoundException {
        boolean state = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "DELETE FROM ClassroomsTypes WHERE ClassroomType = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("ClassroomType was deleted successfully!");
                state = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return state;
    }
}
