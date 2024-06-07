package com.cbfacademy.apiassessment.GratitudeJournalingApi;
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

    public GratitudeEntry updateGratitudeEntry(UUID id, GratitudeEntry updatedgraGratitudeEntry) throws NoSuchElementException{
        GratitudeEntry gratitudeEntry = gratitudeEntryRepository.findById(id).orElseThrow();
        gratitudeEntry.setContent(updatedgraGratitudeEntry.getContent());
        return gratitudeEntry;
    }


}
   


