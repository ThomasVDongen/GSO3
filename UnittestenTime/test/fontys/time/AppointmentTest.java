/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public class AppointmentTest {
    
    public AppointmentTest() {
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
     * Test of getSubject method, of class Appointment.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        Appointment instance = new Appointment("Test1", new TimeSpan(new Time(2016, 10,2, 10, 30), new Time(2016, 10, 2, 13, 30)));
        String expResult = "Test1";
        String result = instance.getSubject();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTimeSpan method, of class Appointment.
     */
    @Test
    public void testGetTimeSpan() {
        System.out.println("getTimeSpan");
        Appointment instance = new Appointment("Test1", new TimeSpan(new Time(2016, 9, 30, 10, 30), new Time(2016, 9, 30, 13, 30)));
        ITimeSpan expResult = new TimeSpan(new Time(2016, 9, 30, 10, 30), new Time(2016, 9, 30, 13, 30));
        ITimeSpan result = instance.getTimeSpan();
        assertEquals(expResult, result);
    }

    /**
     * Test of invitees method, of class Appointment.
     */
    @Test
    public void testInvitees() {
        System.out.println("invitees");
        Appointment instance = new Appointment("Test1", new TimeSpan(new Time(2016, 9, 30, 10, 30), new Time(2016, 9, 30, 13, 30)));
        Contact t = new Contact("Thomas");
        Contact k = new Contact("Koen");
        instance.addContact(k);
        instance.addContact(t);
        List<Contact> testContacts = new ArrayList();
        testContacts.add(t);
        testContacts.add(k);
        Iterator<Contact> result = instance.invitees();
        assertEquals(testContacts, result);
    }

    /**
     * Test of addContact method, of class Appointment.
     */
    @Test
    public void testAddContact() {
        System.out.println("addContact");
        Contact t = new Contact("Thomas");
        Contact k = new Contact("Koen");
        Appointment instance = new Appointment("Test1", new TimeSpan(new Time(2016, 10, 2, 10, 30), new Time(2016, 10, 2, 13, 30)));
        Appointment app = new Appointment("Test2", new TimeSpan(new Time(2016, 10, 2, 10, 30), new Time(2016, 10, 2, 13, 30)));
        Appointment app2 = new Appointment("Test3", new TimeSpan(new Time(2016, 10, 2, 14, 30), new Time(2016, 10, 2, 16, 30)));
        assertTrue(instance.addContact(t));
        assertFalse(instance.addContact(t));
        assertTrue(instance.addContact(k));
        assertFalse(app.addContact(k));
        assertTrue(app2.addContact(k));
    }

    /**
     * Test of removeContact method, of class Appointment.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("removeContact");
        Contact t = new Contact("Thomas");
        Appointment instance = new Appointment("Test1", new TimeSpan(new Time(2016, 10, 2, 10, 30), new Time(2016, 10, 2, 13, 30)));
        assertTrue(instance.addContact(t));
        instance.removeContact(t);
        instance.removeContact(t);
    }
    
}
