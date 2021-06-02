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
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Vaccin;
import net.javaguides.springboot.repository.VaccinRepository;
 
@RestController
@RequestMapping("/api/v1")
public class VaccinController {


	@Autowired
	private VaccinRepository vaccinRepository;

@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/vaccins")	public List<Vaccin> getAllvaccins(){
		return vaccinRepository.findAll();
	}

	//new
@CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/vaccins")
	public Vaccin createvaccin( @RequestBody Vaccin vaccin) {
		return vaccinRepository.save(vaccin);
	}

	//get

@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/vaccins/{id}")
public  ResponseEntity<Vaccin> getvaccinbyId( @PathVariable Long id) {
Vaccin vaccin=vaccinRepository.findById(id)
.orElseThrow(() ->
new ResourceNotFoundException("Not Found" +id));
return ResponseEntity.ok(vaccin);
}


 //update
@CrossOrigin(origins = "http://localhost:4200")
@PutMapping("/vaccins/{id}")
public  ResponseEntity<Vaccin> updatevaccinbyId(@PathVariable Long id, @RequestBody Vaccin vaccindet) {
	Vaccin  vaccin=vaccinRepository.findById(id)
			.orElseThrow(() ->
			new ResourceNotFoundException("Not Found" +id));
	vaccin.setFirstname(vaccindet.getFirstname());
	vaccin.setLastname(vaccindet.getLastname());
	vaccin.setPhone(vaccindet.getPhone());
	Vaccin updatedvaccin=vaccinRepository.save(vaccin);
	return ResponseEntity.ok(updatedvaccin);

	}

//DElete
@CrossOrigin(origins = "http://localhost:4200")
@DeleteMapping("/vaccins/{id}")
public ResponseEntity<Map<String,Boolean>> deletevaccin(@PathVariable Long id)
{
Vaccin  vaccin=vaccinRepository.findById(id)
			.orElseThrow(() ->
			new ResourceNotFoundException("Not Found" +id));
vaccinRepository.delete(vaccin);
	Map<String,Boolean> response=new HashMap<>();
	response.put("deleted", Boolean.TRUE);
     return ResponseEntity.ok(response);


}




}
