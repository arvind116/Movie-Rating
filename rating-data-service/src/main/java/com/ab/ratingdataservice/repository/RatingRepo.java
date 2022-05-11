package com.ab.ratingdataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ab.ratingdataservice.models.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Integer> {

	List<Rating> findByUserID(String userId);




}
