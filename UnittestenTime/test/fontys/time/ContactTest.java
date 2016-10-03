/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
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
public class ContactTest {
    
    Contact instance;
    Appointment a;
    public ContactTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Contact("Thomas");
        a = new Appointment("Test", new TimeSpan(new Time(2016, 10, 2, 10, 30), new Time(2016, 10, 2, 13, 30)));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Contact.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Thomas";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of addAppointment method, of class Contact.
     */
    @Test
    public void testAddAppointment() {
        System.out.println("addAppointment");
        Appointment app2 = new Appointment("Test2", new TimeSpan(new Time(2016, 10, 2, 10, 30), new Time(2016, 10, 2, 13, 30)));
        Appointment app3 = new Appointment("Test", new TimeSpan(new Time(2016, 10, 2, 14, 30), new Time(2016, 10, 2, 16, 30)));
        assertTrue(instance.addAppointment(a));
        assertFalse(instance.addAppointment(app2));
        assertTrue(instance.addAppointment(app3));
    }

    /**
     * Test of removeAppointment method, of class Contact.
     */
    @Test
    public void testRemoveAppointment() {
        System.out.println("removeAppointment");
        assertTrue(instance.addAppointment(a));
        instance.removeAppointment(a);
    }

    /**
     * Test of appointment method, of class Contact.
     */
    @Test
    public void testAppointment() {
        System.out.println("appointment");
        Appointment b = new Appointment("Test", new TimeSpan(new Time(2016, 10, 2, 14, 30), new Time(2016, 10, 2, 16, 30)));
        instance.addAppointment(a);
        instance.addAppointment(b);
        ArrayList<Appointment> list = new ArrayList();
        list.add(a);
        list.add(b);
        Iterator<Appointment> result = instance.appointment();
        while(result.hasNext()) {
            if(!list.remove(result.next()))
                fail("Unknown appointment in contact");
        }
        if(list.size() != 0)
            fail("Not all appointments are in contact");
        assertTrue(true);
        DayInWeek.valueOf(DayInWeek.MON.toString());
    }
    
}
