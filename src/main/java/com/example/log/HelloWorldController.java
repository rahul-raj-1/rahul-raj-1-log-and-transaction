package com.example.log;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.log.service.ServiceLayer;

@RestController
public class HelloWorldController {
	
	
	private static final Logger LOG = LogManager.getLogger(HelloWorldController.class);
	
	@Autowired
	private ServiceLayer serviceLayer;
	
	  @GetMapping("/emp/{id}")
  void m1(@PathVariable String id) throws InterruptedException {
		 
	
		  serviceLayer.call(id);
		  System.out.println(" ------ After call -----");
		  
		 
		 
		
		 
	 }


}
