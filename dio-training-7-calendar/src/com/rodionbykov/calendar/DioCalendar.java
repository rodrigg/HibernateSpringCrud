package com.rodionbykov.calendar;

import org.apache.commons.cli.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.text.SimpleDateFormat;
import java.util.*;

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

            if ( cmd.hasOption("find") ) {
                String[] values = cmd.getOptionValues("find");
                calendarService.listCalendar(values[0]);
            }

            if ( cmd.hasOption("date") ) {
                String[] values = cmd.getOptionValues("date");

                Date startDate = new Date();
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
                    String dateInString = values[0];
                    startDate = sdf.parse(dateInString);
                    calendarService.listCalendarByDate(startDate);
                }catch(java.text.ParseException e){
                    System.out.println("Cannot parse date");
                    throw new ParseException("");
                }
            }

            if ( cmd.hasOption("today") ) {
                calendarService.listCalendarByDate(new Date());
            }

            if ( cmd.hasOption("add") ) {
                String[] values = cmd.getOptionValues("add");

                if(!isInteger(values[2])){
                    System.out.println("Cannot parse duration, please enter number of minutes");
                    throw new ParseException("");
                }
                Date startDate = new Date();
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
                    String dateInString = values[0];
                    startDate = sdf.parse(dateInString);
                }catch(java.text.ParseException e){
                    System.out.println("Cannot parse date, please enter date as 2014-12-31 23:59:59");
                    throw new ParseException("");
                }

                Event newEvent = new Event();
                newEvent.setId( UUID.randomUUID() );
                newEvent.setTitle(values[1]);
                newEvent.setStart(startDate);
                newEvent.setDuration(Integer.parseInt(values[2]));
                calendarService.addEvent(newEvent);
            }

            if ( cmd.hasOption("delete") ) {
                String[] values = cmd.getOptionValues("delete");
                if(!isInteger(values[0])){
                    System.out.println("Cannot delete this event, please provide event position number");
                    throw new ParseException("");
                }else{
                    calendarService.deleteEventByPos(Integer.parseInt(values[0]));
                }
            }

            if ( cmd.getOptions().length == 0 || cmd.hasOption("help") ) {
                DioCalendar.usage();
            }

        }catch(ParseException e){
            DioCalendar.usage();
        }

    }

    public static void usage(){
        HelpFormatter formatter = new HelpFormatter();
        StartupOptions startupOptions = new StartupOptions();
        Options cmdOptions = startupOptions.getOptions();

        formatter.printHelp( "main", cmdOptions, true );
    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

}
