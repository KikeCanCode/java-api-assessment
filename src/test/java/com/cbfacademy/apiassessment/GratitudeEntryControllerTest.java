package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.util.UriComponentsBuilder;

import com.cbfacademy.apiassessment.GratitudeJournalingApi.GratitudeEntry;
import com.cbfacademy.apiassessment.GratitudeJournalingApi.GratitudeEntryService;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class GratitudeEntryControllerTest {

    @LocalServerPort 
    private int port;
    private URI baseURI;

    @Autowired
    private TestRestTemplate restTemplate;
    private List<GratitudeEntry> defaultGratitudeEntry = new ArrayList<>() {
        {
            add(new GratitudeEntry("Rebecca", "I am gratful for a sunny day", Instant.now(), "Birmingham", "Health"));
            add(new GratitudeEntry("Rebecca", "I am gratful for a my family", Instant.now(), "Birmingham", "Family"));
            add(new GratitudeEntry("Kenneth", "I am gratful for passing my Maths exam", Instant.now(), "Spain", "Achievements"));
        
        }
    };

   @MockBean
    private GratitudeEntryService gratitudeEntryService;

    @BeforeEach
    void setUp() throws RuntimeException {
        this.baseURI = UriComponentsBuilder.newInstance()
            .scheme("http")
            .host("localhost")
            .port(port)
            .path("api/gratitudeentry")
            .build()
            .toUri();

        when(gratitudeEntryService.getAllGratitudeEntry()).thenReturn(defaultGratitudeEntry);
    }
    @Test
    @Description("POST /api/gratitudeentry creates new GratitudeEntry")
    void createdGratitudeEntry(){
        // Arrange
        GratitudeEntry gratitudeEntry = createNewEntry(); //createGratitudeEntry();

        when(gratitudeEntryService.createGratitudeEntry(any(GratitudeEntry.class))).thenAnswer(invocation -> setEntryId(invocation.getArgument(0)));
        // Act
        ResponseEntity<GratitudeEntry> response = restTemplate.postForEntity(baseURI.toString(), gratitudeEntry, GratitudeEntry.class);
        
        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getEntryId());
		verify(gratitudeEntryService).createGratitudeEntry(any(GratitudeEntry.class));

    }

    @Test
    @Description("GET /api/gratitudeentry returns all GratitudeEntry")
    void getAllGratitudeEntry() throws URISyntaxException {
        // Act 
    ResponseEntity<List<GratitudeEntry>> response = restTemplate.exchange(baseURI, HttpMethod.GET, null, 
        new ParameterizedTypeReference<List<GratitudeEntry>>() {});
    
    List<GratitudeEntry> reponseGratitudeEntries = response.getBody();

    // Assert 
    assertEquals((HttpStatus.OK), response.getStatusCode());
    assertNotNull(reponseGratitudeEntries);
    assertEquals(defaultGratitudeEntry.size(), reponseGratitudeEntries.size());
    verify(gratitudeEntryService).getAllGratitudeEntry();
           
    }
@Test
@Description("GET /api/gratitudeentry/{id} returns 404 for invalid IOU")
	void getInvalidGratitudeEntry() {
		// Arrange
		GratitudeEntry gratitudeEntry = createNewEntry(); // createGratitudeEntry();
		URI endpoint = getEndpoint(gratitudeEntry);

		when(gratitudeEntryService.getGratitudeEntry(any(UUID.class))).thenThrow(NoSuchElementException.class);

		// Act
		ResponseEntity<GratitudeEntry> response = restTemplate.getForEntity(endpoint, GratitudeEntry.class);

		// Assert
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		verify(gratitudeEntryService).getGratitudeEntry(gratitudeEntry.getEntryId());
	}

    private GratitudeEntry selectRandomGratitudeEntry() {
        int randomIndex = new Random().nextInt(defaultGratitudeEntry.size());
        return setEntryId(defaultGratitudeEntry.get(randomIndex));
    }
    private GratitudeEntry createNewEntry() {
        return setEntryId(new GratitudeEntry("Rebecca", "I am gratful for a sunny day", Instant.now(), "Birmingham", "Health"));
    }
    private URI getEndpoint(GratitudeEntry gratitudeEntry){
        return appendPath(baseURI, gratitudeEntry.getEntryId().toString());

    }
    private Instant geInstant(int hoursToSubtract){     //Get the current date and time in the system's default time zone

        ZoneId systemTimeZone = ZoneId.systemDefault(); 
        ZonedDateTime currentDateTime = ZonedDateTime.now(systemTimeZone);
        // Subtract the specified number of hours using Duration
        Duration duration = Duration.ofHours(hoursToSubtract);
        ZonedDateTime resulDateTime = currentDateTime.minus(duration);
        // Convert to Instant
        Instant instant = resulDateTime.toInstant();
        return instant;
    }
    private URI appendPath(URI uri, String path) {
        return UriComponentsBuilder.fromUri(uri).pathSegment(path).build().encode().toUri();
    }
    private static GratitudeEntry setEntryId(GratitudeEntry gratitudeEntry) {
        ReflectionTestUtils.setField(gratitudeEntry, "entryId", UUID.randomUUID());
        return gratitudeEntry;

    }
    
}
    
