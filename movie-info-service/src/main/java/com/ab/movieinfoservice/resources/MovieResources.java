package com.ab.movieinfoservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.movieinfoservice.exception.MovieNotFoundException;
import com.ab.movieinfoservice.models.Movie;
import com.ab.movieinfoservice.service.MovieInforService;

@RestController
@RequestMapping("/movies")
public class MovieResources {

	@Autowired
	MovieInforService movieInforService;
	@Autowired
	MovieNotFoundException movieNotFoundException;
	@Autowired
	Movie movie;

	@RequestMapping("/moviedesc/{movieId}")
	public ResponseEntity<Movie> getMovieInfo(@PathVariable("movieId") String movieId) {
		try {
			return new ResponseEntity<Movie>(movieInforService.findBymovieId(movieId),HttpStatus.OK);

		} catch (MovieNotFoundException movieNotFoundException) {

			return new ResponseEntity<Movie>(movie,HttpStatus.CONFLICT);

		}
	}

	@RequestMapping("/movielist")
	public List<Movie> getAllMovieInfo() {
		return movieInforService.findAll();
	}

}
