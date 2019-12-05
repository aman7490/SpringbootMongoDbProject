package com.office.helloworld.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.helloworld.dao.DaoLayer;
import com.office.helloworld.dto.HotelDTO;
import com.office.helloworld.model.Hotel;
import com.office.helloworld.repository.HotelRepository;

@Service
public class ServiceImpl {

	Logger log = LoggerFactory.getLogger(ServiceImpl.class);
	
	@Autowired HotelRepository hotelRepository;
	@Autowired DaoLayer daoLayer;

	public Optional<Hotel> gethotelid(String id) {
		// TODO Auto-generated method stub
		log.info("Get hotel by Id Service layer :::::info::");
		log.warn("Get hotel by Id Service layer :::::warn::");
		log.debug("Get hotel by Id Service layer :::::debug::");
		return hotelRepository.findById(id);
	}
	
	public HotelDTO gethoteldetailssbyid(String id){
		
		System.out.println("Value of id "+id);
		Hotel hotel = daoLayer.gethoteldetailbyid(id);
		System.out.println("check");
		HotelDTO hoteldto = new HotelDTO();
		BeanUtils.copyProperties(hotel, hoteldto);
		
		return hoteldto;
	}
	
}
