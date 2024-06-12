package com.cbfacademy.apiassessment.GratitudeJournalingApi;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

// Get GrattitudeEntry by entry id 
@GetMapping("/{id}") //("/{created}")// Get GratitudeEntry by user id? or something else?

    public ResponseEntity <GratitudeEntry> getGratitudeEntry(@PathVariable UUID id) {
    //public ResponseEntity <GratitudeEntry> getGratitudeEntry(@PathVariable String created) {
        try {
            return new ResponseEntity<>(gratitudeEntryService.getGratitudeEntry(id),HttpStatus.OK);
        } catch (NoSuchElementException noSuchElementException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

// Put

//Delete

}
