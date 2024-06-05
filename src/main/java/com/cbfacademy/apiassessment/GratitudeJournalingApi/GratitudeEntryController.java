
@RestController
@RequestMapping(path = "/api/gratitudeentry")

public class GratitudeEntryController {

    @Autowired

    public GratitudeEntryX gratitudeEntry; // Instance of the service class

    public GratitudeEntryController(GratitudeEntryService gratitudeEntryService){ 
        this.gratitudeentryService = gratitudeentryService;
    }

}
