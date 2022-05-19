package com.ab.movieinfoservice.service;

import java.util.List;

import com.ab.movieinfoservice.models.Movie;

public interface MovieInforService {

	Movie findBymovieId(String movieId);

	List<Movie> findAll();
}
