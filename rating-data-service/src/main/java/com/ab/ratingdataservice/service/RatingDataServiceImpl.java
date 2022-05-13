package com.ab.ratingdataservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.ratingdataservice.exception.UserNotFoundException;
import com.ab.ratingdataservice.models.UserRating;
import com.ab.ratingdataservice.repository.RatingRepo;

@Service
public class RatingDataServiceImpl implements RatingDataService {
	@Autowired
	RatingRepo ratingRepo;
	@Autowired
	UserRating userRating;
	@Override
	public UserRating findByUserID(String userId){
		if (ratingRepo.findByUserID(userId).isEmpty()) {
			userRating.setUserRatings(null);
			userRating.setMessage("User Not Found");
			throw new UserNotFoundException();
		} else {
			userRating.setUserRatings(ratingRepo.findByUserID(userId));
			userRating.setMessage("User Found");
			return userRating;
		}
	}

}
