# API Assessment 
## Name of project: Gratitude Jounaling API 
### Description
The Journalling API is a RESTful service that allows users to to log their daily moments of gratitude manage their journal entries. Users can create, read/retrieve their gratitude entries for reflection, update, and delete journal entries. This document provides an overview of the API endpoints and how to use them.

 ### The Purpose of the Gratitude Journaling API
The API provides a structured way to interact with the backend database, allowing for the creation, reading, updating, and deletion (CRUD) of gratitude journal, search for entries as well as sorting entries by date. 

### Functional Requirements 
 The Gratitude Journaling API allows users to perform the following operations:
  
  1. Create a gratitude entry: Add a new entry to the journal.
  2. Read gratitude entries: Retrieve existing entries from the journal.(search/read).
  3. Update a gratitude entry: Modify an existing entry.
  4. Delete a gratitude entry: Remove an entry from the journal
 add example of path

### Request methods testing in Postman
Methods that defines endpoints for the following operations:

| Method   | URL                              | Description                     |
| -------- | ---------------------------------| --------------------------------|
| `POST`   | `/api/gratitudeentry`            | Add a GratitudeEntry            |
| `GET`    | `/api/gratitudeentry`            | Get all GratitudeEntry          |
| `GET`    | `/api/gratitudeentry/{id}`       | Get a GratitudeEntry by id      |
| `PUT`    | `/api/gratitudeentry/{id}`       | Update a GratitudeEntry by Id   |
| `DELETE` | `/api/gratitudeentry/{id}`       | Delete a GratitudeEntry by id   |

###  A representative HTTP response will look something like this:
``` JSON 
{  
"userName": "kike Dare",
"content": "I'm grateful for successfully passed Put EndPoints on Postman. All EndPoints OK",
"created": "2024-05-30T08:30:00Z",
"updated": "2024-05-30T08:30:00Z",
"location": "Birmingham, UK",
"topic": "Achievement/Career"
}
```
### Algorithm
The Gratitude Journaling Api will provide search functionality to enhance user experience and accessibility. Specifically, the API will support search capabilities that allow users to query their gratitude entries based on specific criteria such as entry content, topics, and date. 

Users can search by entry content to find specific words or phrases within their journal entries, making it easy to locate particular moments or reflections. The search by topic feature enables users to filter entries based on predefined or user-defined tags or categories, facilitating the organisation and retrieval of entries related to specific themes (e.g., "family", "achievements", "health"). 

Additionally, the API will allow searches by date, enabling users to find entries from a particular day, month, or date range. This functionality is designed to help users easily navigate and reflect on their journaling history, providing a comprehensive tool for personal reflection and growth.

### A respresentative of how a saerch algorithm will look like:

| Method   | URL                                                        | Description                       | Key               | value     |
| -------- | -----------------------------------------------------------|-----------------------------------|-------------------|-----------|
| `GET`    | `/api/gratitudeentry/search-by-topic?topic=health`         | Search GratitudeEntry by topic    |Topic              | Health    |
| `GET`    | `/api/gratitudeentry/search-by-location?location=New+york` | Search GratitudeEntry by location |Location           |New York
| `GET`    | `/api/gratitudeentry/{id}`             | Get a GratitudeEntry by id      |
| `GET`    | `/api/gratitudeentry/{id}`             | Update a GratitudeEntry by Id   |
| `GET`    | `/api/gratitudeentry/{id}`             | Delete a GratitudeEntry by id   |


### Getting Started
To start using the Journaling API, follow the steps below:

### Prerequisites
Java 11 or higher
Maven 3.6.0 or higher
A running instance of a database (e.g., MySQL, PostgreSQL)

### Installation
Clone the repository:

git clone https://github.com/your-username/gratitudejournalingaapi.git
cd gratitudejournalingapi

Configure your database connection in src/main/resources/application.properties:

```
spring.datasource.url=jdbc:mysql://localhost:3306/gratitudejournalingapi
spring.datasource.username=root
spring.datasource.password=Myjournal 
spring.jpa.hibernate.ddl-auto=update
```
Build and run the application using Maven:

```
./mvn clean install
./mvn spring-boot:run

```
The API will be available a https//localhost.8080.


### Issues and Challenges

### Database Configuration

Misconfiguration of the database can lead to connection failures. 
Ensure that the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` values are correctly set in the `application.properties` file. 

Example:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/journaling
spring.datasource.username=root
spring.datasource.password=yourpassword

```

