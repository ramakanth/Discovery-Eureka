# Discovery-Eureka

Spring Boot Application : # eurekaserver
-----------------------------------------

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverApplication.class, args);
	}

}


application.properties
------------------------

spring.application.name=eurekaserver
server.port=8761
eureka.client.registerWithEureka=false

eureka.client.fetchRegistry=false

eureka.instance.hostname=localhost

eureka.client.service-url.default-zone=http://localhost:8761/eureka

#eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/

#server.port=8761

#eureka.client.register-with-eureka=false

#eureka.client.fetch-registry=false

pom.xml
-----------
    <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
    

Spring Boot Application : # order-service
-----------------------------------------
@EnableEurekaClient
@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
}

application.properties
------------------------

server.port=1111
spring.application.name=ORDER-SERVICE
eureka.client.service-url.default-zone=http://localhost:8761/eureka/

pom.xml
-------------------
                 <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
    
