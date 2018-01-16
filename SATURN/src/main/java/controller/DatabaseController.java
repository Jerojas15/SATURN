package controller;

import databaseConnector.AvailabilityConnector;
import databaseConnector.CareerConnector;
import databaseConnector.CourseConnector;
import databaseConnector.UserConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Availability;
import model.Career;
import model.Course;
import model.LogIn;
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SaturnDB", "root", "admin");

            //manera de acceso a la base de Jose Miguel
            // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SaturnDB", "root", "root");
            return conn;
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

        public boolean deleteCareer(Career c) throws ClassNotFoundException{
            CareerConnector connector = new CareerConnector();
            Boolean status = connector.deleteCareer(conn, c);
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
}