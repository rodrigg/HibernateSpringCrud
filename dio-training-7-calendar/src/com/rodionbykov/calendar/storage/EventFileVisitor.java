package com.rodionbykov.calendar.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import com.rodionbykov.calendar.Event;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Created by Rodion Bykov on 01.06.2014.
 */
public class EventFileVisitor extends SimpleFileVisitor<Path> {

        private PathMatcher matcher;
        private ArrayList<Event> events = new ArrayList<Event>();

        // Compares the glob pattern against
        // the file or directory name.
        public void find(Path file) {
            Path name = file.getFileName();
            PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.xml");

            if (name != null && matcher.matches(name)) {

                try {
                    JAXBContext jc = JAXBContext.newInstance(EventAdapter.class);
                    Unmarshaller u = jc.createUnmarshaller();
                    EventAdapter element = (EventAdapter) u.unmarshal( file.toFile() );
                    events.add(element.getEvent());
                }catch(JAXBException e){
                    System.err.println(e);
                }

            }
        }

        // Prints the total number of
        // matches to standard out.
        public ArrayList<Event> getEvents() {
            return events;
        }

        // Invoke the pattern matching
        // method on each file.
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            find(file);
            return FileVisitResult.CONTINUE;
        }

        // Invoke the pattern matching
        // method on each directory.
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            find(dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.err.println(exc);
            return FileVisitResult.CONTINUE;
        }

}
