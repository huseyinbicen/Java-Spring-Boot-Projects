# Microservices

### Swagger ui urls
*     Product service   = http://localhost:8080/swagger-ui/index.html
*     Order service     = http://localhost:8081/swagger-ui/index.html
*     Inventory service = http://localhost:8082/swagger-ui/index.html

### Eureka
*     Eureka Server     = http://localhost:8761/ 
  *     Username = eureka / Password = password
*     From API Gateway  = http://localhost:8080/eureka/web

### API Gateway
*     Product service   = http://localhost:8080/swagger-ui/index.html
*     Order service     = http://localhost:8080/swagger-ui/index.html
*     Inventory service = http://localhost:8080/swagger-ui/index.html


### Keycloak on Docker

*     https://www.keycloak.org/getting-started/getting-started-docker
*     https://www.youtube.com/watch?v=La082JsJoH4
*     docker run -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:23.0.1 start-dev

