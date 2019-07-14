# PicturePreview
Upload a few pictures and get 100x100 picture preview.
## Installing
You neen IDEA, MySql and Spring. 
In application.properties change database name and password for MySql.
Open IDEA then File/Import, select the current project and click on import.
Wait for Maven to set up the project.
## To start
Select artifact (to run the application normally) DemonApplicationTests (to run unit tests), after selecting the artifact, press Run or Shift + F10.
## If the installation failed
Create a New project/Spring Initializr(select Default and click Next)/in next window click next/select Web/Spring Web Starter, SQL/Spring Data Jpa, SQL/MySql Driver and click Next and click Finish.
## After the tests
You can view the pictures in the directory "C://images". All pictures are 100x100.
## Api 
Send collection of picture urls on 
```url
localhost:8080/set
```
and get answer in Json format which have id request.

If you want to get a collection of links to processed images send 
```url
localhost:8080/get 
```
in request body must have a Json with id request. 
