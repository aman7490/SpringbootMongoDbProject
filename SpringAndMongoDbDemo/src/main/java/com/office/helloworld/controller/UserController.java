package com.office.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.office.helloworld.model.User;
import com.office.helloworld.repository.UserRepository;

@RestController

public class UserController {

	@Autowired
	UserRepository userrepository;
	
@RequestMapping(value = "/users", method = RequestMethod.POST)	
public User adduser(@RequestBody @Validated User user) {
	
//	List<User> userss = userrepository.findAll();
	
//	Collections.sort(userss,Collections.reverseOrder());
/*	for(int i=0;i<=userss.size();i++) {
		if(i==userss.size()) {
			int j=(int) userss.get(i).getId(); 
		}
		
	}*/	
	//		 j1=	(int) userss.get(userss.size()).getId();
		
	
	 
//	j1= j1+1;
	
	
//	user.setId(j1);
	
	return userrepository.insert(user);	
}

}
