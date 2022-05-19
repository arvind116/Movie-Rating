package com.ab.movieinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ab.movieinfoservice.models.Movie;

@SpringBootApplication
public class MovieInfoServiceApplication {
	@Bean
	public Movie movie() {
		return new Movie();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieInfoServiceApplication.class, args);
	}

}
