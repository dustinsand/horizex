# Horizex API
[![Build and Test](https://github.com/dustinsand/horizex/actions/workflows/ci.yml/badge.svg)](https://github.com/dustinsand/horizex/actions/workflows/ci.yml)

Horizex is a fictitious startup operating in a rapidly evolving domain. To support this flexibility, the application is
built using the Spring Modulith framework, enabling a well-structured monolithic architecture. The codebase is organized
into clear, explicit modules that enforce architectural boundaries, promote loose coupling, and simplify future
refactoring.

This modular design follows best practices typically found in microservice architectures, without introducing the
complexity of distributed systems. As the domain and non-functional requirements mature, these modules can be easily
extracted and deployed as independent microservices.

The first module in the system is the Customer module (com.horizex.customerJpaEntity). This module is responsible for
encapsulating all functionality related to managing customerJpaEntity data and exposing the Customer API. It serves as a
foundational component for the platform and demonstrates the modular structure and boundaries promoted by Spring
Modulith.  

## Technology Stack

- Java SDK 24
- Spring Boot 3
- Spring Data JPA
- Spring Modulith
- H2 in memory database
- Flyway to manage the database migration
- Karate for behavior tests

## Build / Unit and Acceptance Tests

Build and run the unit and acceptance tests.
```bash
./mvnw clean test
```

## Instrumentation of API (Observability)

Did not have time to add:
1) Metrics using Micrometer and Prometheus
2) Tracing using OpenTelemetry and Zipkin
3) Logs - configure structured app logs to be sent to ELK stack

## Containerization

```bash
./mvnw clean package

docker build -t horizex-api .

docker run -p 8080:8080 horizex-api

# Verify app is UP
curl http://localhost:8080/actuator/health

# Call the customers endpoint to find all customers
curl http://localhost:8080/horizex/customers
```

## Kubernetes (locally)
Ran out of time to troubleshoot why after starting the service in k8s I could still not connect to the endpoints.
```bash
minikube start

eval $(minikube docker-env)

./mvnw clean package

docker build -t horizex-api .

kubectl apply -f kube-app.yaml

kubectl get pods

minikube service horizex-service --url

# Verify app is UP
curl http://$(minikube ip):30080/actuator/health

# Call the customers endpoint to find all customers
curl http://$(minikube ip):30080/horizex/customers

# Clean up
kubectl delete -f kube-app.yaml
minikube stop

```
## CI/CD

GitHub action will build the app and run the tests. 

## App Integration
Use curl as the client to validate the API. 

```bash
./mvnw clean spring-boot:run

# Create a customerJpaEntity
curl -v -X POST http://localhost:8080/horizex/customers \
     -H "Content-Type: application/json" \
     -d '{ "firstName": "curlF", "middleName": "quincy", "lastName": "curlL", "emailAddress": "curl1@gmail.com", "phoneNumber": "17038675309" }'

# Get customerJpaEntity
curl http://localhost:8080/horizex/customers/{uuid of created customerJpaEntity}

# Call the customers endpoint to find all customers
curl http://localhost:8080/horizex/customers

# Delete customerJpaEntity
curl -X DELETE http://localhost:8080/horizex/customers/{uuid of created customerJpaEntity}

```