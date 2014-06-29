package com.rodionbykov.calendar;

import java.util.Comparator;

/**
 * Created by rodionbykov on 30.06.2014.
 */
public class EventComparator implements Comparator<Event> {

    @Override
    public int compare(Event event1, Event event2){
        return event1.getStart().compareTo(event2.getStart());
    }
}
