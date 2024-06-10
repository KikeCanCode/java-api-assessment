package com.cbfacademy.apiassessment.GratitudeJournalingApi;
import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// The model or Entity class
@Entity // Indicates that a particular class is an entity and should be mapped to a
@Table(name = "gratitudeentry") // Tells Hibernate to make a table out of this class

public class GratitudeEntry { // Class name     
@Id // schema = class in java
@GeneratedValue(strategy = GenerationType.UUID)
    
        private UUID entryId; // : A unique identifier for the entry.
        private String userName; // : The identifier for the user who created the entry.
        private String content; // : The text content of the gratitude entry.
        private Instant created; // : The timestamp when the entry was created.
        private Instant updated; // : The timestamp when the entry was last updated.
        private String location; // : The location of the events
        private String topic; // : relationships, career, health, hobbies, achievements, others.
    
        public GratitudeEntry(String content, Instant created, String location, String topic) { 
        this.content = content;
        this.created = created;
        this.location = location;
        this.topic = topic; // could be optional
    }

    // getters and setters

    public UUID getEntryId() {
        return entryId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}  
