package ex01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
//	1.Class.forName() 을 이용해서 드라이버 로드
//	2.DriverManager.getConnection() 으로 연결 얻기
//	3.Connection 인스턴스를 이용해서 Statement 객체 생성
//	4.Statement 객체의 결과를 ResultSet 이나 int에 받기
		
/*********************************************************************************/
		
		// OracleDriver 열기(메모리에 로드하기)
		// 1. oracle.jdbc.OracleDriver
		// 2. oracle.jdbc.driver.OracleDriver  // 모두 사용 가능
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch(ClassNotFoundException e) {
			System.out.println("OracleDriver 로드 실패");
		}
		
		// DriverManager로부터 Connection 받아오기
		Connection con = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";	// Oracle XE 버전 기준 주소(사용하는 DB마다 url은 달라짐)
			String user = "SCOTT";	// 대소문자 상관 없음
			String password = "TIGER";	// 계정 만들 때 사용한 대소문자를 지켜야 함
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB접속성공");
		} catch(SQLException e) {
			System.out.println("DB접속정보 오류");
		}
		
		// Connection 종료
		// JDBC에서는 Connection을 닫는 것이 굉장히 중요!
		try {
			if(con != null)
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
