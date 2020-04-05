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
		log.info("Get allhotel Service layer :::::info::");
		log.warn("Get allhotel Service layer :::::warn::");
		log.debug("Get allhotel Service layer :::::debug::");
		List<Hotel> hotels = this.hotelRepository.findAll();
		
		if(hotels == null) {
			throw new HotelNotFoundException("There is no hotel in our records !");
		//	throw new NullPointerException(id);  // using this for Junit test case.
		}
		
		return hotels;
	}
	
		
	public Optional<Hotel> gethotelid(String id) {
		
		log.info("Get hotel Id Service layer :::::info::");
		log.warn("Get hotel Id Service layer :::::warn::");
		log.debug("Get hotel Id Service layer :::::debug::");
		return hotelRepository.findById(id);
	}
	
	public Hotel gethoteldetailssbyid(String id){
		
		log.info("Get hoteldetails by id Service layer :::::info::");
		log.warn("Get hoteldetailswarn by Id Service layer :::::warn::");
		log.debug("Get hoteldetails Iddebug Service layer :::::debug::");
		
	
		Hotel hotel = hotelRepository.findByhotelId(id);
		if(hotel == null) {
			throw new HotelNotFoundException("Hotel not Found, Hotel Id:::"+id);
		//	throw new NullPointerException(id);  // using this for Junit test case.
		}
		

		return hotel;
	}
	
	public Hotel addhoteldetails(HotelDTO hoteldto) {
		log.info("Get aadhotel info Service layer :::::info::");
		log.warn("Get addhotel warn Service layer :::::warn::");
		log.debug("Get addhotels debug Service layer :::::debug::");
		
		Hotel hotel = new Hotel();
		
		BeanUtils.copyProperties(hoteldto, hotel);
		return hotelRepository.insert(hotel);	
	}
	
	public Hotel updatehoteldetails(HotelDTO hoteldto) {
		log.info("Get updatehotel Service layer :::::info::"); 
		log.warn("Get updatehotels Service layer :::::warn::");
		log.debug("Get updatehotelss Service layer :::::debug::");

		return hotelRepository.save(hoteldto);
	}
	
	public void deletehoteldetails(String id) {
		log.info("Get Delete hotel Service layer1 :::::info::");
		log.warn("Get Delete hotel Service layer2:::::warn::");
		log.debug("Get Delete hotel Service layer3 :::::debug::");
		hotelRepository.deleteById(id);
	}
	
	public List<Hotel> getbyratedetails(int maxrate){
		log.info("Get hotel by ratedetails Service layer :::::info::"); 
		log.warn("Get hotel by ratedetails warn layer :::::warn::"); 
		log.debug("Get hotel by ratedetails debug layer :::::debug::");  
		List<Hotel> hotels = hotelRepository.findByratepernightLessThan(maxrate);
		if(hotels==null) {
			throw new HotelNotFoundException("No hotels found with this rate !");
		}
		return hotels;
	}
	
	public List<Hotel> findbycitydetails(String city){
		log.info("find hotel info by Id Service layer :::::info::");
		log.warn("find hotel warn by Id Service layer :::::warn::");
		log.debug("find hotel debug by Id Service layer :::::debug::");
		List<Hotel> hotels = hotelRepository.findByCity(city);
		
		if(hotels==null) {
			throw new HotelNotFoundException("There is no hotel for this city:: !"+city);
		}
		return hotels;
	}
	
	public List<Hotel> findbycountrydetails(String country){
		log.info("Get hotel country info Service layer :::::info::");
		log.warn("Get hotel country warn Service layer :::::warn::");
		log.debug("Get hotel country debug Service layer :::::debug::");
		List<Hotel> hotels =hotelRepository.findByCountry(country);
		if(hotels==null) {
			throw new HotelNotFoundException("There is no hotel for this city:: !"+country);
		}
		return hotels;
	}

}
