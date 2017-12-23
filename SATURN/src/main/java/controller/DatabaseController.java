/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import databaseConnector.CareerConnector;
import databaseConnector.UserConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Career;
import model.User;

/**
 *
 * @author julio
 */
public class DatabaseController {
    private Connection conn;
    public DatabaseController() throws SQLException{
        conn = makeConnection();
    }
    
    public Connection makeConnection() throws SQLException{
        //manera de acceso a la base de Julio
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SaturnDB", "root", "admin"); 
        return conn;
    }
    
    public Boolean insertNewCareer(Career c) throws ClassNotFoundException{
        CareerConnector connector = new CareerConnector();
        Boolean status = connector.insertNewCareer(conn, c);
        return status;
    }
    
    public ArrayList<Career> getCareers() throws ClassNotFoundException, SQLException{
        CareerConnector connector = new CareerConnector();
        ArrayList<Career> list = new ArrayList<>();
        ResultSet rs = connector.getCareer(conn);
        
        while(rs.next()){
            Career c = new Career();
            c.setUniversity(rs.getString("University"));
            c.setCareer(rs.getString("CareerName"));
            c.setPlan(rs.getString("Plan"));

            list.add(c); 
        }
        return list;
    }
    
    public Boolean insertNewUser(User u) throws ClassNotFoundException{
        UserConnector connector = new UserConnector();
        Boolean status = connector.insertNewUser(conn, u);
        return status;
    }
    
    
    public ArrayList<User> getUserbyType(int Type) throws SQLException, ClassNotFoundException{
        UserConnector connector = new UserConnector();
        ArrayList<User> list = new ArrayList<>();
        ResultSet rs = connector.getUserbyType(conn, Type);
        
        while(rs.next()){
            User u = new User();
            u.setLast_Name(rs.getString("LastName"));
            u.setName(rs.getString("Name"));
            u.setType(rs.getInt("UserType"));
            list.add(u); 
        }
        return list;
    }
    
    public ArrayList<User> getUser() throws SQLException, ClassNotFoundException{
        UserConnector connector = new UserConnector();
        ArrayList<User> list = new ArrayList<>();
        ResultSet rs = connector.getUser(conn);
        
        while(rs.next()){
            User u = new User();
            u.setLast_Name(rs.getString("LastName"));
            u.setName(rs.getString("Name"));
            u.setType(rs.getInt("UserType"));
            list.add(u); 
        }
        return list;
    }
    
    public boolean deleteUser(int id) throws ClassNotFoundException{
        UserConnector connector = new UserConnector();
        Boolean status = connector.deleteUser(conn, id);
        return status;
    }
    
    public boolean deleteCareer(Career c) throws ClassNotFoundException{
        CareerConnector connector = new CareerConnector();
        Boolean status = connector.deleteCareer(conn, c);
        return status;
    }
    
    public boolean updateUser(User u) throws ClassNotFoundException{
        UserConnector connector = new UserConnector();
        Boolean status = connector.updateUser(conn, u);
        return status;
    }
    
    public boolean updateCareer(Career c, String Career, String Plan) throws ClassNotFoundException{
        CareerConnector connector = new CareerConnector();
        Boolean status = connector.updateCareer(conn, c, Career, Plan);
        return status;
    }
    
    //METODO PARA PROBAR
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseController d = new DatabaseController();
        Career c = new Career();
        c.setCareer("Carrera2");
        c.setPlan("asd");
        c.setUniversity("TEC");
        Boolean status = d.updateCareer(c,"Carrera","asd");

        ArrayList<Career> list = d.getCareers();
        
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i).getCareer());
        }
        Boolean status2 = d.deleteCareer(c);
        ArrayList<Career> list2 = d.getCareers();
        
        for(int i = 0;i<list2.size();i++){
            System.out.println(list2.get(i).getCareer());
        }
    }
}