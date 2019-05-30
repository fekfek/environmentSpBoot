package com.fekade.app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/environment")
public class VolunteerRestController {
	
	@Autowired
	private VolunteerDao volunteerdao;
	
	@GetMapping("/getVolunteers")
	public List<Volunteer> getVolunteers(){
		return volunteerdao.findAll();
	}
	
	@GetMapping("/getVolunteer/{id}")
	public Optional<Volunteer> getVolunteer(@PathVariable int id){
		Optional<Volunteer> volunteer = volunteerdao.findById(id);
		if(volunteer !=null) {
			return volunteer;
		}
		else {
			throw new RuntimeException("A volunteer with an id of "+id+" does not exist");
		}
	}
	
	@PostMapping("/addvolunteer")
	public void add(@RequestBody Volunteer volunteer) {
		volunteerdao.save(volunteer);
	}
	
	@PutMapping("/updateVolunteer/{id}")
	public void update(@RequestBody Volunteer volunteer,@PathVariable int id) {
		if(volunteerdao.existsById(id)) {
			volunteerdao.save(volunteer);
		}
		else {
			throw new RuntimeException("A volunteer with an id of "+id+" does not exist");
		}
	}
	
	@DeleteMapping("/removeVolunteer/{id}")
	public void remove(@PathVariable int id) {
		if(volunteerdao.existsById(id)) {
			volunteerdao.deleteById(id);
		}
		else {
			throw new RuntimeException("A volunteer with an id of "+id+" does not exist");
		}
	}
	
	
	

}
