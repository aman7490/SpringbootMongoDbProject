package com.office.helloworld.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.office.helloworld.dto.HotelDTO;
import com.office.helloworld.exception.HotelNotFoundException;
import com.office.helloworld.model.Hotel;
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
	private ServiceImpl serviceimpl;

	
/*	constructor of controller class were creating problem while mock testing*/

	@GetMapping("/all")
	public List<Hotel> getallhotels() {
		log.info("Fetching all hotels resource");
		log.warn("Fetching all hotels resource");

		return serviceimpl.getallhoteldetails();
	}

	@PostMapping("/add")
	public Hotel addhotel(@Valid @RequestBody Hotel hotel) {
		
		log.info("Add hotels hotels resource - info");
		log.warn("Add hotels resource - warn");
		log.debug("Add hotels - debug");

		return serviceimpl.addhoteldetails(hotel);
		
	}

	@PutMapping("/update/{id}")

	public Hotel updatehotel(@RequestBody Hotel hotel) {
	log.info("update hotels hotels resource - info");
		log.warn("update hotels resource - warn");
		log.debug("update hotels - debug");
		return serviceimpl.updatehoteldetails(hotel);
	
	}

	@DeleteMapping("/delete/{id}")
	public void deletehotel(@PathVariable("id") String id) {

		log.info("delete hotels hotels resource - info");
		log.warn("delete hotels resource - warn");
		log.debug("delete hotels - debug");
		
		serviceimpl.deletehoteldetails(id);


	}
  // this method have no use coz here we are using optional, so created new one with same func.
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
	public Hotel gethoteldetailsbyid(@PathVariable("id") String id){
		log.info("getbyid2 hotels hotels resource - info");
		log.warn("getbyid2 hotels resource - warn");
		log.debug("getbyid2 hotels - debug");
		
		return serviceimpl.gethoteldetailssbyid(id);
		
	}
	
	
	
	@GetMapping("getbyrate/{maxrate}")
	public List<Hotel> getbyratepernight(@PathVariable("maxrate") Integer maxrate) {
		
		log.info("getbyrate hotels hotels resource - info");
		log.warn("getbyrate hotels resource - warn");
		log.debug("getbyrate hotels - debug");


		return serviceimpl.getbyratedetails(maxrate);

	}

	@GetMapping("/findbycity/{city}")
	public List<Hotel> getbycity(@PathVariable("city") String city) {
		log.info("findbycity hotels hotels resource - info");
		log.warn("findbycity hotels resource - warn");
		log.debug("findbycity hotels - debug");

		return serviceimpl.findbycitydetails(city);
	}

	@GetMapping(value = "/findbycountry/{country}")
	public List<Hotel> getbycountry(@PathVariable("country") String country) {
		log.info("findbycountry hotels hotels resource - info");
		log.warn("findbycountry hotels resource - warn");
		log.debug("findbycountry hotels - debug");
		
		return serviceimpl.findbycountrydetails(country);

	}

}
