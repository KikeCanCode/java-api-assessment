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
        List<GratitudeEntry> gratitudeEntries = gratitudeEntryRepository.findAll();
        GratitudeEntry[] entryArray = gratitudeEntries.toArray(new GratitudeEntry[gratitudeEntries.size()]);
        sort(entryArray, 0, entryArray.length - 1);
        return Arrays.asList(entryArray);
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
        return gratitudeEntryRepository.searchByTopic(topic);
    }
    /*public List<GratitudeEntry> sortGratitudeEntry(String topic) {
        List<GratitudeEntry> gratitudeEntries = getAllGratitudeEntry();
        gratitudeEntries.sort((entry1, entry2) -> entry1.getTopic().compareTo(entry2.getTopic()));
        return gratitudeEntries;*/

    

    // Algorithm search - Binary search - Sorted 

   /*  public List<GratitudeEntry> sortGratitudeEntry(String topic) {
        
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

   
  /*   public List<GratitudeEntry> sortEntries() {
        List<GratitudeEntry> gratitudeEntries = gratitudeEntryRepository.findAll();
        GratitudeEntry[] entryArray = gratitudeEntries.toArray(new GratitudeEntry[gratitudeEntries.size()]);
        sort(entryArray, 0, entryArray.length - 1);
        return Arrays.asList(entryArray);
    }*/
    
    
    public void sort(GratitudeEntry[] entryArray, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = partition(entryArray, startIndex, endIndex);
            sort(entryArray, startIndex, pivotIndex - 1);
            sort(entryArray, pivotIndex + 1, endIndex);
        }
    }
    
    public int partition(GratitudeEntry[] entryArray, int startIndex, int endIndex) {
        GratitudeEntry pivot = entryArray[endIndex];
        int boundaryIndex = startIndex - 1;
    
        for (int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) {
            if (entryArray[currentIndex].getTopic().compareTo(pivot.getTopic()) <= 0) {
                boundaryIndex = boundaryIndex + 1;
                swap(entryArray, boundaryIndex, currentIndex);
            }
        }
        swap(entryArray, boundaryIndex + 1, endIndex);
        return boundaryIndex + 1;
    }
    
    public void swap(GratitudeEntry[] entries, int leftIndex, int rightIndex) {
        GratitudeEntry temp = entries[leftIndex];
        entries[leftIndex] = entries[rightIndex];
        entries[rightIndex] = temp;
}
}
   

