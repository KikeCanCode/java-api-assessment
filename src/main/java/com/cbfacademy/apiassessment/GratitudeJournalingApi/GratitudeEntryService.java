package com.cbfacademy.apiassessment.GratitudeJournalingApi;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class GratitudeEntryService {
   

public GratitudeEntryRepository gratitudeEntryRepository;      

    public GratitudeEntryService(GratitudeEntryRepository gratitudeEntryRepository) {
        this.gratitudeEntryRepository = gratitudeEntryRepository; 
    }
    public GratitudeEntry createGratitudeEntry(GratitudeEntry createdGratitudeEntry) throws IllegalArgumentException, OptimisticLockingFailureException {
        return gratitudeEntryRepository.save(createdGratitudeEntry);   
    }

    public List<GratitudeEntry> getAllGratitudeEntry(){    
        return gratitudeEntryRepository.findAll();
    }

    public GratitudeEntry getGratitudeEntry(UUID entryId) throws NoSuchElementException {
        return gratitudeEntryRepository.findById(entryId).orElseThrow();
    }
        // To update an entry
    public GratitudeEntry updateGratitudeEntry(UUID entryId, GratitudeEntry updatedgraGratitudeEntry) throws NoSuchElementException{
        GratitudeEntry gratitudeEntry = gratitudeEntryRepository.findById(entryId).orElseThrow();
        gratitudeEntry.setContent(updatedgraGratitudeEntry.getContent());
        gratitudeEntry.setUserName(updatedgraGratitudeEntry.getUserName());
        gratitudeEntry.setUpdated(updatedgraGratitudeEntry.getUpdated());
        gratitudeEntry.setTopic(updatedgraGratitudeEntry.getTopic());
        gratitudeEntry.setLocation(updatedgraGratitudeEntry.getLocation());
        
        return gratitudeEntry;
    }

    public void deleteGratitudeEntry(UUID entryId) { 
        gratitudeEntryRepository.deleteById(entryId);
    }

    public List<GratitudeEntry> getGratitudeEntriesByTopic(String topic) {
        return gratitudeEntryRepository.findGratitudeEntryByTopicOrderByTopicAsc(topic);
    }
    /*public List<GratitudeEntry> sortGratitudeEntry(String topic) {
        List<GratitudeEntry> gratitudeEntries = getAllGratitudeEntry();
        gratitudeEntries.sort((entry1, entry2) -> entry1.getTopic().compareTo(entry2.getTopic()));
        return gratitudeEntries;*/

    

    // Algorithm search - Binary search - Sorted 

   /* public List<GratitudeEntry> sortGratitudeEntry(String topic) {
        
        List<GratitudeEntry> gratitudeEntries = getAllGratitudeEntry();
        GratitudeEntry[] entryArray = gratitudeEntries.toArray(new GratitudeEntry[gratitudeEntries.size()]);

            for (int i = 0; i < entryArray.length; i++) { 
                for (int g = 0; g < i ; g++) { 
                    if (entryArray[i].getTopic().compareTo(entryArray[g].getTopic()) > 0) { 
                        GratitudeEntry entry = entryArray[i];
                        entryArray[i] = entryArray[g];
                         entryArray[g] = entry;
                    }
                }
            }   
                return Arrays.asList(entryArray);
    }*/

   
}
   

