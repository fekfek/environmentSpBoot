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
public class MemberRestController {
	
	@Autowired
	private MemberDao memberdao;
	
	@GetMapping("/getMembers")
	public List<Member> getMembers(){
		return memberdao.findAll();
	}
	
	@GetMapping("/getMember/{id}")
	public Optional<Member> getMember(@PathVariable int id){
		Optional<Member> member = memberdao.findById(id);
		if(member !=null) {
			return member;
		}
		else {
			throw new RuntimeException("A member with an id of "+id+" does not exist");
		}	
	}
	
	@PostMapping("/addMember")
	public void addMember(@RequestBody Member member) {
		memberdao.save(member);
	}
	
	@PutMapping("/update/{id}")
	public void update(@RequestBody Member member,@PathVariable int id) {
		if(memberdao.existsById(id)) {
			memberdao.save(member);
		}
		else {
			throw new RuntimeException("A member with an id of "+id+" does not exist");
		}
	}
	
	@DeleteMapping("/remove/{id}")
	public void remove(@PathVariable int id) {
		if(memberdao.existsById(id)) {
			memberdao.deleteById(id);
		}
		else {
			throw new RuntimeException("A member with an id of "+id+" does not exist");
		}
	}
		
	
	
	
	

}
