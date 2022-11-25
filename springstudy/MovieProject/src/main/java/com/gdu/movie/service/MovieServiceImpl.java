package com.gdu.movie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
	@Override
	public Map<String, Object> printAllMovies() {
		
		Map<String, Object> movies = new HashMap<String, Object>();
		movies.put("message", "전체 " + movieMapper.selectAllMoviesCount() + "개의 목록을 가져왔습니다.");
		movies.put("list", movieMapper.selectAllMovies());
		movies.put("status", 200);
		return movies;
	}
	
	@Override
	public int selectAllMoviesCount() {
		return movieMapper.selectAllMoviesCount();
	}
	
	
	
	@Override
	public Map<String, Object> printMoviesByQuery(String column, String searchText) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchText", searchText);
		map.put("column", column);
		
		List<MovieDTO> list = movieMapper.selectMoviesByQuery(map);
		
		int status = 0;
		String message = "";
		
		System.out.println(list);
		
		if(list.size() != 0) {
			message = list.size() + "개의 검색 결과가 있습니다.";
			status = 200;
			
		} 
		
		else {
			message = searchText + " 검색 결과가 없습니다.";
			status = 500;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("message", message);
		result.put("list", list);
		result.put("status", status);
		
		return result;
	}
	
	
	
	
	
	
}
