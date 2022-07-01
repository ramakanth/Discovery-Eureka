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
   

Test the Eureka URL:
------------------------------------
http://localhost:8761/

Spring Boot Application : # order-service
-----------------------------------------
@EnableEurekaClient
@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
}

@RestController
@RequestMapping("order")
public class OrderController {

    @GetMapping	
	public List<Order> listOrders(){ 
		return getOrders();
	}
    @GetMapping("/{id}")	
	public List<Order> listOrdersByCustomerId(@PathVariable("id") int customerId){ 
		return getOrdersByCustomerId(customerId);
	}
	public static List<Order> getOrders() {
		Order order1 = new Order(4000, 1111,"fulfilled",20000 );
		Order order2 = new Order(2000, 1113,"fulfilled",30000 );
		Order order3 = new Order(1000, 1112,"fulfilled",40000 );
		Order order4 = new Order(3000, 1111,"fulfilled",50000 );
		List<Order> orders = new ArrayList<Order>();
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
	  return orders;	
	}
	public static List<Order> getOrdersByCustomerId(int custId) {
		List<Order> orders = getOrders();
		List<Order> collect = orders.stream().filter(e -> e.getCustomerId()== custId).collect(Collectors.toList());
	  return collect;	
	}
}

public class Order {
private long orderId;
private long customerId;
private String orderStatus;
private double orderTotal;

/* setters and getters, parameterized constructor */

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
    
    
test the rest url
---------------------
http://localhost:3001/order/1111

