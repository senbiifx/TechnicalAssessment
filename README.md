# TechnicalAssessment 
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=senebii_TechnicalAssessment&metric=alert_status)](https://sonarcloud.io/dashboard?id=senebii_TechnicalAssessment)

UPDATED: Added REST APIs ```com.senebii.api```

## Class Diagram
![Alt text](TechAssessmentUML.png?raw=true "Class Diagram")

## REST APIs
https://documenter.getpostman.com/view/3485788/S1TSZzDe?version=latest


## JUnit Execution Result
![Alt text](junit.PNG?raw=true "Class Diagram")


## Coverage Test Execution Result
![Alt text](coverage.PNG?raw=true "Class Diagram")

## How to Run JUnit and Coverage Test
<b> Using Eclipse </b>
<br/>
Right click on your project in the Project Explorer then select "Coverage As" > "JUnit Test". Eclipse will run the test and generate a report about the Junit execution as well as the coverage result.
<br/>
<br/>
<b> Using Maven </b>
<br/>
1.) Install <a href="https://maven.apache.org/install.html">Maven</a>.
<br/>
2.) Go to the project directory, then run <code> mvn test </code>. Maven will run the test and generate  the Junit execution report. Coverage report will be generated at <code>PROJECT_DIRECTORY\target\site\jacoco</code>


## How to Run the Application
Go to the application root directory then run `mvn spring-boot:run` <br/>
Note: 
-> Customer Information is hardcoded in com.senebii.api.config.SessionInterceptor there is no implementation of login
-> Product listing is mocked in com.senebii.api.product.ProductRepositoryMockData.java
