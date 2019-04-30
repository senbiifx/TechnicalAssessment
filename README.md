# TechnicalAssessment

## Class Diagram
![Alt text](TechAssessmentUML.png?raw=true "Class Diagram")

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
