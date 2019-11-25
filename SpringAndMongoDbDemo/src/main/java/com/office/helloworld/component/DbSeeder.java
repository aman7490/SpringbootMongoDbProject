package com.office.helloworld.component;
/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.office.helloworld.model.Address;
import com.office.helloworld.model.Hotel;
import com.office.helloworld.model.Review;
import com.office.helloworld.repository.HotelRepository;

@Component
public class DbSeeder implements CommandLineRunner {

	/*
	 * when spring boot application starts this commanda line runner execute
	 * automatically, so here we will add some hotels
	 */  /*
	@Autowired
	private HotelRepository hotelrepository;
	
	public DbSeeder(HotelRepository hotelRepository) {
		this.hotelrepository= hotelRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Hotel marriot = new Hotel(
				"marriot",
				new Address("amritsar","India"),
				Arrays.asList( 
						new Review("John", 8, false),
						new Review("Smith", 8, true)
						),"1",100
		);
		Hotel ibis = new Hotel(
				"ibis",
				new Address("Los Angeles","USA"),
				Arrays.asList( 
						new Review("Mary", 9, true)
						),"2",99
		);
		Hotel Sofitel = new Hotel(
				"Sofitel",
				new Address("Rome","Italy"),
				new ArrayList<>(),"3",999
		);
		
		// drop all hotels if already existing in databASE
		this.hotelrepository.deleteAll(); 
		
		// add hotels in database.
		List<Hotel> hotels = Arrays.asList(marriot,ibis,Sofitel);
		this.hotelrepository.saveAll(hotels);
		
	}


	
}
*/