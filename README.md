<a href="#"><img src="https://img.shields.io/badge/Docker-Available-blue?logo=docker&style=for-the-badge" /></a>
<a href="#"><img src="https://img.shields.io/badge/Spring Boot-v0.79.0-63a871?logo=spring&style=for-the-badge" /></a>
<a href="#"><img src="https://img.shields.io/badge/Mongodb-v8.0.30-green?logo=mongodb&style=for-the-badge" /></a>

# Readme: PlaceApi-Spring

An example of a WebServer developed using Spring & SpringBoot and MongoDb for noSQL database. Also supports user
authentication with JWT tokenization.

This simple server acts a Location-Service - it will allow you to make search for details of a physical location for
every user.

## Requirements

The fully fledged server uses the following:

* Spring Framework
* SpringBoot

## Endpoints

<img width="832" alt="Screenshot 2022-11-21 at 12 12 05" src="https://user-images.githubusercontent.com/78916039/203012966-4cc5787a-c2d8-4c90-856f-d464ed2b5744.png">


## Dependencies

There are a number of third-party dependencies used in the project. Browse the Maven pom.xml file for details of
libraries and versions used.

## Building the project

You will need:

* Java JDK 8 or higher
* Maven 3.1.1 or higher
* Git

Clone the project and use Maven to build the server

	$ mvn clean install


