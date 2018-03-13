package databaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.Session;

public class SessionConnector {

    public Boolean insertSession(Connection conn, Session s) throws ClassNotFoundException {
        boolean state = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "INSERT INTO Sessions(GroupId, Hour, Type) VALUES (?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, s.getGroupId());
            statement.setInt(2, s.getHours());
            statement.setInt(3, s.getClassroomType());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Session was inserted successfully!");
                state = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return state;
    }

    public ResultSet getSessions(Connection conn) throws ClassNotFoundException {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sessions");
            rs = stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getSessionbyType(Connection conn, String Type) throws ClassNotFoundException {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sessions where Type = ?");
            stmt.setString(1, Type);
            rs = stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int getGroupBySession(Connection conn, int activeSession) throws ClassNotFoundException {
        ResultSet rs = null;
        int group = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT GroupId FROM Sessions where SessionId = ?");
            stmt.setInt(1, activeSession);
            rs = stmt.executeQuery();
            while (rs.next()) {
                group = rs.getInt("GroupId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    public boolean deleteSession(Connection conn, int id) throws ClassNotFoundException {
        boolean state = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "delete From Sessions WHERE GroupId = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Session was deleted!");
                state = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return state;
    }
    
    public boolean deleteSessionbyId(Connection conn, int id) throws ClassNotFoundException {
        boolean state = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "delete From Sessions WHERE SessionId = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Session was deleted!");
                state = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return state;
    }

    public ResultSet getSessionbyId(Connection conn, int id) throws ClassNotFoundException {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sessions where GroupId = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void insertLeftSession(Connection conn, Integer group, int version, int type) throws ClassNotFoundException {
        boolean state = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "INSERT IGNORE INTO LeftSessions(GroupId, TableVersion, ClassRoomType) VALUES (?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, group);
            statement.setInt(2, version);
            statement.setInt(3, type);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Session was inserted successfully!");
                state = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getLeftCourses(Connection conn, int id) throws ClassNotFoundException {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("select CourseName, University from (((LeftSessions join Groups using (GroupId)) join Courses using (CourseId)) join Careers using (CareerId)) where TableVersion = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getTotalGroups(Connection conn) throws ClassNotFoundException {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement stmt = conn.prepareStatement("SELECT GroupId FROM Sessions");
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public Boolean updateSessions(Connection conn, int groupId, List<Session> sessions) throws ClassNotFoundException {

        boolean state = false;
        int sessionId;
        ResultSet rs;
        PreparedStatement statement;
        String sql;
        List<Session> updateSessions;
        List<Session> insertSessions;
        Object[] deleteSessions;
        Set<Integer> dbSessions;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            rs = getSessionbyId(conn, groupId);

            dbSessions = new HashSet<>();
            while (rs.next()) {
                dbSessions.add(rs.getInt("SessionId"));
            }

            updateSessions = new ArrayList<>();
            
            insertSessions = new ArrayList<>();
            for (int i = 0; i < sessions.size(); i++) {
                sessionId = sessions.get(i).getSessionId();

                if (sessionId == 0) {
                    insertSessions.add(sessions.get(i));

                } else if (dbSessions.contains(sessionId)) {
                    updateSessions.add(sessions.get(i));
                    dbSessions.remove(sessionId);
                }
            }

            deleteSessions = dbSessions.toArray();

            for (int i = 0; i < updateSessions.size(); i++) {
                sql = "UPDATE Sessions SET Hour = ?, Type = ? where SessionId = ?";
                statement = conn.prepareStatement(sql);
                statement.setInt(1, updateSessions.get(i).getHours());
                statement.setInt(2, updateSessions.get(i).getClassroomType());
                statement.setInt(3, updateSessions.get(i).getSessionId());

                if (statement.executeUpdate() > 0) {
                    System.out.println("Session was updated!");
                    state = true;
                }
            }
            
            for (int i = 0; i < deleteSessions.length; i++) {
                deleteSessionbyId(conn, (Integer)deleteSessions[i]);
            }
            
            for (int i = 0; i < insertSessions.size(); i++) {
                Session s = insertSessions.get(i);
                s.setGroupId(groupId);
                insertSession(conn, s);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return state;
    }
}
