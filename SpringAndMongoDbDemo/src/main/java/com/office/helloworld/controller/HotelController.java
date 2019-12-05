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

import com.office.helloworld.dto.HotelDTO;
import com.office.helloworld.exception.HotelNotFoundException;
import com.office.helloworld.model.Hotel;
import com.office.helloworld.repository.HotelRepository;
import com.office.helloworld.service.ServiceImpl;

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
	private ServiceImpl serviceimpl;

	public HotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@GetMapping("/all")
	public List<Hotel> getallhotels(Hotel hotel) {
		log.info("Fetching all hotels resource");
		log.warn("Fetching all hotels resource");
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
		
		log.info("Add hotels hotels resource - info");
		log.warn("Add hotels resource - warn");
		log.debug("Add hotels - debug");
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
		log.info("update hotels hotels resource - info");
		log.warn("update hotels resource - warn");
		log.debug("update hotels - debug");
		hotelRepository.save(hotel);

	}

	@DeleteMapping("/delete/{id}")
	public void deletehotel(@PathVariable("id") String id) {

		log.info("delete hotels hotels resource - info");
		log.warn("delete hotels resource - warn");
		log.debug("delete hotels - debug");
		
		hotelRepository.deleteById(id);

	}

	@GetMapping("getbyid/{id}")
	public Optional<Hotel> gethotelbyid(@PathVariable("id") String id) {
		
		Optional<Hotel> hotel = serviceimpl.gethotelid(id);
		
		log.info("getbyid hotels hotels resource - info");
		log.warn("getbyid hotels resource - warn");
		log.debug("getbyid hotels - debug");
		
		
		if(hotel.isPresent() == false) {
			log.warn("hotel not found and exception will occur");
			log.error("hotel not found and exception will occur");
			throw new HotelNotFoundException("id -"+id);
		}  
		return hotel;	
	}

	@GetMapping("getbyhotelid/{id}")
	public HotelDTO gethoteldetailsbyid(@PathVariable("id") String id){
		
		
		return (HotelDTO) serviceimpl.gethoteldetailssbyid(id);
		
	}
	
	
	@GetMapping("getbyrate/{maxrate}")
	public List<Hotel> getbyratepernight(@PathVariable("maxrate") Integer maxrate) {
		
		log.info("getbyrate hotels hotels resource - info");
		log.warn("getbyrate hotels resource - warn");
		log.debug("getbyrate hotels - debug");
		
		List<Hotel> hotels = hotelRepository.findByratepernightLessThan(maxrate);
		return hotels;

	}

	@GetMapping("/findbycity/{city}")
	public List<Hotel> getbycity(@PathVariable("city") String city) {
		log.info("findbycity hotels hotels resource - info");
		log.warn("findbycity hotels resource - warn");
		log.debug("findbycity hotels - debug");
		List<Hotel> hotels = hotelRepository.findByCity(city);

		return hotels;
	}

	@GetMapping(value = "/findbycountry/{country}")
	public List<Hotel> getbycountry(@PathVariable("country") String country) {
		log.info("findbycountry hotels hotels resource - info");
		log.warn("findbycountry hotels resource - warn");
		log.debug("findbycountry hotels - debug");
		return hotelRepository.findByCountry(country);

	}

}
