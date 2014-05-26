package com.rodionbykov.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Event {

    private UUID id;
    private String title;
    private String description;
    private Date start;
    private Date end;
    private ArrayList attendees;
    private String location;

    public Event() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

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
}
