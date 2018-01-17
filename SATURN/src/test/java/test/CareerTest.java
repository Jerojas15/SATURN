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
import model.Career;
import databaseConnector.CareerConnector;

public class CareerTest {
    DatabaseController d;
    Career c;
    static Boolean ready = false;
    public CareerTest(){
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
            c = new Career();
            c.setCareerName("Computacion");
            c.setUniversity("TEC");
            c.setPlan("C-410");
            d.insertNewCareer(c);

            
            ready = true;
        }
    }
    
    @Test
    public void testDatabaseConnection() throws SQLException, ClassNotFoundException{
        d = new DatabaseController();
        assertNotEquals(d.makeConnection(), null);
    }
    @Test
    public void InsertCareer() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        c = new Career();
            c.setCareerName("Electrica");
            c.setUniversity("TEC");
            c.setPlan("C-417");
        assertTrue(d.insertNewCareer(c));
    }
    @Test
    public void InsertNullCareer() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        c = new Career();
        assertFalse(d.insertNewCareer(c));
    }
    @Test
    public void deleteCareer() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        c = new Career();
        assertTrue(d.deleteCareer(c));
    }
    @Test
    public void UpdateCareerName() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        c = new Career();
        int id;
            c.setCareerName("Electrica");
            c.setUniversity("TEC");
            c.setPlan("C-418");
            d.insertNewCareer(c);
            id = c.getCareerId();
            c.setCareerName("Electrica Modificada");
        assertTrue(d.updateCareer(c,id));

    }
    @Test
    public void UpdateCareerUniversity() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        c = new Career();
        int id;
            c.setCareerName("Electrica");
            c.setUniversity("TEC");
            c.setPlan("C-419");
            d.insertNewCareer(c);
            id = c.getCareerId();
            c.setUniversity("UNA");
        assertTrue(d.updateCareer(c,id));

    }
    @Test
    public void getCareerList() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        assertNotEquals(d.getCareers().size(), 0);
    }
 

    
    
    
}