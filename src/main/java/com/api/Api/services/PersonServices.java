package com.api.Api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.api.Api.model.Person;

@Service
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		logger.info("Finding all people!");
		
		List<Person> persons = new ArrayList<>();
		
		for(int i= 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}

	public Person findById(String id) {
		logger.info("Finding one person!");
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Leandro");
		person.setLastName("Silva");
		person.setAddress("Cuiabá");
		person.setGender("Mail");
		
		return person;
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name " + i);
		person.setLastName("Last Name " + i);
		person.setAddress("Person Address " + i);
		person.setGender("Person Gender " + i);
		
		return person;
	}
}
