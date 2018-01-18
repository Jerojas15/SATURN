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
    Career c,f;
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
            f = new Career();
            f.setCareerName("Computacion");
            f.setUniversity("TEC");
            f.setPlan("C-411");
            d.insertNewCareer(f);

            
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
        assertTrue(d.deleteCareer(2));
    }
    @Test
    public void UpdateCareerName() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        c = new Career();
            c.setUniversity("TEC");
            c.setPlan("C-417");
            c.setCareerName("Electrica Modificada");
        assertTrue(d.updateCareer(c,3));

    }

    @Test
    public void UpdateCareerUniversity() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        c = new Career();
        c.setCareerName("Electrica");
            c.setPlan("C-417");
            c.setUniversity("UNA");
        assertTrue(d.updateCareer(c,1));

    }

    @Test
    public void getCareerList() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        assertNotEquals(d.getCareers().size(), 0);
    }
 

    
    
    
}