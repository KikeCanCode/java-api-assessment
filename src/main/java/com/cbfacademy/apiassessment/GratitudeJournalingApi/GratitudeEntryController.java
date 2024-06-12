package com.cbfacademy.apiassessment.GratitudeJournalingApi;
import java.util.List;
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
        // PostMapping - creates a new Gratitudeentry 
    @PostMapping
    public ResponseEntity<GratitudeEntry> createGratitudeEntry(@RequestBody GratitudeEntry createdgratitudeEntry) {
        GratitudeEntry createdGratitudeEntry = gratitudeEntryService.createGratitudeEntry(createdgratitudeEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGratitudeEntry);
    }

        // GetMapping - retrive a GrattitudeEntry by entry id 
    @GetMapping("/{entryId}") //("/{created}")// Get GratitudeEntry by user id? or something else?

    public ResponseEntity<GratitudeEntry> getGratitudeEntry(@PathVariable UUID entryId) {
        //public ResponseEntity <GratitudeEntry> getGratitudeEntry(@PathVariable String created) {
        try {
            return new ResponseEntity<>(gratitudeEntryService.getGratitudeEntry(entryId), HttpStatus.FOUND);
        } catch (NoSuchElementException noSuchElementException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

        //GetMaaping - retrives all GrattitudeEntry
    @GetMapping 
    public List<GratitudeEntry> getAllGratitudeEntry() {
        return gratitudeEntryService.getAllGratitudeEntry();
    }

        // Put - To update a GratitudeEntry 
    public ResponseEntity<GratitudeEntry> updateGratitudeEntry(@PathVariable UUID userId, @RequestBody GratitudeEntry updatedGratitudeEntry) {
        try {
            GratitudeEntry updatedgratitudeEntry = gratitudeEntryService.updateGratitudeEntry(userId, updatedGratitudeEntry);
                return ResponseEntity.status(HttpStatus.RESET_CONTENT).body(updatedgratitudeEntry);    
            } catch (NoSuchElementException noSuchElementException) { // when an element cannot be found.
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
            }
    }

//Delete

}
