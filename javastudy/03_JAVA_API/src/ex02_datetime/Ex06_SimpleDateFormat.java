package ex02_datetime;

import java.text.SimpleDateFormat;

import java.util.Date;

public class Ex06_SimpleDateFormat {

	public static void main(String[] args) {
		
		// java.text.SimpleDateFormat 클래스
		// 패턴이 적용된 String 타입의 날짜
		
		Date date1 = new Date();
		java.sql.Date date2 = new java.sql.Date(System.currentTimeMillis()); // 동일한 Date타입의 클래스를 중복해서 사용할 수 없어서 sql 풀네임을 기재하는 것.
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String result1 = sdf.format(date1);
		String result2 = sdf.format(date2);
		
		System.out.println(result1);
		System.out.println(result2);
				
				

	}

}
