/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author koenv
 */
public class TimeSpanTest {
    
    private TimeSpan timeSpan;
    
    public TimeSpanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        timeSpan = new TimeSpan(new Time(2016, 9, 27, 0, 0), new Time(2016, 9, 29, 0, 0));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBeginTime method, of class TimeSpan.
     */
    @Test
    public void testGetBeginTime() {
        System.out.println("getBeginTime");
        TimeSpan instance = timeSpan;
        ITime expResult = new Time(2016, 9, 27, 0, 0);
        ITime result = instance.getBeginTime();
        assertEquals(expResult, result);
    }
    


    /**
     * Test of getEndTime method, of class TimeSpan.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        TimeSpan instance = timeSpan;
        ITime expResult = new Time(2016, 9, 29, 0, 0);
        ITime result = instance.getEndTime();
        assertEquals(expResult, result);
    }
    
    /**
     * Test the exception throwing of the ctor
     */
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testGetBeginTimeException() {
        System.out.println("getBeginTime");
        timeSpan = new TimeSpan(new Time(2016, 9, 27, 0, 0), new Time(2016, 9, 27, 0, 0));
    }

    /**
     * Test of length method, of class TimeSpan.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        TimeSpan instance = new TimeSpan(new Time(2016, 9, 27, 0, 0), new Time(2016, 9, 27, 0, 1));;
        int expResult = 60000;
        int result = instance.length();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBeginTime method, of class TimeSpan.
     */
    @Test
    public void testSetBeginTime() {
        System.out.println("setBeginTime");
        ITime beginTime = new Time(2016, 9, 25, 0, 0);
        TimeSpan instance = timeSpan;
        instance.setBeginTime(beginTime);
        ITime expResult = beginTime;
        assertEquals(expResult, instance.getBeginTime());
    }
    
    @Test
    public void testSetBeginTimeException() {
        System.out.println("setBeginTime");
        ITime beginTime = new Time(2016, 9, 25, 0, 0);
        TimeSpan instance = timeSpan;
        instance.setBeginTime(beginTime);
        ITime expResult = beginTime;
        assertEquals(expResult, instance.getBeginTime());
    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        ITime endTime = null;
        TimeSpan instance = null;
        instance.setEndTime(endTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int minutes = 0;
        TimeSpan instance = null;
        instance.move(minutes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test
    public void testChangeLengthWith() {
        System.out.println("changeLengthWith");
        int minutes = 0;
        TimeSpan instance = null;
        instance.changeLengthWith(minutes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        ITimeSpan timeSpan = null;
        TimeSpan instance = null;
        boolean expResult = false;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        ITimeSpan timeSpan = null;
        TimeSpan instance = null;
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        ITimeSpan timeSpan = null;
        TimeSpan instance = null;
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
