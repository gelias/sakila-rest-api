# Sakila REST API (DVD Rental Store)

> Project responsible for externalize using REST API approach some resources from [SAKILA](https://www.jooq.org/sakila) project

## Stack:
* Java 11
* Spring Boot
* Gradle
* Docker
* logback - melhor formatação dos logs

## Architecture Style

This project is based in a hexagonal architecture. It has basically four layers:

* Application: Main service gate, the currently approach using REST API;
* Anticorruption: Layer responsible for translate application layer to infrastructure and domain objects.
* Domain: Basically responsible for encapsulates business rules.
* Infrastructure: Layer responsible for all app communication. ex.: databases and external services


## How to build

### Java REST API
```bash
./gradlew 
```
### Docker images
```bash
docker-compose build;
```
## How to run

### Docker

```bash
docker-compose up --force-recreate
```

## Documentation

__This app was developed using [open specification](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.0.md) principles. Use the swagger doc to navigate and test the main resources:__

```javascript
GET /swagger-ui.html
```
### Summary
#### Monitoring
__Request__:
```javascript
GET /actuator
```

#### Status App
__Request__:
```javascript
GET /status
```
#### Customer

##### By Country
__Request__:
```javascript
GET /v1/customer/country/United%20States
```

##### By Country and City
__Request__:
```javascript
GET /v1/customer/country/United%20States/city/Manchester
```

#### Film(DVD)

##### By Actor
__Request__:
```javascript
GET /v1/film/actor/firstName/JENNIFER/lastName/DAVIS
```

##### By Actor and category(optionally)
__Request__:
```javascript
GET /v1/film/actor/firstName/JENNIFER/lastName/DAVIS?category=Animation    
```

#### Rental

##### Overdue Rentals
__Request__:
```javascript
GET /v1/rental/overdue    
```

## Next Steps

* CI support. [Travis](http://travis-ci.org/) and [CircleCI](https://circleci.com/)
* Integration testing using
* [Quarkus](https://quarkus.io/) support
* [UBI](https://developers.redhat.com/products/rhel/ubi) container
