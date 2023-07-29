package org.example.task9;

import java.time.LocalDateTime;

public class Event {
    private String name;
    private LocalDateTime date;
    private String description;
    private boolean isActive;

    public Event(String name, LocalDateTime date, String description, boolean isActive) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}