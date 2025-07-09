# Ecommerce-microservices - WIP👨‍💻
A simple microservices architecture for managing orders and products, demonstrating:  
✅ REST Controllers  
✅ Spring Data JPA  
✅ Feign Client  
✅ Spring Cloud Config  
✅ Eureka - Naming Service/Load Balancer  
✅ API Gateway  
✅ Metrics & Monitoring  
🚧 Logging & Tracing  


## 🌉 API Gateway Configuration
The API Gateway (running on port `8765`) provides a single entry point for all microservices with:
- **Dynamic routing** to backend services
- **URL path rewriting**
- **Load balancing** through Eureka

**Available Routes**

| Service        | Gateway Path                  | Backend Route                     |
|----------------|-------------------------------|-----------------------------------|
| Order Service  | `/api/order-service/**`       | `lb://ORDER-SERVICE/**`           |
| Product Service| `/api/product-service/**`     | `lb://PRODUCT-SERVICE/**`         |

**Gateway Endpoints**

- **Actuator Routes**: http://localhost:8765/actuator/gateway/routes
- **Health Check**: http://localhost:8765/actuator/health
- **Swagger UI**: Available through each service directly


## 📂 Postman Collection
Postman collections for API testing are available in the `postman/`folder of each module:

- **Order Service** →[`order-service/postman/`](order-service/postman/)
- **Product Service** → [`product-service/postman/`](product-service/postman/)
- **Api Gateway** → [`api-gateway/postman/`](api-gateway/postman/)

You can import them into Postman to easily test the microservices.


## 📜 Swagger API Documentation

The microservices expose the following Swagger UI endpoints:

- **Order Service** → [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **Product Service** → [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

Each service provides a detailed OpenAPI specification for testing and interacting with the available endpoints.
N.B. The use of the Api Gateway postman collection is suggested.


## ⚙️ Actuator Endpoints
Spring Boot Actuator is enabled to provide monitoring and management capabilities. The following actuator endpoints are available:

**Order Service**

- Health: http://localhost:8080/actuator/health
- Metrics: http://localhost:8080/actuator/metrics
- Server Requests: http://localhost:8080/actuator/metrics/http.server.requests
- Prometheus: http://localhost:8080/actuator/prometheus

**Product Service**

- Health: http://localhost:8081/actuator/health
- Metrics: http://localhost:8081/actuator/metrics
- Server Requests: http://localhost:8081/actuator/metrics/http.server.requests
- Prometheus: http://localhost:8081/actuator/prometheus


## 🔧 Spring Cloud Config
Spring Cloud Config is used to manage external configurations for the microservices, allowing centralized configuration management. The **Config Server** is running on port `8888` and serves configurations for each microservice.

Config Server Endpoints:
- **Order Service Config** → [http://localhost:8888/order-service/default](http://localhost:8888/order-service/default)
- **Product Service Config** → [http://localhost:8888/product-service/default](http://localhost:8888/product-service/default)

Each service fetches its configuration from the **Config Server** at startup. 
The configurations are stored in [`config-repo/`](config-repo).


## 🔄 Service Discovery with Eureka

Eureka is used for service discovery, enabling microservices to dynamically register and locate each other.
Eureka Naming Server is running on port 8761.
Each microservice is registered with Eureka, allowing automatic service discovery and load balancing.

Eureka dashboard is available at: http://localhost:8761


## 📊 Metrics & Monitoring
Prometheus and Grafana are used to collect and visualize application metrics exposed via Micrometer.

**Starting via Docker**

You can start both Prometheus and Grafana using the provided `docker-compose.yml` file located at [`docker-local/`](docker-local/):

```bash 
  docker-compose -f docker-local/docker-compose.yml up
```
(common issue: missing "execute" permissions to the content of the _docker-local_ folder)

**Urls**

| Service    | Url                   | 
|------------|-----------------------|
| Prometheus | http://localhost:9090 |
| Grafana    | http://localhost:3000 |

**Prometheus**

To check the proper integration service-prometheus: http://localhost:9090/targets
To play with some metrics http://localhost:9090/query

**Grafana**

To be able to use Gragana you need to do an initial configuration:First login:

****First login:****
* username: _admin_
* password: _admin_   

****Datasource configuration:****
* You need to add a new datasource: select _prometheus_  
* Configure the endpoint: _http://prometheus:9090_    
* Define an update interval: _Scrape interval 2s_  

****Import/Create dashboar:****
1. In grafana select: _hamburger menu_(top left corner) -> _Dashboards_
2. In the dashboard area select: _New_ (top right corner) -> _Import_
3. Use the grafana dashboard id _10280_ (Spring Boot 2.1 Statistics)

After completing this configuration, you'll see a panel titled HTTP Statistics displaying all the performed requests.