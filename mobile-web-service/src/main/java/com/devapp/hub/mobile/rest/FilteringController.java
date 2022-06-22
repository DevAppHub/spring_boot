package com.devapp.hub.mobile.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devapp.hub.mobile.dto.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	
	//dynamic filtering
	//field1, field2
	@GetMapping(path = "filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter
				.filterOutAllExcept("field1","field2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
	}
	
	//field1
	@GetMapping(path = "filtering-list")
	public MappingJacksonValue retrieveListOfSomeBean() {
		List<SomeBean> asList = Arrays.asList( new SomeBean("value1","value2","value3"),
				new SomeBean("value1","value2","value3"));
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter
				.filterOutAllExcept("field1");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(asList);
		mapping.setFilters(filters);
		return mapping;
	}

}
