package com.ab.ratingdataservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.ratingdataservice.models.UserRating;
import com.ab.ratingdataservice.repository.RatingRepo;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {
	@Autowired
	UserRating userRating;
	@Autowired
	RatingRepo ratingRepo;

	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		userRating.setUseRatings(ratingRepo.findByUserID(userId));
		return userRating;
	}

}
