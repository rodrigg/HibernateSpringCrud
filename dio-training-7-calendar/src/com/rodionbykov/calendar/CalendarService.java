package com.rodionbykov.calendar;

import com.rodionbykov.calendar.storage.EventAdapter;
import com.rodionbykov.calendar.storage.EventFileVisitor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Rodion Bykov on 22.05.2014.
 */
public class CalendarService implements Service {

    private final Calendar calendarResource;
    private final EventFileVisitor eventFileVisitor;

    public CalendarService(Calendar calendarResource, EventFileVisitor eventFileVisitor) {
        this.calendarResource = calendarResource;
        this.eventFileVisitor = eventFileVisitor;
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

    public void addEvent(Event event){

        calendarResource.addEvent(event);

        File file = new File(event.getId() + ".xml");
        JAXBContext context = null;

        EventAdapter eventAdapter = new EventAdapter(event);
        try {
            context = JAXBContext.newInstance(EventAdapter.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(eventAdapter, new File("C:\\temp\\calendarstorage\\"+event.getId() +".xml"));
        } catch (JAXBException e) {
            System.err.println(e);
        }

    }

    public void loadCalendar(){
        Path dir = Paths.get("C:\\temp\\calendarstorage");

        ArrayList<Event> events;


        try {
            Files.walkFileTree(dir, eventFileVisitor);
            calendarResource.setEvents(eventFileVisitor.getEvents());
        }catch(IOException e){
            System.err.println(e);
        }

    }

    public void unloadCalendar(){

    }

}
