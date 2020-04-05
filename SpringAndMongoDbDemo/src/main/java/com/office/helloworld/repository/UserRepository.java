package com.office.helloworld.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.office.helloworld.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);
}
