package domain;

import lombok.Data;

@Data
public class Board {
	
	private int boardNo;
	private String writer;
	private String title;
	private String content;
	private String createDate;
	
}
