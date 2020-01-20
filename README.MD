#Read Me first 
Spring Boot Gradle Project with Spring JPA and H2 DB

THe database used is inMemory meaning all the updates performed is valid for the session app ran.
The DB is created with Employee table created automatically by Spring JPA.
The employee table is then inserted with some sample data define in src/main/resources/data.sql file - Spring JPA does it automatically


To run the app:
1. Import the project in the Eclipse (Install Buildship gradle plugin if gradle is not shown as option in import )
2. Refresh the project: Right Click on Project Structure > Gradle > Refresh Gradle Project
3. Run com.entity.validator.validaorpoc.ValidaorPocApplication.java as Java Application



Rest Endpoint:
1. To get user by Name:
GET - http://localhost:9000/employee/name/{name}
example: http://localhost:9000/employee/name/Soumitra      where Soumitra is one of the user inserted by data.sql

2. To get user by Email:
GET - http://localhost:9000/employee/email/{email}
example:http://localhost:9000/employee/email/liton@email.com   where liton@email.com is one the user email inserted by data.sql

3. Update/Insert User:
POST- http://localhost:9000/employee/update
Request body type: application/json  (select option in body in Rest Client)
Request body:
{
"id": 5,                                                             //optional if its insert. Provided for Update
"name": "abc mishra",
"email": "abc1@yahoo.com"
}





Validation API:

All insert and update for employee is validated and only insert if all the Javax Validation is passed 
The validation is enforced in two ways:
a. Annotated to each property using @Size annotation which takes min, max and message value to initialize

b. A transient, Json ignored method annotated with @AssertTrue method.
	The method will have access to all attribute and can be used for validating which uses more than one field or if has a child object attached to it.  
