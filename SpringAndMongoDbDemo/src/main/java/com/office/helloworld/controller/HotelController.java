package com.office.helloworld.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.office.helloworld.model.Hotel;
import com.office.helloworld.repository.HotelRepository;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelRepository hotelRepository;

	public HotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@GetMapping("/all")
	public List<Hotel> getallhotels(Hotel hotel){
		
		List<Hotel> hotels= this.hotelRepository.findAll();
		return hotels;
	}
	
/*	public List<Hotel> getallhotels(Hotel hotel){
		
		List<Hotel> hotels = hotelRepository.findAll();
		
		for (Hotel hotel2 : hotels) {
			
		}
	
		return hotels;
		
	} */
	
	@PostMapping("/add")
	public void addhotel(@RequestBody Hotel hotel) {
		
		hotelRepository.insert(hotel);
	}
	
	@PutMapping("/update/{id}")
	public void updatehotel(@RequestBody Hotel hotel, @PathVariable("id") String id) {
		
		hotelRepository.save(hotel);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deletehotel(@PathVariable("id") String id) {
		
		hotelRepository.deleteById(id);
		
	}
	
	@GetMapping("getbyid/{id}")
	public Optional<Hotel> gethotelbyid(@PathVariable("id") String id) {
		return hotelRepository.findById(id);
	}
	
	@GetMapping("getbyrate/{maxrate}")
	public List<Hotel> getbyratepernight(@PathVariable("maxrate") Integer maxrate){
		
		List<Hotel> hotels = hotelRepository.findByratepernightLessThan(maxrate);
		return hotels;
		
	}
	
	@GetMapping("/findbycity/{city}")
	public List<Hotel> getbycity(@PathVariable("city") String city){
		
		List<Hotel> hotels = hotelRepository.findByCity(city);
		
		return hotels;
	}
	
	@GetMapping(value = "/findbycountry/{country}")
	public List<Hotel> getbycountry(@PathVariable("country") String country){
				
		return hotelRepository.findByCountry(country);
		
	}
	
	
	
	
}
