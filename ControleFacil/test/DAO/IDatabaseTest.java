/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celio
 */
public class IDatabaseTest {
    
    public IDatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of conectar method, of class IDatabase.
     */
    @Test
    public void testConectar() {
        System.out.println("conectar");
        IDatabase instance = new IDatabaseImpl();
        Connection expResult = null;
        Connection result = instance.conectar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IDatabaseImpl implements IDatabase {

        public Connection conectar() {
            return null;
        }
    }
}
