# DevOps_Assignment
mvn clean install | To create and exectuable jar for the project

mvn spring-boot:run | To run the application using CLI |


## SonarQube Setup and run -

Get the .zip from [here](https://www.sonarqube.org/downloads/).
Make sure localhost:9000 is free (otherwise will have to specify port for Qube to run on).
Follow the server startup steps from [here](https://docs.sonarqube.org/latest/setup/get-started-2-minutes/).
Exact commands used are in sonar_load.sh. This can be also used within the CI/CD Pipeline once we have it.
Token that was used was projecttoken: 859be3e146906bee231e139f86f9ee51453dcad5.
