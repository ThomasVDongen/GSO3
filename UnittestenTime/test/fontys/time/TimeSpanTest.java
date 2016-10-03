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
        ITime beginTime = new Time(2016, 5, 8, 21, 50);
        TimeSpan instance = new TimeSpan(new Time(2016, 5, 8, 18, 50), new Time(1993, 5, 8, 20, 50));
        instance.setBeginTime(beginTime);

        beginTime = new Time(2016, 5, 8, 17, 50);
        instance.setBeginTime(beginTime);
        assertTrue(beginTime.compareTo(instance.getBeginTime()) == 0);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testSetBeginTimeException() {
        System.out.println("setBeginTime");
        ITime beginTime = new Time(2016, 10, 29, 0, 0);
        TimeSpan instance = timeSpan;
        instance.setBeginTime(beginTime);
    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        ITime endTime = new Time(2016, 5, 8, 17, 50);
        TimeSpan instance = new TimeSpan(new Time(2016, 5, 8, 18, 50), new Time(2016, 5, 8, 20, 50));
        instance.setEndTime(endTime);
        endTime = new Time(2016, 5, 8, 21, 50);
        instance.setEndTime(endTime);
        assertTrue(endTime.compareTo(instance.getEndTime()) == 0);
    }
    

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove() {
        System.out.println("testMove");
        int minutes = 30;
        TimeSpan instance = new TimeSpan(new Time(2016, 5, 8, 1, 0), new Time(2016, 5, 8, 2, 0));
        instance.move(minutes);
        ITime begin = new Time(2016, 5, 8, 1, 0);
        ITime end = new Time(2016, 5, 8, 2, 0);
        assertTrue(begin.compareTo(instance.getBeginTime()) == 0);
        assertTrue(end.compareTo(instance.getEndTime()) == 0);
        minutes = -10;
        instance = new TimeSpan(new Time(2016, 5, 8, 1, 0), new Time(2016, 5, 2, 2, 0));
        instance.move(minutes);
        begin = new Time(2016, 5, 8, 1, 0);
        end = new Time(2016, 5, 8, 2, 0);
        assertTrue(begin.compareTo(instance.getBeginTime()) == 0);
        assertTrue(end.compareTo(instance.getEndTime()) == 0);
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test
    public void testChangeLengthWith() {
        System.out.println("changeLengthWith");
        int minutes = 5;
        ITime expResult = new Time(2016, 9, 29, 0, 5);
        ITimeSpan instance = timeSpan;
        instance.changeLengthWith(minutes);
        
        assertEquals(timeSpan.getEndTime(), expResult);
        
 
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testChangeLengthTimeException() {
        System.out.println("Change length exception");
        TimeSpan instance = timeSpan;
        int minutes = -10;
        instance = new TimeSpan(new Time(2016, 9, 29, 0, 0), new Time(2016, 9, 29, 0, 5));
        try {
            instance.changeLengthWith(minutes);
        } catch(IllegalArgumentException iEx){
            assertTrue(true);
        }
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        ITimeSpan timeSpan1 = new TimeSpan(new Time(2016, 9, 28, 0, 1), new Time(2016, 9, 28, 0, 5));
        TimeSpan instance = timeSpan;
        boolean expResult = true;
        boolean expResultF = false;
        boolean result = instance.isPartOf(timeSpan1);

        assertEquals(expResult, result);
        
        ITimeSpan timeSpan2 = new TimeSpan(new Time(2000, 0, 0, 0, 10), new Time(2001, 0, 0, 0, 20));
        boolean result2 = instance.isPartOf(timeSpan2);
        
        assertEquals(expResultF, result2);
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        ITimeSpan timeSpan = new TimeSpan(new Time(2016, 9, 28, 0, 1), new Time(2016, 9, 28, 0, 5));
        ITimeSpan instance = timeSpan;
        ITimeSpan expResult = new TimeSpan(new Time(2016, 9, 28, 0, 1), new Time(2016, 9, 28, 0, 5));
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        
        timeSpan = new TimeSpan(new Time(2016, 9, 28, 0, 1), new Time(2016, 9, 28, 0, 10));
        instance = timeSpan;
        expResult = new TimeSpan(new Time(2016, 9, 28, 0, 1), new Time(2016, 9, 28, 0, 10));
        result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        ITimeSpan timeSpan = new TimeSpan(new Time(2016, 9, 28, 0, 1), new Time(2016, 9, 28, 0, 5));
        ITimeSpan instance = timeSpan;
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}