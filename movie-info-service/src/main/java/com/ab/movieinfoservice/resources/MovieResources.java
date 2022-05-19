package com.ab.movieinfoservice.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ab.movieinfoservice.models.Movie;
import com.ab.movieinfoservice.repository.MovieRepo;
import com.ab.movieinfoservice.service.MovieInforService;

@RestController
@RequestMapping("/movies")
public class MovieResources {

	@Autowired
	MovieInforService movieInforService;
	@Autowired
	Movie movie;
	@Autowired
	MovieRepo movieRepo;

	@GetMapping("/moviedesc/{movieId}")
	public ResponseEntity<Movie> getMovieInfo(@PathVariable("movieId") String movieId) {
		return new ResponseEntity<Movie>(movieInforService.findBymovieId(movieId), HttpStatus.FOUND);
	}

	@GetMapping("/movielist")
	public ResponseEntity<List<Movie>> getAllMovieInfo() {
		return new ResponseEntity<List<Movie>>(movieInforService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/addtomovie")
	public ResponseEntity<Movie> addToMovie(@RequestBody Movie movie) throws URISyntaxException {
		movie = movieRepo.save(movie);
		return ResponseEntity.created(new URI("/movies/moviedesc/" + movie.getMovieId())).body(movie);
	}

	@PutMapping("updatemovie/{movieId}")
	public ResponseEntity<Movie> updateMovieDesc(@RequestBody Movie movieDesc,@PathVariable("movieId") String movieId) throws URISyntaxException {
		movie.setId(movieRepo.findBymovieId(movieId).getId());
		movie.setMovieId(movieId);
		movie.setName(movieDesc.getName());
		movie.setDescr(movieDesc.getDescr());
		movieRepo.save(movie);
		return ResponseEntity.created(new URI("/movies/moviedesc/" + movie.getMovieId())).body(movie);
	}
	@DeleteMapping("deletemovie/{movieId}")
	public ResponseEntity<List<Movie>> deleteMovieDesc(@PathVariable("movieId") int id) {
		movieRepo.deleteById(id);
		return new ResponseEntity<List<Movie>>(movieInforService.findAll(), HttpStatus.OK);
	}

}
