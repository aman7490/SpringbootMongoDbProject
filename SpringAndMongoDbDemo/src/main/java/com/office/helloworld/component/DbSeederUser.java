package com.office.helloworld.component;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;

import com.office.helloworld.model.User;
import com.office.helloworld.repository.UserRepository;

public class DbSeederUser implements CommandLineRunner{

	private UserRepository userrepository;
	
	public DbSeederUser(UserRepository userrepository) {
		this.userrepository= userrepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
//		User user1= new User("3","aman", "aman123", "USER", "");
//		User user2= new User("4","admin", "admin123", "ADMIN", "");
//		User user3= new User("5","manager", "manager123", "MANAGER", "");
		
//		List<User> users = Arrays.asList(user1,user2,user3);
		
//		this.userrepository.saveAll(users);
		
	}

	
	
	
	
	
	
}
