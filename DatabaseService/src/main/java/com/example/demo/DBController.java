package com.example.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DBController {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	UserRepository repository;

	@RequestMapping(method = RequestMethod.GET, path = "/getUserList")
	public AppUsrHolder getUserList() {
		AppUsrHolder appUsrHolder = new AppUsrHolder();
		List<AppUser> a = (List<AppUser>) repository.findAll();
		appUsrHolder.setAppUser(a);
		return appUsrHolder;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/addUser")
	public void addUser(@RequestBody AppUser appUser) {
		// Password is Encodded
		System.out.print(appUser.getUsername());
		System.out.print(appUser.getPassword());
		appUser.setPassword(encoder.encode(appUser.getPassword()));
		System.out.print(appUser.getPassword());
		repository.save(appUser);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/deleteUser")
	public void deleteUser(@RequestBody AppUser appUser) {
		repository.deleteById(appUser.getId());
	}
	
	
}
