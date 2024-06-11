package com.cbfacademy.apiassessment.GratitudeJournalingApi;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;


public interface GratitudeEntryRepository extends ListCrudRepository<GratitudeEntry, UUID> { 
    
        List<GratitudeEntry> searchByEntryId(UUID entryId); //Question
        
        List<GratitudeEntry> searchByCreated(Instant created);// return entry that matches date create

        List<GratitudeEntry> searchByTopic(String topic);
    
    }
    

