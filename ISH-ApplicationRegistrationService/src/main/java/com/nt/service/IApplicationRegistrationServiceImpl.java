package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.nt.binding.CitizenAppRegistrationInputs;
import com.nt.entity.CitizenAppRegistrationEntity;
import com.nt.repository.IApplicationRegistrationRepository;

@Service
public class IApplicationRegistrationServiceImpl implements IApplicationRegistrationService {

	@Autowired
	private IApplicationRegistrationRepository citizenRepo;

/*1		//	This is For RestTemplate to use Synchronous communication for Web Request/Client 
	//	@Autowired
	//	private RestTemplate template;
*/
	
//	This is For WebClient
	@Autowired
	private WebClient client;
	
	@Value("${ar.ssa-web.url}")
	private String endPointUrl;
	@Value("${ar.state}")
	private String targetState;
	@Override
	public Integer registerCitizenApplication(CitizenAppRegistrationInputs input) {

/*2		//	This is For RestTemplate to use Synchronous communication for Web Request/Client 		
		//	perform WebServices call to check whether SSN is valid or not And to get the stateName
		ResponseEntity<String> response = template.exchange(endPointUrl, HttpMethod.GET, null, String.class, input.getSsn()); 
		//	get state name
		String statename = response.getBody();
*/

//	This is For WebClient
		//	get state name
		String statename = client.get().uri(endPointUrl,input.getSsn()).retrieve().bodyToMono(String.class).block();
		
		//	Register citizen if he belong to California state (CA)
		if(statename.equalsIgnoreCase(targetState)) {
			//	Prepare the entity object
			CitizenAppRegistrationEntity entity = new CitizenAppRegistrationEntity();
			BeanUtils.copyProperties(input, entity);
			entity.setStateName(statename);
			//	save the object
			int appId = citizenRepo.save(entity).getAppId();
			return appId;
		}
		
		return 0;
	}

}
