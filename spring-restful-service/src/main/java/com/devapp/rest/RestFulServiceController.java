package com.devapp.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFulServiceController {

	public final Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	//returning output as String
	@GetMapping(value = "/hello-world")
	public String getHelloService() {
		return "Hello RestFul Service";
	}
	//returning output as bean
	@GetMapping(value = "/hello-world-bean")
	public HelloWorldBean getHellowWorldBean() {
		return new HelloWorldBean("Hello RestFul Service");
	}
	
	//using path variable
	@GetMapping(value = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean hellowWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello RestFul Service %s",name));
	}
	
}
