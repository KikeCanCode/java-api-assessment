import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class GratitudeEntryService {

public GratitudeEntryRepository gratitudeEntryRepository; 

    public GratitudeEntryService(GratitudeEntryRepository gratitudeEntryRepository) {
        this.gratitudeEntryRepository = gratitudeEntryRepository; 
    }
    public GratitudeEntry createGratitudeEntry(GratitudeEntry newEntry) throws IllegalArgumentException, OptimisticLockingFailureException {
        return gratitudeEntryRepository.save(gratitudeEntry);
    }

    public List<GratitudeEntryX> getAllGratitudeEntry(){
        return gratitudeEntryRepository.findAll();
    }

    public getGratitudeEntry(UUID entryId) throws NoSuchElementException {
        return gratitudeEntryRepository.findById(userId).orElseThrow();
    }

    public GratitudeEntry updateGratitudeEntry(UUID id, GratitudeEntry updatedgraGratitudeEntry) throws NoSuchElementException{
        GratitudeEntry gratitudeEntry = gratitudeEntryRepository.findById(id).orElseThrow();
        gratitudeEntry.setContent(updatedgraGratitudeEntry.getContent());
    }


}
   


