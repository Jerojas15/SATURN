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
import model.Course;
import databaseConnector.CareerConnector;

public class CourseTest {
    DatabaseController d;
    Course c,f;
    static Boolean ready = false;
    public CourseTest(){
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
            c = new Course();
            f = new Course();
            c.setCode("502");
            c.setName("Redes");
            c.setSemester(2);
            c.setCareerId(1);
            f.setCode("503");
            f.setName("Redes5");
            f.setSemester(2);
            f.setCareerId(1);
            d.insertNewCourse(c);
            d.insertNewCourse(f);

            
            ready = true;
        }
    }
    
   
    @Test
    public void InsertCourse() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        c = new Course();
            c.setCode("502");
            c.setName("Redes");
            c.setSemester(2);
            c.setCareerId(1);
        assertTrue(d.insertNewCourse(c));
    }
    @Test
    public void InsertNullCourse() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        c = new Course();
        assertFalse(d.insertNewCourse(c));
    }
    @Test
    public void deleteCourse() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();          
        assertTrue(d.deleteCourse(2));
    }
     
    
}
