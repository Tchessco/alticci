# ALTICCI

This is a challenge project from alticci lab. 

This project uses Quarkus, the Supersonic Subatomic Java Framework.
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Requirements

Java 17+

Docker

Nodejs v18.12.1

Maven 3.8.6

### Running the application API in dev mode

You can run the application api in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus API app is available in dev mode only at http://localhost:8080/q/dev/ and swagger will be available at http://localhost:8080/q/swagger-ui
### Running the application UI in dev mode

You can run the application api in dev mode that enables live coding using:
```shell script
cd alticci-ui
npm install
npm start
```

> **_NOTE:_**  Angular UI app is available in dev mode only at http://localhost:4200/

## Packaging and running the application

The application can be packaged using:
```shell script
docker-compose up --build
```
It produces the docker image that will show the UI at http://localhost.

