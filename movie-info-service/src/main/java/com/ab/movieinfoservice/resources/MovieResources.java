package com.ab.movieinfoservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.movieinfoservice.models.Movie;
import com.ab.movieinfoservice.repository.MovieRepo;

@RestController
@RequestMapping("/movies")
public class MovieResources {

	@Autowired
	MovieRepo movieRepo;

	@RequestMapping("/users/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		return movieRepo.findBymovieId(movieId);
	}

	@RequestMapping("/movielist")
	public List<Movie> getAllMovieInfo() {
		return movieRepo.findAll();
	}

}
