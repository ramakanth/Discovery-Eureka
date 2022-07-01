package com.example.customer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@Component
public class CustomerOrderService {

	@Autowired
	private DiscoveryClient discoveryClient;

	public List<OrdersVO> getOrders(int customerId) {
		List<ServiceInstance> instances = discoveryClient.getInstances("ORDER-SERVICE");
		ServiceInstance serviceInstance = instances.get(0);
		URI uri = serviceInstance.getUri();
		String url = uri + "/order/" + customerId;
		System.out.println(serviceInstance.getUri());
		RestTemplate template = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<OrdersVO> forObject = template.getForObject(url, List.class);
		return forObject;
	}

}
