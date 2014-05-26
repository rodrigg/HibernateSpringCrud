package com.rodionbykov.calendar;

import java.util.ArrayList;

/**
 * Created by Rodion Bykov on 22.05.2014.
 */
public class CalendarService implements Service {

    private final Calendar calendarResource;

    public CalendarService(Calendar calendarResource) {
        this.calendarResource = calendarResource;
    }

    public void listCalendar(){
        ArrayList<Event> events = calendarResource.getEvents();

        for(Event event : events){
            System.out.println(event.toString());
        }
    }

    public void listCalendar(String s){
        ArrayList<Event> events = calendarResource.findEventsByName(s);

        for(Event event : events){
            System.out.println(event.toString());
        }
    }

}
