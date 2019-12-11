package com.office.helloworld.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.helloworld.dto.HotelDTO;
import com.office.helloworld.exception.HotelNotFoundException;
import com.office.helloworld.model.Hotel;
import com.office.helloworld.repository.HotelRepository;

@Service
public class ServiceImpl {

	Logger log = LoggerFactory.getLogger(ServiceImpl.class);
	
	@Autowired 
	HotelRepository hotelRepository;
	
	public List<Hotel> getallhoteldetails(){
		log.info("Get hotel by Id Service layer :::::info::");
		log.warn("Get hotel by Id Service layer :::::warn::");
		log.debug("Get hotel by Id Service layer :::::debug::");
		List<Hotel> hotels = this.hotelRepository.findAll();
		
		if(hotels == null) {
			throw new HotelNotFoundException("There is no hotel in our records !");
		//	throw new NullPointerException(id);  // using this for Junit test case.
		}
		
		return hotels;
	}
	
		
	public Optional<Hotel> gethotelid(String id) {
		// TODO Auto-generated method stub
		log.info("Get hotel by Id Service layer :::::info::");
		log.warn("Get hotel by Id Service layer :::::warn::");
		log.debug("Get hotel by Id Service layer :::::debug::");
		return hotelRepository.findById(id);
	}
	
	public HotelDTO gethoteldetailssbyid(String id){
		
		log.info("Get hotel by Id Service layer :::::info::");
		log.warn("Get hotel by Id Service layer :::::warn::");
		log.debug("Get hotel by Id Service layer :::::debug::");
		
		System.out.println("Value of id "+id);
		Hotel hotel = hotelRepository.findByhotelId(id);
		if(hotel == null) {
			throw new HotelNotFoundException("Hotel not Found, Hotel Id:::"+id);
		//	throw new NullPointerException(id);  // using this for Junit test case.
		}
		System.out.println("check");
		HotelDTO hoteldto = new HotelDTO();
		BeanUtils.copyProperties(hotel, hoteldto);
		return hoteldto;
	}
	
	public Hotel addhoteldetails(Hotel hotel) {
		log.info("Get hotel by Id Service layer :::::info::");
		log.warn("Get hotel by Id Service layer :::::warn::");
		log.debug("Get hotel by Id Service layer :::::debug::");
	 //   Hotel hoteldetail = hotelRepository.save(hotel);
	    Hotel hoteldetail = hotelRepository.insert(hotel);
		return hoteldetail;	
	}
	
	public Hotel updatehoteldetails(Hotel hotel, String id) {
		log.info("Get hotel by Id Service layer :::::info::");
		log.warn("Get hotel by Id Service layer :::::warn::");
		log.debug("Get hotel by Id Service layer :::::debug::");
		Hotel updatehotel = hotelRepository.save(hotel);
		return updatehotel;
	}
	
	public void deletehoteldetails(String id) {
		log.info("Get hotel by Id Service layer :::::info::");
		log.warn("Get hotel by Id Service layer :::::warn::");
		log.debug("Get hotel by Id Service layer :::::debug::");
		hotelRepository.deleteById(id);
	}
	
	public List<Hotel> getbyratedetails(int maxrate){
		log.info("Get hotel by Id Service layer :::::info::");
		log.warn("Get hotel by Id Service layer :::::warn::");
		log.debug("Get hotel by Id Service layer :::::debug::");
		List<Hotel> hotels = hotelRepository.findByratepernightLessThan(maxrate);
		if(hotels==null) {
			throw new HotelNotFoundException("No hotels found with this rate !");
		}
		return hotels;
	}
	
	public List<Hotel> findbycitydetails(String city){
		log.info("Get hotel by Id Service layer :::::info::");
		log.warn("Get hotel by Id Service layer :::::warn::");
		log.debug("Get hotel by Id Service layer :::::debug::");
		List<Hotel> hotels = hotelRepository.findByCity(city);
		
		if(hotels==null) {
			throw new HotelNotFoundException("There is no hotel for this city:: !"+city);
		}
		return hotels;
	}
	
	public List<Hotel> findbycountrydetails(String country){
		log.info("Get hotel by Id Service layer :::::info::");
		log.warn("Get hotel by Id Service layer :::::warn::");
		log.debug("Get hotel by Id Service layer :::::debug::");
		List<Hotel> hotels =hotelRepository.findByCountry(country);
		if(hotels==null) {
			throw new HotelNotFoundException("There is no hotel for this city:: !"+country);
		}
		return hotels;
	}

}
