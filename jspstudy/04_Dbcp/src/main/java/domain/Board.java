package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor	// 디폴트 생성자
@AllArgsConstructor // 필드 생성자
@Getter
@Setter
@Builder
@ToString

public class Board {
	private int board_no;
	private String title;
	private String content;
	private Date create_date;
}
