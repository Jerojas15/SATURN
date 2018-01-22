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
import model.Group;
import databaseConnector.GroupConnector;
import java.sql.Connection;

public class GroupTest {
    DatabaseController d;
    Connection con;
    GroupConnector group;
    Group g,v,w;
    static Boolean ready = false;
    public GroupTest(){
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
        //se = new SessionConnector()
        /*
        if(!ready){
            s = new Seccion();
            g.setCapacity(7);
            g.setCourseId(1);
            g.setNumber(4);
            g.setPeriod(8);
            g.setTeacher(1);
            d.insertNewGroup(g);

            
            ready = true;
        }
        */
        
    }
    
    
    @Test
    public void InserGroup() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        con = d.makeConnection();
        group = new GroupConnector();
        g = new Group();
            g.setCapacity(7);
            g.setCourseId(1);
            g.setNumber(4);
            g.setPeriod(8);
            g.setTeacher(1);
        assertTrue(group.insertNewGroup(con, g));
    }
  @Test
    public void InsertNullGroup() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        con = d.makeConnection();
        group = new GroupConnector();
        g = new Group();
        assertFalse(group.insertNewGroup(con, g));
    }

   
    @Test
    public void deleteGroup() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        assertTrue(d.deleteGroup(2));
    }

    @Test
    public void UpdateGroupCapacity() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        g = new Group();
            g.setCapacity(7);
            g.setCourseId(1);
            g.setNumber(4);
            g.setPeriod(8);
            g.setTeacher(1);
        assertTrue(d.updateGroup(g, 1));

    }
    @Test
    public void UpdatePeriod() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        g = new Group();
            g.setCapacity(7);
            g.setCourseId(1);
            g.setNumber(4);
            g.setPeriod(9);
            g.setTeacher(1);
        assertTrue(d.updateGroup(g, 1));

    }
    @Test
    public void UpdateNumber() throws ClassNotFoundException, SQLException{
        d = new DatabaseController();
        g = new Group();
            g.setCapacity(7);
            g.setCourseId(1);
            g.setNumber(14);
            g.setPeriod(9);
            g.setTeacher(1);
        assertTrue(d.updateGroup(g, 1));

    }

  
}
