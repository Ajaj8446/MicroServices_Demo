package com.example.demo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface UserRepository extends CrudRepository<AppUser, Integer>{
	
	

}
