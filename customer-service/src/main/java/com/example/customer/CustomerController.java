package com.example.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	@GetMapping
	public List<Customer> getCustomers(){
		return listCustomers();
	}
	@GetMapping("/{id}")
	public List<OrdersVO> orders(@PathVariable("id") int customerId){
		List<OrdersVO> orders = customerOrderService.getOrders(customerId);
		return orders;
	}
	public static List<Customer> listCustomers(){
		Customer customer1 = new Customer(1111, "Rama", "Dhane");
		Customer customer2 = new Customer(1113, "Aadhya", "Dhane");
		Customer customer3 = new Customer(1112, "Bhavi", "Dhane");
		Customer customer4 = new Customer(1114, "Vishnu", "Dhane");
		Customer customer5 = new Customer(1115, "Sham", "Dhane");
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);
		customers.add(customer5);
		return customers;
	}
}
