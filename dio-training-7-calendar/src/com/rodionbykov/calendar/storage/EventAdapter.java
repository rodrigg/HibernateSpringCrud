package com.rodionbykov.calendar.storage;

import com.rodionbykov.calendar.Event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@XmlRootElement(name = "event")
public class EventAdapter implements Serializable {

    private String id;
    private String title;
    private String description;
    private Date start;
    private Date end;
    private ArrayList<String> attendees;
    private String location;

    public EventAdapter() {

    }

    public EventAdapter(Event event) {
        this.id = event.getId().toString();
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.start = event.getStart();
        this.end = event.getEnd();
        this.location = event.getLocation();

        this.attendees = new ArrayList<String>();

        if (event.getAttendees() != null ) {
            for (String attendee : event.getAttendees()) {
                this.attendees.add(attendee);
            }

        }
    }

    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public ArrayList getAttendees() {
        return attendees;
    }

    public void setAttendees(ArrayList attendees) {
        this.attendees = attendees;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventAdapter)) return false;

        EventAdapter event = (EventAdapter) o;

        if (attendees != null ? !attendees.equals(event.attendees) : event.attendees != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (end != null ? !end.equals(event.end) : event.end != null) return false;
        if (!id.equals(event.id)) return false;
        if (location != null ? !location.equals(event.location) : event.location != null) return false;
        if (start != null ? !start.equals(event.start) : event.start != null) return false;
        if (!title.equals(event.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (attendees != null ? attendees.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", attendees=" + attendees +
                ", location='" + location + '\'' +
                '}';
    }

    public Event getEvent() {

        Event event = new Event();
        event.setId(UUID.fromString(this.getId()));
        event.setTitle(this.getTitle());
        event.setLocation(this.getLocation());
        event.setStart(this.getStart());
        event.setEnd(this.getEnd());
        event.setAttendees(this.getAttendees());
        event.setDescription(this.getDescription());

        return event;
    }
}
