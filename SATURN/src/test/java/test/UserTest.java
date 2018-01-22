/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controller.DatabaseController;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Ignore;
import model.User;
import databaseConnector.UserConnector;

public class UserTest {
    DatabaseController d;
    User u,v,w;
    static Boolean ready = false;
    public UserTest(){
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {

    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void prepareDatabase() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        if(!ready){
            u = new User();
            v = new User();
            w = new User();
            u.setName("Jose");
            u.setLastName("Hernadez");
            u.setPassword("admin");
            u.setUserName("admin");
            u.setType(0);
            u.setCareerId(1);
            d.insertNewUser(u);
            v.setName("Miguel");
            v.setLastName("Viquez");
            v.setPassword("admin");
            v.setUserName("admin");
            v.setType(0);
            v.setCareerId(1);
            d.insertNewUser(v);

            
            ready = true;
        }
    }
    
    
    @Test
    public void InsertUser() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        u = new User();
            u.setName("Miguel");
            u.setLastName("Hernadez");
            u.setPassword("admin");
            u.setUserName("admin");
            u.setType(0);
            u.setCareerId(1);
        assertTrue(d.insertNewUser(u));
    }
    @Test
    public void InsertNullUser() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        u = new User();
        assertFalse(d.insertNewUser(u));
    }
    @Test
    public void deleteUser() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        assertTrue(d.deleteUser(2));
    }
    @Test
    public void UpdateName() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        u = new User();
        int id;
            u.setName("Miguel");
            u.setLastName("Viquez");
            u.setPassword("admin");
            u.setUserName("admin");
            u.setType(0);
            u.setCareerId(1);
            d.insertNewUser(u);
            id = 3;
            u.setName("Raul");
        assertTrue(d.updateUser(u, id));

    }
    @Test
    public void UpdateUserLastName() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        u = new User();
        int id;
            u.setName("Miguel");
            u.setLastName("Hernadez");
            u.setPassword("admin");
            u.setUserName("admin");
            u.setType(0);
            u.setCareerId(1);
            d.insertNewUser(u);
            id = 3;
            u.setLastName("Viquez");
        assertTrue(d.updateUser(u, id));

    }
    @Test
    public void UpdateUserPassword() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        u = new User();
        int id;
            u.setName("Miguel");
            u.setLastName("Hernadez");
            u.setPassword("admin");
            u.setUserName("admin");
            u.setType(0);
            u.setCareerId(1);
            d.insertNewUser(u);
            id = 3;
            u.setPassword("Admin");
        assertTrue(d.updateUser(u, id));

    }
    @Test
    public void UpdateUserName() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        u = new User();
        int id;
            u.setName("Miguel");
            u.setLastName("Hernadez");
            u.setPassword("admin");
            u.setUserName("admin");
            u.setType(0);
            u.setCareerId(1);
            d.insertNewUser(u);
            id = 3;
            u.setUserName("Admin");
        assertTrue(d.updateUser(u, id));

    }
   
    
    
}