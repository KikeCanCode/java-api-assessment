package com.cbfacademy.apiassessment.GratitudeJournalingApi;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.websocket.server.PathParam;

@RestController     
@RequestMapping(path = "/api/gratitudeentry")   

public class GratitudeEntryController {

    @Autowired      

    public GratitudeEntryService gratitudeEntryService;    

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
    @GetMapping("/{entryId}") 
    public ResponseEntity<GratitudeEntry> getGratitudeEntry(@PathVariable UUID entryId) { 
        try {
            return new ResponseEntity<>(gratitudeEntryService.getGratitudeEntry(entryId), HttpStatus.FOUND);
        } 
        catch (NoSuchElementException noSuchElementException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
      
    }
        //GetMaaping - retrives all GrattitudeEntry
    @GetMapping 
    public List<GratitudeEntry> getAllGratitudeEntry() {
        return gratitudeEntryService.getAllGratitudeEntry();
    }

        // Put - To update a GratitudeEntry 
        @PutMapping("/{entryId}")
    public ResponseEntity<GratitudeEntry> updateGratitudeEntry(@PathVariable UUID entryId, @RequestBody GratitudeEntry updatedGratitudeEntry) {
        try {
            GratitudeEntry updatedgratitudeEntry = gratitudeEntryService.updateGratitudeEntry(entryId, updatedGratitudeEntry);
                return ResponseEntity.status(HttpStatus.OK).body(updatedgratitudeEntry);    // used RESET_Content initially just to see what will the reult be in Postman - No content was printed
        } 
        catch (NoSuchElementException noSuchElementException) { 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //Delete - deletes an entry by id
    @DeleteMapping("/{entryId}")

    public ResponseEntity<Void> deleteGratitudeEntry(@PathVariable UUID entryId) {
        try {
            gratitudeEntryService.getGratitudeEntry(entryId);
            gratitudeEntryService.deleteGratitudeEntry(entryId);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } 
        catch (IllegalArgumentException | NoSuchElementException exception) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        }
    // Algorithms earch - 

    @GetMapping("/sortbytopic")
    public ResponseEntity<List<GratitudeEntry>> getGratitudeEntriesByTopic(@RequestParam String topic) {
        List<GratitudeEntry> gratitudeEntries = gratitudeEntryService.getGratitudeEntriesByTopic(topic);
        return ResponseEntity.ok(gratitudeEntries);

    }
}















    
   /*@GetMapping("/sortByTopic")
    public ResponseEntity<List<GratitudeEntry>> sortByTopic(@RequestParam String topic) {
        List<GratitudeEntry> results = gratitudeEntryService.sortGratitudeEntry(topic);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }*/

    /*@GetMapping("/sortbytopic")
    @Query("SELECT g FROM GratitudeEntry g ORDER BY g.topic")
    public ResponseEntity<List<GratitudeEntry>> sortGratitudeEntries(@RequestParam String topic) {
        List<GratitudeEntry> sortedEntries = gratitudeEntryService.sortGratitudeEntry(topic);
        return new ResponseEntity<>(sortedEntries, HttpStatus.OK);
    }*/
 /*@GetMapping("/sortbytopic")
public ResponseEntity<String> sortByTopic(@RequestParam String sortbytopic) {
    // Implementation for sorting by topic
   return ResponseEntity.ok().body(sortbytopic);
    //return ResponseEntity.status(HttpStatus.OK).body(sortbytopic);
}*/



