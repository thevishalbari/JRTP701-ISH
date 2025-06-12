package com.nt.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.binding.CitizenAppRegistrationInputs;
import com.nt.service.IApplicationRegistrationService;

@RestController
@RequestMapping("/citizenAR-api")
public class CitizenApplicationRegistrationController {

	@Autowired
	private IApplicationRegistrationService registestrationService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveApplicationRegistration(@RequestBody CitizenAppRegistrationInputs input){
		try {
			int appId = registestrationService.registerCitizenApplication(input);
			if(appId>0) {
				return new ResponseEntity<String>("You have Successfully register with appId :: "+appId,HttpStatus.CREATED);
			}else {
				return new ResponseEntity<String>("Invalid SSN or Citizen should not be from California State (CA)",HttpStatus.OK);				
			}
		}
		catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);			
		}
		
	}
	
}
