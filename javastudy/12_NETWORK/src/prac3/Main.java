package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) { // throws RuntimeException - 생략 가능(Unchecked Exception)

		String key = "1a21793c69fe2a844369af10ebcae309";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("날짜(yyyymmdd) >>> ");
		String targetDt = sc.next();
		
		try {
			key = URLEncoder.encode(key, "UTF-8");
			targetDt = URLEncoder.encode(targetDt, "UTF-8");
			
		} catch(UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		}
	
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=" + key + "&targetDt=" + targetDt;
		
		String response = getResponse(apiURL);
		
		System.out.println(response);
		
		createFile(response);
		
	}
	
	public static String getResponse(String apiURL) {
		
		HttpURLConnection con = getConnection(apiURL);
		
		try {
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream());
			} else {
				return readBody(con.getErrorStream());
			}
		} catch(IOException e) {
			throw new RuntimeException("API 요청 오류", e);
		}
	}
		
	public static HttpURLConnection getConnection(String apiURL) {
		
		try {
			URL url = new URL(apiURL);
			return (HttpURLConnection)url.openConnection();
			
		} catch(MalformedURLException e) {
			throw new RuntimeException("API 주소 오류", e);
		} catch(IOException e) {
			throw new RuntimeException("API 접속 오류", e);
		}
					
	}
	
	public static String readBody(InputStream in) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			return sb.toString();
			
		} catch(IOException e) {
			throw new RuntimeException("API 응답 오류", e);
			
		}
		
	}
	
	public static void createFile(String content) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\storage\\boxoffice.xml"))) {
			
			bw.write(content);
			bw.flush();			
			
		} catch(IOException e) {
			throw new RuntimeException("파일 생성 오류", e);
			
		}
		
	}
	
	
	
	
	

}
