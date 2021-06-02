package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Person;
import net.javaguides.springboot.repository.PersonRepository;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
 	
	
	@Autowired
	private PersonRepository personRepository;
	
@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/persons")	
public List<Person> getAllPersons(){		
		return personRepository.findAll();
	}
	
	//new
@CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/persons")
	public Person createPerson( @RequestBody Person person) {
		return personRepository.save(person);
	}
	
	//get

@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/persons/{id}")
public  ResponseEntity<Person> getPersonbyId( @PathVariable Long id) {
Person person=personRepository.findById(id)
.orElseThrow(() ->
new ResourceNotFoundException("Not Found" +id));
return ResponseEntity.ok(person);
}


 //update
@CrossOrigin(origins = "http://localhost:4200")
@PutMapping("/persons/{id}")
public  ResponseEntity<Person> updatePersonbyId(@PathVariable Long id, @RequestBody Person persondet) {
	Person person=personRepository.findById(id)
			.orElseThrow(() ->
			new ResourceNotFoundException("Not Found" +id));
	person.setFirstname(persondet.getFirstname());
	person.setLastname(persondet.getLastname());
	person.setEmailId(persondet.getEmailId());
	person.setUrl(persondet.getUrl());
	person.setCp_fk(persondet.getCp_fk());
	Person updatedPerson=personRepository.save(person);
	return ResponseEntity.ok(updatedPerson);

	}

//DElete
@CrossOrigin(origins = "http://localhost:4200")
@DeleteMapping("/persons/{id}")
public ResponseEntity<Map<String,Boolean>> deletePerson(@PathVariable Long id)
{
	Person person=personRepository.findById(id)
			.orElseThrow(() ->
			new ResourceNotFoundException("Not Found" +id));	
	personRepository.delete(person);
	Map<String,Boolean> response=new HashMap<>();
	response.put("deleted", Boolean.TRUE);
     return ResponseEntity.ok(response);


}
 
@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/persons/cp_fk={id}")	
public List<Person> findbyvaccin(@PathVariable Long id){		
		return personRepository.findbyvaccin(id);
	}
		
}
