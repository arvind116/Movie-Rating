package com.ab.ratingdataservice.service;

import com.ab.ratingdataservice.exception.UserNotFoundException;
import com.ab.ratingdataservice.models.UserRating;

public interface RatingDataService {

	UserRating findByUserID(String userId) throws UserNotFoundException;
}
