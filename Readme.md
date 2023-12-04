# Spring Boot Registration Application

## Overview
This is a Spring Boot application developed using Java 17 and Gradle. It features a user registration system, with a simple web interface for user data input and persistence in a MySQL database.

## Prerequisites
- **Java 17**: Ensure Java 17 is installed on your system.
- **Gradle**: Required for dependency management and project execution.
- **MySQL Database**: The application is set up to use MySQL, but it can be adapted to use other databases.

## Configuration
Before running the application, configure your database settings in the `application.properties` file located in `src/main/resources`. Adjust the following properties to match your database setup:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
