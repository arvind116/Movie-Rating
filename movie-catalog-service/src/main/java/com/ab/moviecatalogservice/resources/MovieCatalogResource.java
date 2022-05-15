package com.ab.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		UserRating ratings= restTemplate.getForObject("http://localhost:8083/ratingdata/users/"+userId,UserRating.class);
		
		return ratings.getUserRatings().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/moviedesc/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), movie.getDescr(), rating.getRating());
		}).collect(Collectors.toList());
	}
}