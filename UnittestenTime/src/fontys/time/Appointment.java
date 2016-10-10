/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Thomas
 */
public class Appointment{
    private final String subject;
    private final ITimeSpan timespan;
    private final ArrayList<Contact> contacts;
    
    public Appointment(String subject, ITimeSpan timespan) {
        this.subject = subject;
        this.timespan = timespan;
        contacts = new ArrayList();
    }
    
    /**
     * Gets the subject of the appointment
     * @return subject
     */
    public String getSubject() {
        return subject;
    }
    
    /**
     * Gets the timespan of the appointment
     * @return timespan
     */
    public ITimeSpan getTimeSpan() {
        return timespan;
    }
    
    /**
     * Gets iterator for all contacts for this appointment
     * @return iterator
     */
    public Iterator<Contact> invitees() {
        return contacts.iterator();
    }
    
    /**
     * Adds contact to this appointment
     * @param c contact to be added
     * @return true if contact can be added
     */
    public boolean addContact(Contact c) {
        if(contacts.contains(c))
            return false;
        if(!c.addAppointment(this))
            return false;
        contacts.add(c);
        return true;
    }
    
    /**
     * Removes contact from appointment
     * @param c contact to be removed
     */
    public void removeContact(Contact c) {
        c.removeAppointment(this);
        contacts.remove(c);
    }
}
