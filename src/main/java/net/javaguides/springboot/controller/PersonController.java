package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Person;
import net.javaguides.springboot.repository.PersonRepository;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
	
	
	
	@Autowired
	private PersonRepository personRepository;
	
@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/persons")	public List<Person> getAllPersons(){		
		return personRepository.findAll();
	}
	
	//new
@PostMapping("/persons")
	public Person createPerson( @RequestBody Person person) {
		return personRepository.save(person);
	}
	
	
 	
	
	
		
		
}
