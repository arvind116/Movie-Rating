package com.ab.moviecatalogservice.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {
	private List<Rating> userRatings;
	private String message;
}
