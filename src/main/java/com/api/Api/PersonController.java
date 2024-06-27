package com.api.Api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.Api.model.Person;
import com.api.Api.services.PersonServices;

@RestController
@RequestMapping("person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
//	private PersonServices service = new PersonServices();
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value="id") String id) throws Exception{
		return service.findById(id);
	}
}
