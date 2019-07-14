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
Send collection of picture urls
```json
{
  "pictureUrls":[
    "https://i.ytimg.com/vi/YCaGYUIfdy4/maxresdefault.jpg",
    "https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80"
]}
```
on url
```url
localhost:8080/set
```
and get answer 
in Json format
```json
{"id":54368}
```
which have id request.

If you want to get a collection of links to processed images send your id
```json
{"id":54368}
```
on url
```url
localhost:8080/get 
```
and get Json with urls to the images.
```json
{
  "avatarPictures":[
    "url_1",
    "url_2"
]}
```
