package com.ab.moviecatalogservice.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ab.moviecatalogservice.models.CatalogItem;
import com.ab.moviecatalogservice.models.Movie;
import com.ab.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingdata/users/" + userId,
				UserRating.class);

		return ratings.getUserRatings().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/moviedesc/" + rating.getMovieId(),
					Movie.class);
			return new CatalogItem(movie.getName(), movie.getDescr(), rating.getRating());
		}).collect(Collectors.toList());
	}

	@PostMapping("/addtomovie")
	public ResponseEntity<Movie> addtomovie(@RequestBody Movie movie) throws URISyntaxException {
		Movie newMovie = restTemplate.postForObject("http://localhost:8082/movies/addtomovie", movie, Movie.class);
		return ResponseEntity.created(new URI("/movies/moviedesc/" + newMovie.getMovieId())).body(movie);
	}

	@PutMapping("updatemovie/{id}")
	public ResponseEntity<Movie> updateMovieInfo(@RequestBody Movie movieDesc, @PathVariable("id") String movieId)
			throws URISyntaxException {
		movieDesc.setMovieId(movieId);
		restTemplate.put("http://localhost:8082/movies/updatemovie/" + movieId, movieDesc);
		return ResponseEntity.created(new URI("/movies/moviedesc/" + movieDesc.getMovieId())).body(movieDesc);
	}

	@DeleteMapping("deletemovie/{id}")
	public String deletemovie(@PathVariable("id") int movieId) {
		restTemplate.delete("http://localhost:8082/movies/deletemovie/" + movieId);
		return "Deleted successfully";
	}
}