# Ecommerce-microservices - WIP👨‍💻
A simple microservices architecture for managing orders and products, demonstrating:  
✅ REST Controllers  
✅ Spring Data JPA  
✅ Feign Client  
✅ Spring Cloud Config  
🚧 API Gateway  
🚧 Eureka  
🚧 Logging & Tracing

## 📂 Postman Collection
Postman collections for API testing are available in the `postman/`folder of each module:

- **Product Service** → [`product-service/postman/`](product-service/postman/)
- **Order Service** →[`order-service/postman/`](order-service/postman/)

You can import them into Postman to easily test the microservices.

## 📜 Swagger API Documentation

The microservices expose the following Swagger UI endpoints:

- **Product Service** → [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
- **Order Service** → [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Each service provides a detailed OpenAPI specification for testing and interacting with the available endpoints.

## ⚙️ Actuator Endpoints
Spring Boot Actuator is enabled to provide monitoring and management capabilities. The following actuator endpoints are available:

**Product Service**

- Health: http://localhost:8081/actuator/health
- Metrics: http://localhost:8081/actuator/metrics
- Server Requests: http://localhost:8081/actuator/metrics/http.server.requests

**Order Service**

- Health: http://localhost:8080/actuator/health
- Metrics: http://localhost:8080/actuator/metrics
- Server Requests: http://localhost:8080/actuator/metrics/http.server.requests

## 🔧 Spring Cloud Config
Spring Cloud Config is used to manage external configurations for the microservices, allowing centralized configuration management. The **Config Server** is running on port `8888` and serves configurations for each microservice.

### Config Server Endpoints:
- **Order Service Config** → [http://localhost:8888/order-service/default](http://localhost:8888/order-service/default)
- **Product Service Config** → [http://localhost:8888/product-service/default](http://localhost:8888/product-service/default)

Each service fetches its configuration from the **Config Server** at startup. 
The configurations are stored in [`config-repo/`](config-repo).

