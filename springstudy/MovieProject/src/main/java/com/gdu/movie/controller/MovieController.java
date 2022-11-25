package com.gdu.movie.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.movie.service.MovieService;
import com.gdu.movie.util.SecurityUtil;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private SecurityUtil securityUtil;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@ResponseBody
	@GetMapping(value="/searchAllMovies", produces="application/json; charset=UTF-8")
	public Map<String, Object> printAllMovies() {
		return movieService.printAllMovies();
	}
	
	@ResponseBody
	@GetMapping(value="/searchMovie", produces="application/json; charset=UTF-8")
	public Map<String, Object> printMovies(HttpServletRequest request) {
		
		String column = request.getParameter("column");
		String searchText = request.getParameter("searchText");
		
		
		
		return movieService.printMoviesByQuery(column, securityUtil.preventXSS(searchText));
	}
	

}
