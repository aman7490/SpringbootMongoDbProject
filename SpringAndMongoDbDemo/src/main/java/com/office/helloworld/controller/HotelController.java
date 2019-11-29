package com.office.helloworld.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.office.helloworld.exception.HotelNotFoundException;
import com.office.helloworld.model.Hotel;
import com.office.helloworld.repository.HotelRepository;
import com.office.helloworld.service.DAOService;

/**
 * @author amandeep.singh
 *
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

	Logger log = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private DAOService daoService;

	public HotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@GetMapping("/all")
	public List<Hotel> getallhotels(Hotel hotel) {
		log.info("Fetching all hotels resource");
		List<Hotel> hotels = this.hotelRepository.findAll();
		return hotels;
	}

	/*
	 * public List<Hotel> getallhotels(Hotel hotel){
	 * 
	 * List<Hotel> hotels = hotelRepository.findAll();
	 * 
	 * for (Hotel hotel2 : hotels) {
	 * 
	 * }
	 * 
	 * return hotels;
	 * 
	 * }
	 */

	@PostMapping("/add")
	public ResponseEntity<Object> addhotel(@Valid @RequestBody Hotel hotel) {

		hotelRepository.insert(hotel);
		
		// this below location value will appear in response header with the location, where the records have been saved with their id.
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(hotel.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
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
		
		Optional<Hotel> hotel = daoService.gethotelid(id);
		
		if(hotel.isPresent() == false) {
			throw new HotelNotFoundException("id -"+id);
		}  
		return hotel;	
	}

	@GetMapping("getbyrate/{maxrate}")
	public List<Hotel> getbyratepernight(@PathVariable("maxrate") Integer maxrate) {

		List<Hotel> hotels = hotelRepository.findByratepernightLessThan(maxrate);
		return hotels;

	}

	@GetMapping("/findbycity/{city}")
	public List<Hotel> getbycity(@PathVariable("city") String city) {

		List<Hotel> hotels = hotelRepository.findByCity(city);

		return hotels;
	}

	@GetMapping(value = "/findbycountry/{country}")
	public List<Hotel> getbycountry(@PathVariable("country") String country) {

		return hotelRepository.findByCountry(country);

	}

}
