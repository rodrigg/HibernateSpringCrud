package com.rodionbykov.calendar;

import java.util.ArrayList;

public class Calendar implements Resource {

    private ArrayList<Event> events;

    public Calendar(){
        this.events = new ArrayList<Event>();
    }

    public Calendar(ArrayList<Event> events) {
        this.events = events;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public ArrayList<Event> findEventsByName(String s){
        ArrayList<Event> events = this.getEvents();
        ArrayList<Event> result = new ArrayList<Event>();

        for(Event event : events){
            if(event.getTitle().contains(s)) {
                result.add(event);
            }
        }

        return result;
    }

    public void addEvent(Event event){
        this.events.add(event);
    }

}
