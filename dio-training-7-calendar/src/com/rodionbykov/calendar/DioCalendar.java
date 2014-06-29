package com.rodionbykov.calendar;

import org.apache.commons.cli.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Rodion Bykov on 22.05.2014.
 */
public class DioCalendar {

    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/rodionbykov/calendar/applicationContext.xml");

        StartupOptions startupOptions = (StartupOptions) context.getBean("startupOptions");
        CalendarService calendarService = (CalendarService) context.getBean("calendarService");

        // initing command line options
        Options cmdOptions = startupOptions.getOptions();

        try {
            // initing temp file
            File tempFolder = File.createTempFile("temp-file-test", "tmp");
            File calendarFolder = new File(tempFolder.getParent() + "/dio-calendar-storage");
            if(!calendarFolder.exists()) {
                boolean success = calendarFolder.mkdir();
                if(!success){
                    throw(new IOException());
                }
            }
            calendarService.setCalendarFolder(calendarFolder);
        }catch (IOException e){
            System.out.println("Cannot create temp directory");
        }

        // loading calendar items from files
        try {
            calendarService.loadCalendar();
        }catch(NoSuchFileException e){
            System.out.println("Cannot load calendar");
        }

        try {
            CommandLineParser parser = new GnuParser();
            CommandLine cmd = parser.parse( cmdOptions, args );
            if ( cmd.hasOption("list") ) {
                calendarService.listCalendar();
            }
            if ( cmd.getOptions().length == 0 || cmd.hasOption("help") ) {
                DioCalendar.usage();
            }
        }catch(ParseException e){
            DioCalendar.usage();
        }

        /*
        Event testEvent = new Event();
        testEvent.setId( UUID.randomUUID() );
        testEvent.setTitle("test event to be held");
        testEvent.setStart(new Date());
        testEvent.setDuration(30);
        calendarService.addEvent(testEvent);
        */

    }

    public static void usage(){
        HelpFormatter formatter = new HelpFormatter();
        StartupOptions startupOptions = new StartupOptions();
        Options cmdOptions = startupOptions.getOptions();

        formatter.printHelp( "main", cmdOptions, true );
    }




}
