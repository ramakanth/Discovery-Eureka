package com.example.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




