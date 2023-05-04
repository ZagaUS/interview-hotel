# interview-hotel

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .
## Overview
The Tour and Hotel project aims to provide a platform for managing tours and hotel bookings. It is built using the Quarkus framework, which is a lightweight and fast Java framework designed for building cloud-native applications. The project uses PostgreSQL as the database for storing and retrieving data.

## Prerequisites
Before running the Tour and Hotel project, ensure that the following prerequisites are met:

Java Development Kit (JDK) 11 or later is installed.
Apache Maven is installed.
PostgreSQL database is installed and running.

## Getting Started
To get started with the project, follow these steps:

Clone the repository: git clone <repository-url>
Navigate to the project directory: cd interview-hotel-project
Navigate to the project directory: cd hotel
Build the project using Maven: mvn clean install
Navigate to the project directory: cd tour
Build the project using Maven: mvn clean install
Configure the database connection in the application.properties file.

## Running the application in dev mode
Navigate to the project directory: cd hotel 

You can run your application in dev mode that enables live coding using:
```shell script 
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

