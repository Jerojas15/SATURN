package controller;

import databaseConnector.AvailabilityConnector;
import databaseConnector.CareerConnector;
import databaseConnector.ClassRoomConnector;
import databaseConnector.CourseConnector;
import databaseConnector.GroupConnector;
import databaseConnector.PlanConnector;
import databaseConnector.SessionConnector;
import databaseConnector.UserConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.util.Pair;
import model.Availability;
import model.Career;
import model.Classroom;
import model.Course;
import model.Group;
import model.LogIn;
import model.Session;
import model.User;

public class DatabaseController {
        private Connection conn;
        
/*
 * FUNCIONES DE BD
 */
        public DatabaseController() throws SQLException, ClassNotFoundException{
            conn = makeConnection();

        }

        public Connection makeConnection() throws SQLException, ClassNotFoundException{
            //manera de acceso a la base de Julio
            Class.forName("com.mysql.jdbc.Driver");
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SaturnDB", "root", "admin");

            //manera de acceso a la base de Jose Miguel
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SaturnDB", "root", "root");
            return conn;
        }
        
        public Career getCareerById(int id) throws SQLException, ClassNotFoundException{
            CareerConnector c = new CareerConnector();
            ResultSet rs = c.getCareerById(conn, id);
            Career ca = new Career();
            while(rs.next()){
                ca.setCareerName(rs.getString("CareerName"));
                ca.setUniversity(rs.getString("University"));
            }
            return ca;
        }
        
        public int getCareerId(int id) throws ClassNotFoundException, SQLException{
            int status = -1;
            UserConnector connector = new UserConnector();
            ResultSet list = connector.getCareerId(conn, id);
            while(list.next()){
                status = list.getInt("CareerId");
            }
            return status;
        }
        
        public int login(LogIn l) throws ClassNotFoundException, SQLException{
            int status = -1;
            UserConnector connector = new UserConnector();
            ResultSet list = connector.checkLogin(conn);
            while(list.next()){
                if(l.getEmail().equals(list.getString("UserName"))&&l.getPassword().equals(list.getString("Password"))){
                    status = Integer.parseInt(list.getString("UserType"));
                }
            }
            return status;
        }
        
/*
 * FUNCIONES DE CARRERA
 */
        public Boolean insertNewCareer(Career c) throws ClassNotFoundException{
            CareerConnector connector = new CareerConnector();
            Boolean status = connector.insertNewCareer(conn, c);
            return status;
        }

        public boolean deleteCareer(int id) throws ClassNotFoundException{
            CareerConnector connector = new CareerConnector();
            Boolean status = connector.deleteCareer(conn, id);
            return status;
        }
        
        //public boolean updateCareer(Career c, String Career, String Plan) throws ClassNotFoundException{
        public boolean updateCareer(Career c, int id) throws ClassNotFoundException{
            CareerConnector connector = new CareerConnector();
            Boolean status = connector.updateCareer(conn, c, id);
            return status;
        }
        
        public ArrayList<Career> getCareers() throws ClassNotFoundException, SQLException{
            CareerConnector connector = new CareerConnector();
            ArrayList<Career> list = new ArrayList<>();
            ResultSet rs = connector.getAllCareers(conn);
            while(rs.next()){
                Career c = new Career();
                c.setUniversity(rs.getString("University"));
                c.setCareerName(rs.getString("CareerName"));
                c.setCareerId(rs.getInt("CareerId"));
                c.setPlan(connector.getPlanName(conn, c));

                list.add(c); 
            }
            return list;
        }      

/*
 * FUNCIONES DE USUARIO
 */
        public Boolean insertNewUser(User u) throws ClassNotFoundException{
            UserConnector connector = new UserConnector();
            Boolean status = connector.insertNewUser(conn, u);
            return status;
        }

        public boolean deleteUser(int id) throws ClassNotFoundException{
            UserConnector connector = new UserConnector();
            Boolean status = connector.deleteUser(conn, id);
            return status;
        }

