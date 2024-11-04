### Repository to manage user payments from an external domain.


| Service | Description |
|--|--|
|payments-processor|Payment processing from an external domain|
|users-processor|User processing from an external domain|
|users-payments-sink|Persist users and payments data|
|users-payments-api|Api for querying domain data|

### Deploy infrastructure
The docker-compose file is located in infrastructure
```
docker-compose.yml -p infrastructure up -d rabbitmq db-services
```

### Build and Package
```
mvn clean install
```

### Build Docker image
Below command will build and push a docker image of service. Be sure to run building task first
```
$ mvn docker:build
```

### Deployment
```
$ mvn spring-boot:run
```

### Rabbit message examples

###### Payment Created
````json
{
  "header": {
    "objectName": "payment-created",
    "version": 1,
    "createdAt": "2024-11-04T01:36:41.070429"
  },
  "content": {
    "id": "58c633cc-9237-433d-bed3-e709bcfe0bf2",
    "userId": "68c633cc-9237-433d-bed3-e709bcfe0bf2",
    "amount": 1000,
    "paymentDate": "2024-11-04T01:36:41.070429"
  }
}
````

###### User Created
````json
{
  "header": {
    "objectName": "user-created",
    "version": 1,
    "createdAt": "2024-11-04T01:36:41.070429"
  },
  "content": {
    "id": "68c633cc-9237-433d-bed3-e709bcfe0bf2",
    "username": "Aarón Gómez Barroso",
    "email": "agombarupo@gmail.com"
  }
}
````

###### User Updated
````json
{
  "header": {
    "objectName": "user-updated",
    "version": 1,
    "createdAt": "2024-11-04T01:36:41.070429"
  },
  "content": {
    "id": "68c633cc-9237-433d-bed3-e709bcfe0bf2",
    "username": "Aarón Gómez Barroso",
    "email": "agombarupo@gmail.com"
  }
}
````

### Messaging Producer

###### User Created
````json
{
  "header": {
    "objectName": "user-created",
    "version": 1,
    "createdAt": "2024-11-04T01:36:41.070429"
  },
  "content": {
    "id": "68c633cc-9237-433d-bed3-e709bcfe0bf2",
    "username": "Aarón Gómez Barroso",
    "email": "agombarupo@gmail.com"
  }
}
````

###### User Updated
````json
{
  "header": {
    "objectName": "user-updated",
    "version": 1,
    "createdAt": "2024-11-04T01:36:41.070429"
  },
  "content": {
    "id": "68c633cc-9237-433d-bed3-e709bcfe0bf2",
    "username": "Aarón Gómez Barroso",
    "email": "agombarupo@gmail.com"
  }
}
````