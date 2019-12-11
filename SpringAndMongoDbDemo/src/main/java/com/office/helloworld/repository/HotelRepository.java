package com.office.helloworld.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.office.helloworld.model.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

	List<Hotel> findByratepernightLessThan(Integer max);
	
	@Query(value= "{'address.city':?0}")
	List<Hotel> findByCity(String city);
	
	@Query(value= "{'address.country':?0}")
	List<Hotel> findByCountry(String country);
	
	@Query(value= "{'_id':?0}")
	Hotel findByhotelId(String Id);
	
	
}
