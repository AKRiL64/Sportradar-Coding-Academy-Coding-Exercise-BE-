Project overview: 
-
This is a simple web application that allows users to see a calendar of events as well as add new ones.
Structure of the application is divided onto:
- Entities: Classes that represent tables
- Repositories: Interfaces that provide CRUD operations
- Services (only one): Class that provides logic for events
- Controllers (only one): Class that handles HTTP requests

Language for the backend: 
Java 17;

Backend Framework: 
Spring Boot 4.0.4;

Database: 
PostgreSQL 14.2;

ORM: 
JPA;

Frontend: 
HTML;



Assumptions:
-
- Application is assumed to be run on an environment where data persistence across restarts is not required,
  and starting with fresh sample data is preferred.
- Event consists of exactly two participants assigned specific roles: Home and Away.
- Team is rigidly associated with exactly one sport and one country.
- Frontend validation is not implemented, it is assumed the user will
  input correctly formatted data.
- The timeUTC field is an integer representing seconds since the start of the day

How to run this project:
-
- Clone the repository
- Ensure Java 17 is installed
- Ensure PostgreSQL is installed and runs on port 5432
- In psql or pgAdmin create a database called "sports_calendar" preferably inside the "postgres" user
- In 'src/main/resources/application.yaml' change spring: datasource: username: postgres
  and spring: datasource: password: admin
  to match your database credentials (for user "postgres" is default is no other users created)
- Run the application with 'gradlew.bat bootRun' in the project root directory
  or run SportradarExerciseBeApplication.java in some IDE (I used IntelliJ IDEA Ultimate)
- Open http://localhost:8080/events in browser
- There will be dummy data inserted from the data.sql file