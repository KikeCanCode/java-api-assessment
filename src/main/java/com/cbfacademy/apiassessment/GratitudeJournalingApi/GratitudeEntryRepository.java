
import java.util.List;
import java.util.UUID;  
import org.springframework.data.repository.ListCrudRepository;

public class GratitudeEntryRepository {

    public interface GratitudeEntryRepository extends ListCrudRepository<GratitudeEntryX, UUID> { 
    
        List<GratitudeEntryX> searchByEntryId(UUID entryId);
        
        List<GratitudeEntryX> searchByCreated(String created);// return entry that matches date create

        List<GratitudeEntryX> searchByTopic(String topic);
    
    }
    
}
