package com.ab.ratingdataservice.resources;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.ratingdataservice.models.Rating;
import com.ab.ratingdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {
//	@RequestMapping("/{movieId}")
//	public Rating getRating(@PathVariable("movieId") String movieId) {
//		return new Rating(movieId,4);
//	}
	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = java.util.Arrays.asList(new Rating("qwer", 4), new Rating("asdf", 3),
				new Rating("zxcv", 5));
		UserRating userRating= new UserRating();
		userRating.setUseRatings(ratings);
		return userRating;
	}

}
