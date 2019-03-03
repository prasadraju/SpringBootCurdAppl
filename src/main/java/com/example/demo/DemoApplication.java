package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	
//	@RequestMapping("/")
//	public String hello(){
//		return "Hello World!!";
//    }
	
	@RequestMapping("/prasad")
	 @ResponseBody
	 public String getData(){
		return "Prasad Raj K!!";
   }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users",repository.findAll());
	}
}
