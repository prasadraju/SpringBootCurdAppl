package com.example.demo;

import java.util.Optional;

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



//   /api/students/allstudents
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@CrossOrigin
@RestController
@RequestMapping(value="/api/students")
public class StudentController {
	
	@Autowired
	StudentRepository repository;  
	
//	@CrossOrigin
	@GetMapping(value="/allstudents")
	public Iterable<Student> getAllBookedTickets(){
		return repository.findAll();
	}
	
	@PostMapping("/createStudent")
	public Student createTicket(@RequestBody Student ticket) {
		 return repository.save(ticket);
		
	}
	
	@GetMapping("/getStudent/{id}")
	public Optional<Student> getStudentById(@PathVariable("id" ) Integer id) {
		
		return repository.findById(id);

	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student,@PathVariable Integer id) {
		Optional<Student> studentOptional=repository.findById(id);
		
		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		repository.save(student);
		
		return ResponseEntity.noContent().build();
		
	}

}



//Optional<Student> student=repository.findById(id);
//if (!student.isPresent())
//	throw new StudentNotFoundException("id-" + id);
//
//return student.get();
