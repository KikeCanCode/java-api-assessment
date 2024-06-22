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
    
    // Algorithm - Sorted 

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
    
    public void swap(GratitudeEntry[] entryArray, int leftIndex, int rightIndex) {
        GratitudeEntry temp = entryArray[leftIndex];
        entryArray[leftIndex] = entryArray[rightIndex];
        entryArray[rightIndex] = temp;
    }
}
   

