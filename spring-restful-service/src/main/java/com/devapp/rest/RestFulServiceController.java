package com.devapp.rest;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFulServiceController {

	public final Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	MessageSource messageSource;
	
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
	
	@GetMapping(value="/hello-world-internationalized")
	public String helloWorldInternationalized(
//			@RequestHeader(name="Accept-Language", required = false) Locale locale
			) {
		return messageSource.getMessage("good.morning.message",null,"Default Message", LocaleContextHolder.getLocale());
		//en =Hello World
		//nl= Goede Morgen
		//fr = Bonjour
		
	}
}
