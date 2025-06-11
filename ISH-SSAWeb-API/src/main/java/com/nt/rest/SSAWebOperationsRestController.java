package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssa-web-api")
public class SSAWebOperationsRestController {


	@GetMapping("/find/{ssn}")
	public ResponseEntity<String> getStateBySSN(@PathVariable Integer ssn){
		
		if(String.valueOf(ssn).length()!=9) {
			return new ResponseEntity<String>("Invalid SSN",HttpStatus.BAD_REQUEST);
		}
		
		//	Check StateCode & StateName By SSN
		int StateCode = ssn%100;
		String StateName = null;
		
		if(StateCode==01) {
			StateName="Washington DC";
		}
		else if(StateCode==02) {
			StateName="Ohio";
		}
		else if(StateCode==03) {
			StateName="Texas";
		}
		else if(StateCode==04) {
			StateName="California";
		}
		else if(StateCode==05) {
			StateName="Florida";
		}
		else {
			StateName="Invalid SSN";
		}
		
		return new ResponseEntity<String>(StateName,HttpStatus.OK);
		
	}
		
}
