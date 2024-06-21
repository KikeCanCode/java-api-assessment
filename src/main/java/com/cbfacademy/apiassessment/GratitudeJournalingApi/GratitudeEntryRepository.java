package com.cbfacademy.apiassessment.GratitudeJournalingApi;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;


public interface GratitudeEntryRepository extends ListCrudRepository<GratitudeEntry, UUID> { 
    
        List<GratitudeEntry> searchByEntryId(UUID entryId); 
        
        List<GratitudeEntry> searchByCreated(Instant created);

        List<GratitudeEntry> searchByTopic(String topic);

        //List<GratitudeEntry> findGratitudeEntryByTopic(String topic);

    }
    

