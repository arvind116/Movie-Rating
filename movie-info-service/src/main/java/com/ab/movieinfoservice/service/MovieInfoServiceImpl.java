package com.ab.movieinfoservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.movieinfoservice.models.Movie;
import com.ab.movieinfoservice.repository.MovieRepo;

@Service
public class MovieInfoServiceImpl implements MovieInforService {
	@Autowired
	MovieRepo movieRepo;
	@Autowired
	Movie movie;

	@Override
	public Movie findBymovieId(String movieId) {
		movie = movieRepo.findBymovieId(movieId);
		return movie;
	}

	@Override
	public List<Movie> findAll() {
		return movieRepo.findAll();
	}

}
