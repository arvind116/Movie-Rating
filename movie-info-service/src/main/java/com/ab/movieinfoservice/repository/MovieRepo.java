package com.ab.movieinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ab.movieinfoservice.models.Movie;
@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {

	Movie findBymovieId(String movieId);

}
