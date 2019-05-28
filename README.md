# TechnicalAssessment 
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=senebii_TechnicalAssessment&metric=alert_status)](https://sonarcloud.io/dashboard?id=senebii_TechnicalAssessment)

UPDATED: Added REST APIs ```com.senebii.api```
## REST APIs
<div class="stackedit__html"><p><strong>Product Listing</strong><br>
GET <code>/product/list</code></p>
<pre><code>
Response:
{
    "data": [
        {
            "id": 1,
            "price": 100,
            "productType": "GROCERY"
        }
     ],
    "response": "SUCCESS"
}
</code></pre>
<p><strong>Get Items in Cart</strong><br>
GET <code>/cart/list</code></p>
<pre><code>
Response:
{
    "data": [
        {
            "id": 1,
            "product": {
                "id": 2,
                "price": 90,
                "productType": "GROCERY"
            },
            "quantity": 25
        }
    ],
    "response": "SUCCESS"
}
</code></pre>
<p><strong>Add Items to Cart</strong><br>
POST <code>/cart/add</code></p>
<pre><code>
Request Body:
{
	"productId": 2,
	"quantity": 25
}

Response:
{
    "response": "SUCCESS"
}
</code></pre>
<p><strong>Update Item</strong><br>
POST <code>/cart/save/{id}</code></p>
<pre><code>
Request Body:
{
	"productId": 2,
	"quantity": 25
}

Response:
{
    "response": "SUCCESS"
}
</code></pre>
<p><strong>Delete Item from Cart</strong><br>
POST <code>/cart/delete/{id}</code></p>
<pre><code>
Response:
{
    "response": "SUCCESS"
}
</code></pre>
<p><strong>Get Bill</strong><br>
GET <code>/cart/bill</code></p>
<pre><code>
Response:
{
    "data": {
        "total": 2250,
        "discount": 110,
        "netPayableAmount": 2140
    },
    "response": "SUCCESS"
}
</code></pre>
</div>


## Class Diagram
![Alt text](TechAssessmentUML.png?raw=true "Class Diagram")


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
Note: <br/>
-> Customer Information is hardcoded in `com.senebii.api.config.SessionInterceptor` since there is no implementation of login<br/>
-> Product listing is mocked in com.senebii.api.product.ProductRepositoryMockData.java<br/>
