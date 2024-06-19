package com.cbfacademy.apiassessment.GratitudeJournalingApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class GratitudeEntryService {
   

public GratitudeEntryRepository gratitudeEntryRepository;       // Instance of Repository class

    public GratitudeEntryService(GratitudeEntryRepository gratitudeEntryRepository) {
        this.gratitudeEntryRepository = gratitudeEntryRepository; 
    }
    public GratitudeEntry createGratitudeEntry(GratitudeEntry createdGratitudeEntry) throws IllegalArgumentException, OptimisticLockingFailureException {
        return gratitudeEntryRepository.save(createdGratitudeEntry);    // createed GratitudeEntry
    }

    public List<GratitudeEntry> getAllGratitudeEntry(){     // retrive all entries
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

    public void deleteGratitudeEntry(UUID entryId) { // To delete an entry by id
        gratitudeEntryRepository.deleteById(entryId);
    }

    // Algorithm search - Binary search - Sorted 

    public List<GratitudeEntry> sortGratitudeEntry(String topic) {
        List<GratitudeEntry> gratitudeEntries = getAllGratitudeEntry();
        GratitudeEntry[] entryArray = gratitudeEntries.toArray(new GratitudeEntry[gratitudeEntries.size()]);

        for (int i = 0; i < entryArray.length; i++) { // for each entry in list - take 1st elmt in array compare to each elmts and see 
            for (int g = 0; g < i ; g++) { 
                if (entryArray[i].getTopic().compareTo(entryArray[g].getTopic()) > 0) { 
                    GratitudeEntry entry = entryArray[i];
                    entryArray[i] = entryArray[g];
                    entryArray[g] = entry;
                }
            }
        }   
                return Arrays.asList(entryArray);
    }
    
        

    

		


   /*public List<GratitudeEntry>gratitudeEntries; // field declaration 
        public GratitudeEntryService() { // constructor to initialise list
        this.gratitudeEntries = new ArrayList<>(); // 

        }*/
    // Method to sort entries by createdDate


   /*  public List<GratitudeEntry> getAllGratitudeEntrySorted (){
        // create a stream from the gratitudeentry list
        Stream<GratitudeEntry> entryStream = gratitudeEntries.stream();
        // Sort the stream by the createdDate field
        Stream<GratitudeEntry> sortedStream = 

        return sortedEntries;

    }*/
//Stream<T> sorted(Comparator<? super T> comparator) 
//https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/java/util/stream/Stream.html

}
   


