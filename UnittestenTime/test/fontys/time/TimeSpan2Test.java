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
 * @author Thomas
 */
public class TimeSpan2Test {

    TimeSpan2 timeSpan;

    public TimeSpan2Test() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        timeSpan = new TimeSpan2(new Time(2016, 9, 27, 0, 0), new Time(2016, 9, 29, 0, 0));
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
        TimeSpan2 instance = timeSpan;
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
        TimeSpan2 instance = timeSpan;
        ITime expResult = new Time(2016, 9, 29, 0, 0);
        ITime result = instance.getEndTime();
        assertEquals(expResult, result);
    }

    /**
     * Test the exception throwing of the ctor
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetBeginTimeException() {
        System.out.println("getBeginTime");
        timeSpan = new TimeSpan2(new Time(2016, 9, 27, 0, 0), new Time(2016, 9, 26, 0, 0));
    }

    /**
     * Test of length method, of class TimeSpan.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        TimeSpan2 instance = new TimeSpan2(new Time(2016, 9, 27, 0, 0), new Time(2016, 9, 27, 0, 1));
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
        ITime beginTime = new Time(2016, 9, 30, 0, 0);
        TimeSpan2 instance = timeSpan;
        instance.setBeginTime(beginTime);
        ITime expResult = beginTime;
        assertEquals(expResult, instance.getBeginTime());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBeginTimeException() {
        System.out.println("setBeginTimeException");
        ITime beginTime = new Time(2016, 9, 25, 0, 0);
        TimeSpan2 instance = timeSpan;
        instance.setBeginTime(beginTime);
        ITime expResult = beginTime;
        assertEquals(expResult, instance.getBeginTime());
    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetEndTimeException() {
        System.out.println("setEndTimeException");
        ITime endTime = new Time(2016, 9, 24, 0, 0);
        TimeSpan2 instance = timeSpan;
        instance.setEndTime(endTime);

    }

    /*
    test the normal setter
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTimeException");
        ITime endTime = new Time(2016, 9, 30, 0, 0);
        TimeSpan2 instance = timeSpan;
        instance.setEndTime(endTime);
        assertEquals(endTime, timeSpan.getEndTime());
    }

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove() {
        System.out.println("test move");
        int minutes = 30;
        TimeSpan2 instance = new TimeSpan2(new Time(2017, 5, 8, 18, 20), new Time(2017, 5, 8, 20, 20));
        instance.move(minutes);
        ITime begin = new Time(2017, 5, 8, 18, 50);
        ITime end = new Time(2017, 5, 8, 20, 50);
        assertTrue(begin.compareTo(instance.getBeginTime()) == 0);
        assertTrue(end.compareTo(instance.getEndTime()) == 0);
        minutes = -10;
        instance = new TimeSpan2(new Time(2017, 1, 18, 10, 20), new Time(2017, 5, 8, 20, 20));
        instance.move(minutes);
        begin = new Time(2017, 1, 18, 10, 20);
        end = new Time(2017, 5, 8, 20, 10);
        assertTrue(begin.compareTo(instance.getBeginTime()) == 0);
        assertTrue(end.compareTo(instance.getEndTime()) == 0);
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testChangeLengthWith1() {

        System.out.println("changeLengthWith1");
        int minutes = -10;
        timeSpan.changeLengthWith(minutes);

    }

    /**
     *
     */
    @Test
    public void testChangeLengthWith2() {
        System.out.println("changeLengthWith2");
        int minutes = 10;
        int expResult = 10;
        timeSpan.changeLengthWith(minutes);
        int result = timeSpan.length();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        //aanmaken testspans
        ITimeSpan timeSpan1 = new TimeSpan2(new Time(2017, 1, 20, 19, 20), new Time(2017, 1, 20, 21, 20));
        ITimeSpan timeSpan2 = new TimeSpan2(new Time(2017, 1, 20, 17, 20), new Time(2017, 1, 20, 19, 20));
        ITimeSpan timeSpan3 = new TimeSpan2(new Time(2017, 1, 20, 17, 20), new Time(2017, 1, 20, 21, 20));
        // het objectt aanmaken
        TimeSpan2 instance = new TimeSpan2(new Time(2017, 1, 20, 18, 20), new Time(2017, 1, 20, 20, 20));
        boolean result1 = instance.isPartOf(timeSpan1);
        boolean result2 = instance.isPartOf(timeSpan2);
        boolean result3 = instance.isPartOf(timeSpan3);
        //vergelijken
        assertEquals(false, result1);
        assertEquals(false, result2);
        assertEquals(true, result3);
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        //aanmaken van testspans
        ITimeSpan timeSpan1 = new TimeSpan2(new Time(2017, 1, 20, 19, 20), new Time(2017, 1, 20, 21, 20));
        ITimeSpan timeSpan2 = new TimeSpan2(new Time(2017, 1, 20, 17, 20), new Time(2017, 1, 20, 19, 20));
        ITimeSpan timeSpan3 = new TimeSpan2(new Time(2017, 1, 20, 17, 20), new Time(2017, 1, 20, 21, 20));
        ITimeSpan timeSpan4 = new TimeSpan2(new Time(2017, 1, 20, 15, 20), new Time(2017, 1, 20, 17, 20));
        ITimeSpan timeSpan5 = new TimeSpan2(new Time(2017, 1, 20, 21, 20), new Time(2017, 1, 20, 23, 20));
        // het objectt aanmaken
        TimeSpan2 instance = new TimeSpan2(new Time(2017, 1, 20, 18, 20), new Time(2017, 1, 20, 20, 20));
        //results aangeven
        ITimeSpan expResult1 = new TimeSpan2(new Time(2017, 1, 20, 18, 20), new Time(2017, 1, 20, 21, 20));
        ITimeSpan expResult2 = new TimeSpan2(new Time(2017, 1, 20, 17, 20), new Time(2017, 1, 20, 20, 20));
        ITimeSpan expResult3 = new TimeSpan2(new Time(2017, 1, 20, 17, 20), new Time(2017, 1, 20, 21, 20));
        //results krijgen
        ITimeSpan result1 = instance.unionWith(timeSpan1);
        ITimeSpan result2 = instance.unionWith(timeSpan2);
        ITimeSpan result3 = instance.unionWith(timeSpan3);
        ITimeSpan result4 = instance.unionWith(timeSpan4);
        ITimeSpan result5 = instance.unionWith(timeSpan5);
        //vergelijken
        assertTrue((expResult1.getBeginTime().compareTo(result1.getBeginTime()) == 0) && (expResult1.getEndTime().compareTo(result1.getEndTime()) == 0));
        assertTrue((expResult2.getBeginTime().compareTo(result2.getBeginTime()) == 0) && (expResult2.getEndTime().compareTo(result2.getEndTime()) == 0));
        assertTrue((expResult3.getBeginTime().compareTo(result3.getBeginTime()) == 0) && (expResult3.getEndTime().compareTo(result3.getEndTime()) == 0));
        assertEquals(null, result4);
        assertEquals(null, result5);
    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        ///creating all the testspans
        ITimeSpan timeSpan1 = new TimeSpan2(new Time(2017, 1, 10, 19, 20), new Time(2017, 1, 10, 21, 20));
        ITimeSpan timeSpan2 = new TimeSpan2(new Time(2017, 1, 10, 17, 20), new Time(2017, 1, 10, 19, 20));
        ITimeSpan timeSpan3 = new TimeSpan2(new Time(2017, 1, 10, 17, 20), new Time(2017, 1, 10, 21, 20));
        ITimeSpan timeSpan4 = new TimeSpan2(new Time(2017, 1, 10, 15, 20), new Time(2017, 1, 10, 17, 20));
        //creating the timespan to test with
        TimeSpan2 instance = new TimeSpan2(new Time(2017, 1, 10, 18, 20), new Time(2017, 1, 10, 20, 20));
        //creatint the expected results
        ITimeSpan expResult1 = new TimeSpan2(new Time(2017, 1, 10, 19, 20), new Time(2017, 1, 10, 20, 20));
        ITimeSpan expResult2 = new TimeSpan2(new Time(2017, 1, 10, 18, 20), new Time(2017, 1, 10, 19, 20));
        ITimeSpan expResult3 = new TimeSpan2(new Time(2017, 1, 10, 18, 20), new Time(2017, 1, 10, 20, 20));
        ITimeSpan expResult4 = null;
        //starting the tests
        ITimeSpan result1 = instance.intersectionWith(timeSpan1);
        ITimeSpan result2 = instance.intersectionWith(timeSpan2);
        ITimeSpan result3 = instance.intersectionWith(timeSpan3);
        ITimeSpan result4 = instance.intersectionWith(timeSpan4);
        //asserting values
        assertTrue((expResult1.getBeginTime().compareTo(result1.getBeginTime()) == 0) && (expResult1.getEndTime().compareTo(result1.getEndTime()) == 0));
        assertTrue((expResult2.getBeginTime().compareTo(result2.getBeginTime()) == 0) && (expResult2.getEndTime().compareTo(result2.getEndTime()) == 0));
        assertTrue((expResult3.getBeginTime().compareTo(result3.getBeginTime()) == 0) && (expResult3.getEndTime().compareTo(result3.getEndTime()) == 0));
        assertEquals(expResult4, result4);
    }

}