        public boolean updateUser(User u, int id) throws ClassNotFoundException{
            UserConnector connector = new UserConnector();
            Boolean status = connector.updateUser(conn, u, id);
            return status;
        }
        
        public ArrayList<User> getUserbyType(int Type, int career) throws SQLException, ClassNotFoundException{
            UserConnector connector = new UserConnector();
            ArrayList<User> list = new ArrayList<>();
            ResultSet rs = connector.getUserbyType(conn, Type, career);

            while(rs.next()){
                User u = new User();
                u.setLastName(rs.getString("LastName"));
                u.setName(rs.getString("Name"));
                u.setType(rs.getInt("UserType"));
                u.setUserName(rs.getString("UserName"));
                u.setCareerId(rs.getInt("CareerId"));
                u.setUserId(rs.getInt("UserId"));
                list.add(u); 
            }
            return list;
        }

        public ArrayList<User> getUser() throws SQLException, ClassNotFoundException{
            UserConnector connector = new UserConnector();
            ArrayList<User> list = new ArrayList<>();
            ResultSet rs = connector.getAllUsers(conn);

            while(rs.next()){
                User u = new User();
                u.setLastName(rs.getString("LastName"));
                u.setName(rs.getString("Name"));
                u.setType(rs.getInt("UserType"));
                u.setCareerId(rs.getInt("CareerId"));
                list.add(u); 
            }
            return list;
        }
        
        public int getUserId(String userName) throws SQLException, ClassNotFoundException{
            UserConnector connector = new UserConnector();
            ResultSet rs = connector.getUserbyUserName(conn, userName);
            int result = 0;
            while(rs.next()){
                result = rs.getInt("UserId");
            }
            return result;
        }

/*
 * FUNCIONES DE CURSO
 */
        public Boolean insertNewCourse(Course c) throws ClassNotFoundException{
            CourseConnector connector = new CourseConnector();
            Boolean status = connector.insertNewCourse(conn, c);
            return status;
        }

        public boolean deleteCourse(int id) throws ClassNotFoundException{
            CourseConnector connector = new CourseConnector();
            Boolean status = connector.deleteCourse(conn, id);
            return status;
        }

        public boolean updateCourse(Course c, int id) throws ClassNotFoundException{
            CourseConnector connector = new CourseConnector();
            Boolean status = connector.updateCourse(conn, c, id);
            return status;
        }
        
        public ArrayList<Course> getCourses(int id) throws ClassNotFoundException, SQLException{
            CourseConnector connector = new CourseConnector();
            ResultSet rs = connector.getCourses(conn, id);
            ArrayList<Course> result = new ArrayList<>();
            while(rs.next()){
                Course a = new Course();
                a.setCode(rs.getString("CourseCode"));
                a.setName(rs.getString("CourseName"));
                a.setSemester(rs.getInt("Semester"));
                a.setCourseId(rs.getInt("CourseId"));
                result.add(a);
            }
            return result;
        }
        
        public ArrayList<Course> getCourse(int id) throws ClassNotFoundException, SQLException{
            CourseConnector connector = new CourseConnector();
            ResultSet rs = connector.getCoursebyId(conn, id);
            ArrayList<Course> result = new ArrayList<>();
            while(rs.next()){
                Course a = new Course();
                a.setCode(rs.getString("CourseCode"));
                a.setName(rs.getString("CourseName"));
                a.setSemester(rs.getInt("Semester"));
                a.setCourseId(rs.getInt("CourseId"));
                result.add(a);
            }
            return result;
        }
        
/*
 * FUNCIONES DE DISPONIBILIDAD
 */
        public ArrayList<Availability> getTeacherAvailability(int id) throws ClassNotFoundException, SQLException{
            AvailabilityConnector connector = new AvailabilityConnector();
            ResultSet rs = connector.getAvailabilitybyProfessor(conn, id);
            ArrayList<Availability> result = new ArrayList<>();
            while(rs.next()){
                Availability a = new Availability();
                a.setDay(rs.getInt("Day"));
                a.setStartHour(rs.getInt("StartHour"));
                a.setEndHour(rs.getInt("EndHour"));
                result.add(a);
            }
            return result;
        }
        
