package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            add(new GratitudeEntry("kike", "Dare", null, Instant.now(), null, null))
        }
        }
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
        when(gratitudeEntryService.getAllGratitudeEntry().thenReturn(defaultGratitudeEntry));
    }
    @Test
    @Description("POST /api/gratitudeentry creates new GratitudeEntry")
    void createdGratitudeEntry(){
        GratitudeEntry gratitudeEntry = createNewGratitudeEntry();

        when(gratitudeEntryService.createGratitudeEntry(any(GratitudeEntry.class))).thenAnswer(invocation -> setEntryId(invocation.getArgument(0)));
        
        ResponseEntity<GratitudeEntry> response = restTemplate.getStatusCode();
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getEntryId());
		verify(gratitudeEntryService).createGratitudeEntry(any(GratitudeEntry.class));

    }
    @Test
    


}
