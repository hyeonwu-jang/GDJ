package com.gdu.app05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.service.MovieService;

@Controller
public class MyController3 {
	
	@Autowired
	private MovieService movieService;

	@GetMapping("movie")
	public String movie() {
		return "movie";
	}
	
	@ResponseBody
	@GetMapping("movie/boxOfficeList")
	public String boxOfficeList(String targetDt) {
		
		return movieService.getBoxOffice(targetDt);
	}
	
}