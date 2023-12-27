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
*     http://localhost:8181


### Actuator 
*     http://localhost:{PORT_NO}/actuator/health


### Zipkin on Docker
*     https://zipkin.io/pages/quickstart.html
*     https://www.youtube.com/watch?v=Cm75_MIo_aY&list=PLSVW22jAG8pBnhAdq9S8BpLnZ0_jVBj0c&index=7&t=295s
*     https://mohosinmiah1610.medium.com/how-to-implement-zipkin-in-spring-boot-3-683e9d61a94c
*     docker run -d -p 9411:9411 openzipkin/zipkin
*     http://localhost:9411/zipkin/


