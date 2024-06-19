# API Assessment 

## Name of project: Gratitude Jounal API 

### Description
The Journalling API is a RESTful service that allows users to to log their daily moments of gratitude and manage their journal entries. Users can create, read/retrieve their gratitude entries for reflection, update, and delete their journal entries. 
This document provides an overview of the API endpoints and how to use them.

### The Purpose of the Gratitude Journaling API
The API provides a structured way to interact with the backend database, allowing for the creation, reading, updating, and deletion (CRUD) of gratitude journal, as well as search for entries and sort the entries by topic and location. 

### Functional Requirements 
 The Gratitude Journaling API allows users to perform the following operations:
  
  1. Create a gratitude entry.
  2. Read gratitude entry
  3. Update a gratitude entry.
  4. Delete a gratitude entry.

## Getting Started
To start using the Journaling API, follow the steps below:

### Prerequisites
- Java 11 or higher
- Maven 3.6.0 or higher
- A running instance of a database (e.g., MySQL)

### Installation - Question 
Clone the repository:

git clone https://github.com/your-username/gratitudejournalingaapi.git
cd gratitudejournalingapi

Configure your database connection in src/main/resources/application.properties:

```
spring.datasource.url=jdbc:mysql://localhost:3306/gratitudejournalingapi
spring.datasource.username=root
spring.datasource.password=***** 
spring.jpa.hibernate.ddl-auto=update
```
Build and run the application using Maven:
Install Dependencies
```
    ./mvnw clean dependency:resolve
```
 Running the Application    
```
    ./mvn spring-boot:run
```
The API will be available a https//localhost.8080.

### Usage
Connect to the API using Postman on port 8080.

### Api request methods testing in Postman

API endpoints: This is a list of all created endpoints and expected responses.

| Method   | URL                              | Action                   |
| -------- | ---------------------------------| --------------------------------|
| `POST`   | `/api/gratitudeentry`            | Add a GratitudeEntry            |
| `GET`    | `/api/gratitudeentry`            | Get all GratitudeEntry          |
| `GET`    | `/api/gratitudeentry/{id}`       | Get a GratitudeEntry by id      |
| `PUT`    | `/api/gratitudeentry/{id}`       | Update a GratitudeEntry by Id   |
| `DELETE` | `/api/gratitudeentry/{id}`       | Delete a GratitudeEntry by id   |

###  A representative HTTP response will look something like this:
``` JSON 
{  
"userName": "radiance_de_dieu",
"content": "I'm grateful for successfully passed all EndPoints on Postman.",
"created": "2024-05-30T08:30:00Z",
"updated": "2024-05-30T08:30:00Z",
"location": "Birmingham, UK",
"topic": "Achievement"
}
```
### Search Algorithm - Sorted list
The Gratitude Journaling Api will provide search functionality to enhance user experience and accessibility. Specifically, the API will support search capabilities that allow users to query their gratitude entries based on specific criteria such as entry content, topics, and date. 

Users can search by entry content to find specific words or phrases within their journal entries, making it easy to locate particular moments or reflections. The search by topic feature enables users to filter entries based on predefined or user-defined tags or categories, facilitating the organisation and retrieval of entries related to specific themes (e.g., "family", "achievements", "health"). 

### A respresentative of how a saerch algorithm will look like:

| Method   | URL                                                        | Description                       | Key               | value     |
| -------- | -----------------------------------------------------------|-----------------------------------|-------------------|-----------|
| `GET`    | `/api/gratitudeentry/search-by-topic?topic=health`         | Search GratitudeEntry by topic    |Topic              | Health    |
| `GET`    | `/api/gratitudeentry/search-by-location?location=New+york` | Search GratitudeEntry by location |Location           |New York
| `GET`    | `/api/gratitudeentry/{id}`             | Get a GratitudeEntry by id      |
| `GET`    | `/api/gratitudeentry/{id}`             | Update a GratitudeEntry by Id   |
| `GET`    | `/api/gratitudeentry/{id}`             | Delete a GratitudeEntry by id   |



## Issues and Challenges

### Technologies Used
