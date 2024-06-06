package com.cbfacademy.apiassessment.GratitudeJournalingApi;
import java.util.List;
import java.util.UUID;


public interface GratitudeEntryRepository extends ListCrudRepository<GratitudeEntry, UUID> { 
    
        List<GratitudeEntry> searchByEntryId(UUID entryId); //Question
        
        List<GratitudeEntry> searchByCreated(String created);// return entry that matches date create

        List<GratitudeEntry> searchByTopic(String topic);
    
    }
    

