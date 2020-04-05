package com.office.helloworld.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
	
@Id
private String id;
@NotBlank(message ="username cannot bank")
private String username;
@NotBlank(message="password cannot blank")
private String password;
private String roles;
private String permissions;
private int active;
public User(String id,@NotBlank String username, @NotBlank String password, String roles, String permissions) {
	
	this.id=id;
	this.username = username;
	this.password = password;
	this.roles = roles;
	this.permissions = permissions;
	this.active = 1;
}
public String getId() {
	return id;
}
public String getUsername() {
	return username;
}
public String getPassword() {
	return password;
}
public String getRoles() {
	return roles;
}
public String getPermissions() {
	return permissions;
}
public int getActive() {
	return active;
}

public void setId(String id) {
	this.id = id;
}
public void setUsername(String username) {
	this.username = username;
}
public void setPassword(String password) {
	this.password = password;
}
public void setRoles(String roles) {
	this.roles = roles;
}
public void setPermissions(String permissions) {
	this.permissions = permissions;
}
public void setActive(int active) {
	this.active = active;
}
public List<String> getRolesList(){
	if(this.roles.length()>0) {
		return Arrays.asList(this.roles.split(","));
	}
	return new ArrayList<String>();
}
public List<String> getPermissionList(){
	if(this.permissions.length()>0) {
		return Arrays.asList(this.permissions.split(","));
	}
	return new ArrayList<>();
}





	

}
