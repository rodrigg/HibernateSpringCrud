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
import java.util.Date;
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
        listCalendar("");
    }

    public void listCalendar(String s){
        ArrayList<Event> events = null;
        if(s.length() > 0) {
            events = calendarResource.findEventsByName(s);
        }else{
            events = calendarResource.getEvents();
        }

        ListIterator ei = events.listIterator();
        while(ei.hasNext()) {
            Event event = (Event) ei.next();
            System.out.print("[" + event.getPos() + "] ");
            System.out.print(event.getStart().toString() + " ");
            System.out.print(event.getTitle() + " ");
            System.out.println(event.getDuration() + "min");
        }
    }

    public void listCalendarByDate(Date d){
        ArrayList<Event> events = null;
        events = calendarResource.findEventsByDate(d);

        ListIterator ei = events.listIterator();
        while(ei.hasNext()) {
            Event event = (Event) ei.next();
            System.out.print("[" + event.getPos() + "] ");
            System.out.print(event.getStart().toString() + " ");
            System.out.print(event.getTitle() + " ");
            System.out.println(event.getDuration() + "min");
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

    public void deleteEventByPos(int pos){
        ArrayList<Event> events = null;
        events = calendarResource.getEvents();

        ListIterator ei = events.listIterator();
        while(ei.hasNext()) {
            Event event = (Event) ei.next();
            if(event.getPos() == pos){
                File eventFile = new File(calendarPath.toString() + "/" + event.getId() +".xml");
                try {
                    eventFile.delete();
                    calendarResource.deleteEventByPos(pos);
                    break;
                }catch(Exception e){

                }
            }
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

}
