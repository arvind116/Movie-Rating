package com.ab.ratingdataservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.ratingdataservice.exception.UserNotFoundException;
import com.ab.ratingdataservice.models.UserRating;
import com.ab.ratingdataservice.service.RatingDataService;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {
	@Autowired
	RatingDataService ratingDataService;
	@Autowired
	UserNotFoundException userNotFoundException;
	@Autowired
	UserRating userRating;

	@RequestMapping("/users/{userId}")
	public ResponseEntity<UserRating> getUserRating(@PathVariable("userId") String userId) {
		try {
			return new ResponseEntity<UserRating>(ratingDataService.findByUserID(userId),HttpStatus.OK);
			
		} catch (UserNotFoundException userNotFoundException ) {
			return new ResponseEntity<UserRating>(userRating,HttpStatus.CONFLICT);
		}
		
	}

}
