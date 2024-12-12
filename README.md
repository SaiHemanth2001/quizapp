This is a Spring Boot-based Quiz API project that provides several endpoints to interact with quiz questions. The database used is an in-memory H2 database.

**Running the Application**
Download the ZIP file through Git and extract it.
Import the extracted application into an IDE like Eclipse (ensure that Eclipse has Spring Boot installed).
Run the application.
Open the H2 Database Console at http://localhost:8080/h2-console.
Configure the connection using the following credentials:
JDBC URL: jdbc:h2:mem:h2db
Username: user
Password: password
Click Connect to access the database.
**API Endpoints**
You can test the following APIs using Postman or any other API testing tool:
- Get a Random Question
Endpoint:
GET http://localhost:8080/api/quiz/question
- Get All Questions
Endpoint:
GET http://localhost:8080/api/quiz/questions
- Submit an Answer
Endpoint:
POST http://localhost:8080/api/quiz/answer
Parameters:
questionId (integer): ID of the question
answer (string): Your answer (accepted values: a, b, c, d, case-insensitive)
Example:
POST http://localhost:8080/api/quiz/answer?questionId=1&answer=c
Use different questionId and answer values to test various cases.
- Get Summary
Endpoint:
GET http://localhost:8080/api/quiz/summary

This will return the total number of questions, as well as the count of correct and incorrect answers submitted.

**Testing Instructions**
Submit answers for different questions using the POST /api/quiz/answer endpoint.
Ensure that the answer parameter is one of a, b, c, or d (not case-sensitive).

After submitting a few answers, use the GET /api/quiz/summary endpoint to view the total questions attempted and the count of correct/incorrect answers.
