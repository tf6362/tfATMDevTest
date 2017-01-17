Development Test for ATM Web Application


This web application utilizes Camel to access a webservice to download ATM locations. 
The webservice and XSSI mode (Cross Server Script Inclusion) can be set in the src/main/webapp/WEB-INF/DEVTest-servlet.xml.
A Camel service will run when the Web Context is initialized to refresh the ATM data every 60 seconds.
The Camel service will stop when the web application is redeployed, undeployed or the web server is stopped.

A JSON formatted list of ATMS by city REST service is implemented at http://127.0.0.1:8080/api/locator/ATM?city=cityname
Clients must authenticate using HTTP Digest userid=admin password=password

An end user can use a web browser to access the application at http://127.0.0.1/
End users can authenticate to the application using userid admin password password.
They will be directed to a search form to type int he city name in any case.
When they click Search an html table showing the ATM's in that city will be presented.

They can then click on a link to do another search or logout.



Compiled using java version 1.8.0_91 on Windows XP
make sure to set the JAVA_HOME environment variable to the jdk installation and MAVAN_HOME to the location of Mave.



Install Maven version 3.3.9 and add \bin directory to path.


For SonarQube code coverage and quality reporting install SonarQube server and run on port 9000.

run

mvn clean
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true (for code coverage report)
mvn jacoco:prepare-agent test jacoco:report   (for code coverage report)
mvn sonar:sonar   (to store and process code quality report 

The Jetty plugin is configured to run tomcat via maven. To start tomcat on port 8080 run
mvn jetty:run
then login using your web browser tohttp://127.0.0.1/

A uml class diagram is available at src/main/documentation/class_diagram.pdf
The site documentation is available at target/site/index.html
Java code coverage is available at target/site/jacoco/index.html





