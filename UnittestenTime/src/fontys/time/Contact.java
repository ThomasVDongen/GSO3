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
public class Contact {
    private final String name;
    private final ArrayList<Appointment> appointments;
    
    public Contact(String name) {
        this.name = name;
        appointments = new ArrayList();
    }
    
    /**
     * Gets the name of the contact
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Adds appointment to contact
     * @param a appointment to be added
     * @return true if appointment is added false if appointment collides with current appointments
     */
    boolean addAppointment(Appointment a) {
        for(Appointment app : appointments) {
            if(app.getTimeSpan().intersectionWith(a.getTimeSpan()) != null)
                return false;
        }
        appointments.add(a);
        return true;
    }
    
    /**
     * Removes appointment from contact
     * @param a appointment to be removed
     */
    void removeAppointment(Appointment a) {
        appointments.remove(a);
    }
    
    /**
     * Gets the iterator for the appointment list
     * @return appointment iterator
     */
    public Iterator<Appointment> appointment() {
        return appointments.iterator();
    }
}
