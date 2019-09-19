package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * Controller for demo of dynamic filtering
 * 
 * @author viren
 */
@RestController
public class FilteringController {
	@GetMapping("/filteredSomeBean")
	public MappingJacksonValue filteredPropertiesSomeBean() {
		final SomeBean someBean = new SomeBean("Field 1 value", "Field 2 value", "Field 3 value");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanpropertyFilter", filter);

		MappingJacksonValue mappingJactionValue = new MappingJacksonValue(someBean);
		mappingJactionValue.setFilters(filterProvider);

		return mappingJactionValue;
	}

	@GetMapping("/filteredSomeBean-list")
	public MappingJacksonValue filteredPropertiesSomeBeansList() {
		 final List<SomeBean> someBeansList = Arrays.asList(new SomeBean("Field 1 value", "Field 2 value",
				"Field 3 value"), new SomeBean("Field 11 value", "Field 22 value", "Field 33 value"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanpropertyFilter", filter);

		MappingJacksonValue mappingJactionValue = new MappingJacksonValue(someBeansList);
		mappingJactionValue.setFilters(filterProvider);

		return mappingJactionValue;
	}
}
