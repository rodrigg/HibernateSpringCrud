package com.rodionbykov.calendar.storage;

import com.rodionbykov.calendar.Event;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@XmlRootElement(name = "event")
public class EventAdapter implements Serializable {

    private String id;
    private String title;
    private Date start;
    private int duration;

    public EventAdapter() {

    }

    public EventAdapter(Event event) {
        this.id = event.getId().toString();
        this.title = event.getTitle();
        this.start = event.getStart();
        this.duration = event.getDuration();
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

    @XmlElement(name = "start")
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    @XmlElement(name = "duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Event getEvent() {

        Event event = new Event();
        event.setId(UUID.fromString(this.getId()));
        event.setTitle(this.getTitle());
        event.setStart(this.getStart());
        event.setDuration(this.getDuration());

        return event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventAdapter that = (EventAdapter) o;

        if (duration != that.duration) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + duration;
        return result;
    }

    @Override
    public String toString() {
        return "EventAdapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", duration=" + duration +
                '}';
    }

}
