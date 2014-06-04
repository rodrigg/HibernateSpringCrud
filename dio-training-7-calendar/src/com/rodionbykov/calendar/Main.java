package com.rodionbykov.calendar;

import com.rodionbykov.calendar.storage.EventFileVisitor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Rodion Bykov on 22.05.2014.
 */
public class Main {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/rodionbykov/calendar/applicationContext.xml");

        CalendarService calendarService = (CalendarService) context.getBean("calendarService");

        calendarService.loadCalendar();

        calendarService.listCalendar();

        //calendarService.loadCalendar();
        //calendarService.unloadCalendar();

        //Event testEvent = new Event();
        //testEvent.setId( UUID.randomUUID() );
        //testEvent.setTitle("test event to be held");

        //calendarService.addEvent(testEvent);

    }

}
