package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HR;
import com.example.demo.service.HRLoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value= "/api/**", method=RequestMethod.OPTIONS)

public class HRLoginController
{
	@Autowired
	HRLoginService service;

	
	@PostMapping("/create-hr")
	public HR createHr(@RequestBody HR hr) {
		return service.createHR(hr);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	HR verifyUser(@RequestBody HR hr ) {
		System.out.println("entered controller");
			return service.verifyUser(hr.getUserEmail(),hr.getUserPassword());
	}
	
	@GetMapping(path="/hrDetails/all")
	public @ResponseBody Iterable<HR> getAllHR() {
		System.out.println("url hit for all");
		return service.getAllHR();
	}
	
		
	@RequestMapping(method = RequestMethod.PATCH, value = "/updateHR")
	void updateHR(@RequestBody HR hr) 
	{
		System.out.println(hr);
		 
		service.updateHR(hr);
	}



	 @RequestMapping(value = "/HR/{id}", method = RequestMethod.GET)
		public HR getToDoById(@PathVariable("id") int id){
	    	//HR hr = service.getHRById(id);
	    	return service.getHRById(id);
	 }
}

