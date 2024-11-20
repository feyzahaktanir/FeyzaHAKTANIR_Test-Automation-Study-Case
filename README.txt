Project README


Overview
---------
This project is an API automation testing framework that uses Gauge, RestAssured, and TestNG to test user creation functionality via a REST API.
&&

Technologies & Versions
-----------------------
Gauge: Version 0.11.1 – BDD framework for test automation.
RestAssured: Version 5.3.0 – For API testing and validation.
TestNG: Version 7.7.0 – For running the test suite.
PostgreSQL JDBC Driver: Version 42.6.0 – For database interaction.
Jackson: Version 2.16.0 – For JSON parsing.
JUnit: Version 5.9.2 – For assertions.
Maven: For project and dependency management.
&&

Project Structure
------------------
stepDefinitions: Contains step definitions for test scenarios.
requests: Handles API requests (e.g., POST_CreateUser).
utilities: Includes helper classes for request handling, response storage, and configuration setup.
&&

Setup & Running Tests
---------------------
Install Gauge: Follow the Gauge installation guide.
Maven: Run mvn clean install to install dependencies.
&&

Run Tests:
----------
Use Gauge: gauge run specs --tags success
Use Maven: mvn test
&&

Feyza HAKTANIR