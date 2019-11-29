package com.office.helloworld.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.helloworld.model.Hotel;
import com.office.helloworld.repository.HotelRepository;

@Service
public class DAOService {

	Logger log = LoggerFactory.getLogger(DAOService.class);
	@Autowired HotelRepository hotelRepository;

	public Optional<Hotel> gethotelid(String id) {
		// TODO Auto-generated method stub
		log.info("Get hotel by Id Service layer :::::info::");
		log.warn("Get hotel by Id Service layer :::::warn::");
		log.debug("Get hotel by Id Service layer :::::debug::");
		return hotelRepository.findById(id);
	}
	
	
}
