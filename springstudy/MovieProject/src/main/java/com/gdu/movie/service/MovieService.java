package com.gdu.movie.service;

import java.util.Map;

public interface MovieService {
	
	public Map<String, Object> printAllMovies();
	
	public int selectAllMoviesCount();
	
	public Map<String, Object> printMoviesByQuery(String column, String searchText);
	
}
