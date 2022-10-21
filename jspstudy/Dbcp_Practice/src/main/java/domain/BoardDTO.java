package domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	private Long no;
	private String writer;
	private String title;
	private String content;
	private String ip;
	private Long hit;
	private Date create_date;
	private Date modify_date;
}
