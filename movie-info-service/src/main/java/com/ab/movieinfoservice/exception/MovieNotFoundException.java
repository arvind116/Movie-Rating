package com.ab.movieinfoservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	private String message;
}
