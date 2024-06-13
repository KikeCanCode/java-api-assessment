package com.cbfacademy.apiassessment.GratitudeJournalingApi;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class GratitudeEntryService {

public GratitudeEntryRepository gratitudeEntryRepository;   // Instance of Repository class

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
       


}
   


