package com.rodionbykov.calendar;

import com.rodionbykov.calendar.storage.EventAdapter;
import com.rodionbykov.calendar.storage.EventFileVisitor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Rodion Bykov on 22.05.2014.
 */
public class CalendarService implements Service {

    private final Calendar calendarResource;
    private final EventFileVisitor eventFileVisitor;

    private Path calendarPath;

    public CalendarService(Calendar calendarResource, EventFileVisitor eventFileVisitor) {
        this.calendarResource = calendarResource;
        this.eventFileVisitor = eventFileVisitor;
    }

    public void setCalendarFolder(File calendarFolder){
        calendarPath = Paths.get(calendarFolder.getPath());
    }

    public void listCalendar(){
        ArrayList<Event> events = calendarResource.getEvents();

        ListIterator ei = events.listIterator();
        int i = 1;
        while(ei.hasNext()) {
            Event event = (Event) ei.next();
            System.out.print("[" + i + "] ");
            System.out.print(event.getStart().toString() + " ");
            System.out.print(event.getTitle() + " ");
            System.out.println(event.getDuration() + "min");
        }
    }

    public void listCalendar(String s){
        ArrayList<Event> events = calendarResource.findEventsByName(s);

        ListIterator ei = events.listIterator();
        while(ei.hasNext()) {
            Event event = (Event) ei.next();
            System.out.println(event.toString());
        }
    }

    public void addEvent(Event event){

        calendarResource.addEvent(event);

        JAXBContext context = null;

        EventAdapter eventAdapter = new EventAdapter(event);
        try {
            context = JAXBContext.newInstance(EventAdapter.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(eventAdapter, new File(calendarPath.toString() + "/" + event.getId() +".xml"));
        } catch (JAXBException e) {
            System.err.println(e);
        }

    }

    public void loadCalendar() throws NoSuchFileException{
        try {
            Files.walkFileTree(calendarPath, eventFileVisitor);
            calendarResource.setEvents(eventFileVisitor.getEvents());
        }catch(IOException e){
            System.err.println(e);
        }
    }

    public void unloadCalendar(){

    }

}
