/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.GregorianCalendar;
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
public class TimeTest {
    
    private Time time;
    private GregorianCalendar gc;
    
    public TimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        time = new Time(2016, 9, 27, 1, 1);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
    * Test of getDayInWeek method, of class Time.
    */
    @Test
    public void testGetDayInWeek() {
        System.out.println("getDayInWeek");
        DayInWeek expResult = DayInWeek.TUE;
        DayInWeek result = time.getDayInWeek();
        assertEquals(expResult, result);
    }
    
    @Test
    public void callEnum() {
        DayInWeek.valueOf("MON");
        DayInWeek.valueOf("TUE");
        DayInWeek.valueOf("WED");
        DayInWeek.valueOf("THU");
        DayInWeek.valueOf("FRI");
        DayInWeek.valueOf("SAT");
        DayInWeek.valueOf("SUN");
        
    }
    

    @Test
    public void testGetDayInWeekMon() {
        System.out.println("getDayInWeek");
        DayInWeek expResult = DayInWeek.MON;
        gc = new GregorianCalendar(2016, 9, 31, 0, 0);
        time.gc = gc;
        DayInWeek result = time.getDayInWeek();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDayInWeekTue() {
        System.out.println("getDayInWeek");
        DayInWeek expResult = DayInWeek.TUE;
        gc = new GregorianCalendar(2016, 9, 27, 0, 0);
        time.gc = gc;
        DayInWeek result = time.getDayInWeek();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDayInWeekWed() {
        System.out.println("getDayInWeek");
        DayInWeek expResult = DayInWeek.WED;
        gc = new GregorianCalendar(2016, 9, 28, 0, 0);
        time.gc = gc;
        DayInWeek result = time.getDayInWeek();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDayInWeekThu() {
        System.out.println("getDayInWeek");
        DayInWeek expResult = DayInWeek.THU;
        gc = new GregorianCalendar(2016, 9, 29, 0, 0);
        time.gc = gc;
        DayInWeek result = time.getDayInWeek();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDayInWeekFri() {
        System.out.println("getDayInWeek");
        DayInWeek expResult = DayInWeek.FRI;
        gc = new GregorianCalendar(2016, 9, 30, 0, 0);
        time.gc = gc;
        DayInWeek result = time.getDayInWeek();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDayInWeekSat() {
        System.out.println("getDayInWeek");
        DayInWeek expResult = DayInWeek.SAT;
        gc = new GregorianCalendar(2016, 10, 1, 0, 0);
        time.gc = gc;
        DayInWeek result = time.getDayInWeek();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDayInWeekSun() {
        System.out.println("getDayInWeek");
        DayInWeek expResult = DayInWeek.SUN;
        gc = new GregorianCalendar(2016, 10, 2, 0, 0);
        time.gc = gc;
        DayInWeek result = time.getDayInWeek();
        assertEquals(expResult, result);
    }
    
        
    @Test
    public void testGetDayInWeekNull() {
        System.out.println("getDayInWeek");
        DayInWeek expResult = null;
        gc = new GregorianCalendar(2016, 9, 31, 0, 0);
        time.gc = gc;
        DayInWeek result = time.getDayInWeek();
        assertEquals(expResult, result);
    }
    
    /**
     * Testing illegal input of the Time ctor.
     */
    @Test
    (expected=IllegalArgumentException.class)
    public void testMonthOutOfRange() {
        time = new Time(2016, 13, 1, 1, 1);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testDayOutOfRange() {
        time = new Time(2016, 1, 32, 1, 1);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testHourOutOfRange() {
        time = new Time(2016, 1, 1, 24, 1);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testMinuteOutOfRange() {
        time = new Time(2016, 1, 1, 1, 60);
    }
    
        @Test
    (expected=IllegalArgumentException.class)
    public void testMonthOutOfRangeUnder() {
        time = new Time(2016, 0, 1, 1, 1);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testDayOutOfRangeUnder() {
        time = new Time(2016, 1, 0, 1, 1);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testHourOutOfRangeUnder() {
        time = new Time(2016, 1, 1, -1, 1);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void testMinuteOutOfRangeUnder() {
        time = new Time(2016, 1, 1, 1, -1);
    }

    /**
     * Test of getYear method, of class Time.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        int expResult = 2016;
        int result = time.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class Time.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        int expResult = 9;
        int result = time.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class Time.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        int expResult = 20;
        int result = time.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        int expResult = 11;
        int result = time.getHours();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        int expResult = 25;
        int result = time.getMinutes();
        assertEquals(expResult, result);
    }

    /**
     * Test of plus method, of class Time.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        int minutes = 20;
        int expResult = 45;
        ITime result = time.plus(minutes);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        ITime t = time;
        int expResult = 0;
        int result = time.compareTo(t);
        assertEquals(expResult, result);
    }

    /**
     * Test of difference method, of class Time.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        ITime t = time;
        int expResult = 0;
        int result = time.difference(t);
        assertEquals(expResult, result);
    
    }
    
}
