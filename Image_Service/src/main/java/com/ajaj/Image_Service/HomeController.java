package com.ajaj.Image_Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private Environment env;

	@RequestMapping("/images")
	public List<String> getImages() {
		List<String> images = new ArrayList<String>();
		images.add("Image 1");
		images.add("Image 2");
		images.add("Image 3");
		
		LocalDateTime dt =  LocalDateTime.now();
		System.out.println(dt);
		
		
		return images;
	}
	
	@RequestMapping("/imagesOfOdd")
	public List<String> getImagesOdd() {
		List<String> images = new ArrayList<String>();
		images.add("Image 1");
		images.add("Image 2");
		images.add("Image 3");
		images.add("Image 4");
		images.add("Image 5");
		
		LocalDateTime dt =  LocalDateTime.now();
		System.out.println(dt);
		images.stream().filter(im -> im.contains("1")).forEach(System.out::print);
		
		return images;
	}
	
	
}
