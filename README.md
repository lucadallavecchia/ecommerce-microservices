# Ecommerce-microservices - WIP👨‍💻
A simple microservices architecture for managing orders and products, demonstrating:  
✅ REST Controllers  
✅ Spring Data JPA  
✅ Feign Client  
✅ Spring Cloud Config  
✅ API Gateway  
✅ Eureka  
✅ Logging & Tracing

## 📂 Postman Collection
Postman collections for API testing are available in the `postman/`folder of each module:
* [`order-service/postman/`](order-service/postman/)
* [`product-service/postman/`](product-service/postman/)

You can import them into Postman to easily test the microservices. 

## 📜 Swagger API Documentation

The microservices expose the following Swagger UI endpoints:

- **Product Service** → [http://localhost:8081/swagger-ui/](http://localhost:8081/swagger-ui/)
- **Order Service** → [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

Each service provides a detailed OpenAPI specification for testing and interacting with the available endpoints.