        public boolean insertAvailability(int id, ArrayList<Availability> a) throws ClassNotFoundException{
            boolean status = false;
            AvailabilityConnector connector = new AvailabilityConnector();
            for(int i = 0;i<a.size();i++){
                Availability av = new Availability();
                av.setDay(a.get(i).getDay());
                av.setEndHour(a.get(i).getEndHour());
                av.setStartHour(a.get(i).getStartHour());
                av.setTeacher(id);
                if(connector.insertNewAvailability(conn, av)){
                    status = true;
                }else{
                    return false;
                }
            }
            
            return status;
        }

    public boolean updatePlan(String plan, int id) throws ClassNotFoundException {
        PlanConnector c = new PlanConnector();
        boolean result = c.updatePlan(conn, plan, id);
        return result;
    }

/*
 * FUNCIONES DE AULA
 */
        public ArrayList<Integer> getClassroomCapacity() throws ClassNotFoundException, SQLException{
            ClassRoomConnector connector = new ClassRoomConnector();
            ResultSet rs = connector.getClassroomCapacity(conn);
            ArrayList<Integer> result = new ArrayList<>();
            while(rs.next()){
                result.add(new Integer(rs.getInt("Capacity")));
            }
            return result;
        }
        
/*
 * FUNCIONES DE GRUPO
 */
        public ArrayList<Pair<Integer,Integer>> getGroupCapacity() throws ClassNotFoundException, SQLException{
            GroupConnector connector = new GroupConnector();
            ResultSet rs = connector.getGroupCapacity(conn);
            ArrayList<Pair<Integer,Integer>> result = new ArrayList<>();
            while(rs.next()){
                result.add(new Pair(new Integer(rs.getInt("Capacity")),rs.getInt("GroupId")));
            }
            return result;
        }
        
/*
 * FUNCIONES DE SESIÓN
 */
        public ArrayList<Session> getSessions() throws ClassNotFoundException, SQLException{
            SessionConnector connector = new SessionConnector();
            ResultSet rs = connector.getSessions(conn);
            ArrayList<Session> result = new ArrayList<>();
            while(rs.next()){
                Session a = new Session();
                a.setGroup_ID(rs.getInt("GroupId"));
                a.setHours(rs.getInt("Hour"));
                a.setClassroom_Type(rs.getString("Type"));
                result.add(a);
            }
            return result;
        }

        ArrayList<Pair<Integer, Pair<Integer, Pair<Integer, Integer>>>> getSessionData() throws ClassNotFoundException, SQLException {
            ArrayList<Pair<Integer,Pair<Integer,Pair<Integer, Integer>>>> sessions = new ArrayList<>();
            SessionConnector connector = new SessionConnector();
            UserConnector userConnector = new UserConnector();
            ResultSet result = connector.getSessions(conn);
            while(result.next()){
                sessions.add(new Pair(result.getInt("SessionId"), new Pair(result.getInt("Hour"), new Pair(result.getInt("GroupId"), userConnector.getUserByGroup(conn, result.getInt("GroupId"))))));
            }
            return sessions;
        }

        ArrayList<Pair<Integer, Pair<Integer, Pair<Integer, Integer>>>> getProfessorData() throws ClassNotFoundException, SQLException {
            ArrayList<Pair<Integer,Pair<Integer,Pair<Integer,Integer>>>> professor = new ArrayList<>();
            AvailabilityConnector connector = new AvailabilityConnector();
            ResultSet rs = connector.getAvailability(conn);
            while(rs.next()){
                professor.add(new Pair(rs.getInt("ProfessorId"),new Pair(rs.getInt("Day"),new Pair((rs.getInt("StartHour")-7)*2, (rs.getInt("EndHour")-7)*2))));
            }
            return professor;
        }
}
