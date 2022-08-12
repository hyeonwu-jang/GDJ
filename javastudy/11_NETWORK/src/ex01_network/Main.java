package ex01_network;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void m1() {
		
		// URL
		// 1. Uniform Resource Locator
		// 2. 정형화된 자원의 경로
		// 웹 주소를 의미
		// 구성
		//
		// http://s
		// 프로토콜://	호스트    / 서버경로 ?파라미터 \ 값& 파라미터\값
		// https://blog.naver.com/rattou_8/222840573499?isInf=true
		// 1) https : secure http, 하이퍼텍스트 전송 프로토콜(통신규약)
		// 2) 호스트 : 서버주소
		// 3) 서버경로 : URL Mapping
		// 4) 파라미터 : 서버로 전송하는 데이터
	
		try {
			
		
			// URL 처리를 위한 URL 클래스
			String apiURL = "https://search.naver.com/search.naver?query=날씨";
			URL url = new URL(apiURL);
		
			// URL 확인
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트 : " + url.getHost());
			System.out.println("파라미터 : " + url.getQuery());
			
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		}
		
	
		}
	
	public static void m2() {
		
		// HttpURLConnection 클래스
 		// 1. 웹 접속을 담당하는 클래스
		// 2. URL 클래스와 함께 사용
		// 3. URLConnection 클래스의 자식 클래스
		// 4. URL 클래스의 openConnection() 메소드를 호출해서 HttpURLConnection 클래스 타입으로 저장
		
		try {
			String apiURL = "https://www.google.com:";
			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			// HTTP 응답 코드
			// 1. 200 : 정상
			System.out.println("정상 : " + HttpURLConnection.HTTP_OK);
			// 2. 40X : 요청이 잘못됨(사용자 잘못)
			System.out.println("Not Found : " + HttpURLConnection.HTTP_NOT_FOUND);
			// 3. 50X : 서버 오류
			System.out.println("Internal Error : " + HttpURLConnection.HTTP_INTERNAL_ERROR);
			
			System.out.println("응답 코드 : " + con.getResponseCode());
			System.out.println("컨텐트 타입 : " + con.getContentType());
			System.out.println("요청 방식 : " + con.getRequestMethod());
			
			con.disconnect();						// 접속 해제(생략 가능)
			
		} catch(MalformedURLException e) {			// URL 클래스 원인
			System.out.println("API 주소 오류");
		} catch(IOException e) {					// HttpURLConnection 클래스 원인
			System.out.println("API 접속 오류");
		} 
		
	}
	
	public static void m3() {
		
		// HttpURlConnection과 스트림
		
		try {
			
			String apiURL = "http://www.naver.com";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
																				// byte 스트림(텍스트로 이루어진 웹사이트를 inputStream으로 받으면 글자가 깨져서 InputStreamReader 사용해야함
			
			// 바이트 입력 스트림
			InputStream in = con.getInputStream();
			
			// 문자 입력 스트림으로 변환
			InputStreamReader reader = new InputStreamReader(in);
			
			// 모두 읽어서 StringBuilder에 저장
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[100];		// 100글자씩 처리
			int readCnt = 0; 					// 실제로 읽은 글자 수
			
			while((readCnt = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCnt);
			}
			
			// StringBuilder의 모든 내용을 C:\\storage\\naver.html 로 내보내기
			
			File file = new File("c:\\storage", "naver.html");
			FileWriter fw = new FileWriter(file); 						// 텍스트를 내보내기 때문에 FileWriter 사용
			
			fw.write(sb.toString());
			
			fw.close();
			reader.close();
			con.disconnect();
			
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
		} catch(IOException e) {
			System.out.println("API 접속 및 연결 오류");
		}
		
	}
	
	
	public static void main(String[] args) {
		
//		m1();
//		m2();
		m3();

	}

}
