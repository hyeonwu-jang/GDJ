package com.gdu.movie.batch;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.movie.mapper.MovieMapper;

@EnableScheduling
@Component
public class MovieJob {

	@Autowired
	private MovieMapper movieMapper;
	
	@Scheduled(cron = "0 0/1 * * * *")
	public void execute() throws Exception {
		
		File file = null;
		FileWriter out = null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchText", " ");
		map.put("genre", "코미디");
		
		if(movieMapper.selectMoviesByQuery(map).size() == 0) {
			file = new File("error.txt");
			out = new FileWriter(file);
			out.write(map.get("genre") + "검색 결과가 없습니다.");
		} else {
			file = new File("코미디.txt");
			out = new FileWriter(file);
			out.write(movieMapper.selectMoviesByQuery(map).toString());
		}
		out.close();
	}

}
