package com.rodionbykov.calendar;

import java.io.File;
import java.util.*;

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
        enumerateEvents();
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

    public ArrayList<Event> findEventsByDate(Date d){
        ArrayList<Event> events = this.getEvents();
        ArrayList<Event> result = new ArrayList<Event>();

        for(Event event : events){
            java.util.Calendar calendar1 = new GregorianCalendar();
            calendar1.setTime(d);
            java.util.Calendar calendar2 = new GregorianCalendar();
            calendar2.setTime(event.getStart());
            if(calendar1.get(java.util.Calendar.DAY_OF_YEAR) == calendar2.get(java.util.Calendar.DAY_OF_YEAR)) {
                result.add(event);
            }
        }

        return result;
    }

    public void addEvent(Event event){
        this.events.add(event);
        enumerateEvents();
    }

    public void deleteEventByPos(int pos){
        ListIterator ei = events.listIterator();
        while(ei.hasNext()) {
            Event event = (Event) ei.next();
            if(event.getPos() == pos){
                try {
                    ei.remove();
                }catch(Exception e){

                }
            }
        }
        enumerateEvents();
    }

    private void enumerateEvents(){
        Collections.sort( events, new EventComparator() );
        ListIterator ei = events.listIterator();
        int i = 1;
        while(ei.hasNext()) {
            Event event = (Event) ei.next();
            event.setPos(i);
            i++;
        }
    }

}
