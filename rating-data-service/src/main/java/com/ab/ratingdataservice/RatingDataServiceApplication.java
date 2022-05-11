package com.ab.ratingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ab.ratingdataservice.models.UserRating;

@SpringBootApplication
public class RatingDataServiceApplication {
@Bean
public UserRating userRating() {
	return new UserRating();
}

	public static void main(String[] args) {
		SpringApplication.run(RatingDataServiceApplication.class, args);
	}

}
