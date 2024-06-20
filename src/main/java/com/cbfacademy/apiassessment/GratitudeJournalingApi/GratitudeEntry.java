package com.cbfacademy.apiassessment.GratitudeJournalingApi;
import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

    
@Entity    
@Table(name = "gratitudeentry") 

public class GratitudeEntry {  
       
@Id 
@GeneratedValue(strategy=GenerationType.UUID)
    
        private UUID entryId;           
        private String userName;       
        private String content;         
        private Instant created;        
        private Instant updated;        
        private String location;        
        private String topic;           
    
    public GratitudeEntry() {           
        this(null,null, Instant.now(), null, null);
        }

    public GratitudeEntry(String userName, String content, Instant created, String location, String topic) { 
        this.userName  = userName; 
        this.content = content;
        this.created = created;
        this.location = location;
        this.topic = topic;             
    }

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

    public void setEntryId(UUID entryId) {
        this.entryId = entryId;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

}  

