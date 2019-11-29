package com.office.helloworld.model;

import javax.validation.constraints.NotBlank;

/**
 * @author amandeep.singh
 *
 */
public class Address {
@NotBlank(message = "City cannot be blank")	
private String city;
@NotBlank(message = "Country cannot be blank")
private String country;

protected Address() {
	
}

public Address(String city, String country) {
	
	this.city = city;
	this.country = country;
}

public String getCity() {
	return city;
}

public String getCountry() {
	return country;
}

}
