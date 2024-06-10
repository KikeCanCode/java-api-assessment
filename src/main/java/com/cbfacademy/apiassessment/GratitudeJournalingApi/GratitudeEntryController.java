package com.cbfacademy.apiassessment.GratitudeJournalingApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/gratitudeentry")

public class GratitudeEntryController {

    @Autowired

    public GratitudeEntryService gratitudeEntryService; // Instance of the service class

    public GratitudeEntryController(GratitudeEntryService gratitudeEntryService){ 
        this.gratitudeEntryService = gratitudeEntryService;
    }
    //Get Post 
    
    @PostMapping
    public ResponseEntity<GratitudeEntry> createGratitudeEntry(@RequestBody GratitudeEntry createdgratitudeEntry) {
        GratitudeEntry createdGratitudeEntry = gratitudeEntryService.createGratitudeEntry(createdgratitudeEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGratitudeEntry);
    }

// Get 

// Put

//Delete

}
