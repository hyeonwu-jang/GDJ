package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Test {

	public static void main(String[] args) {
		
		
		String ServiceKey = "tuKJQnWosgochz4Xdrz/EnE0fod1HOfyo0ZK7gAZMn7bUHdBQNpbTN6zksDAGe2KOWYJLpKMYuvDJWjBI5aAvQ==";
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			
			urlBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
			urlBuilder.append("?ServiceKey=" + URLEncoder.encode(ServiceKey, "UTF-8"));
			urlBuilder.append("&searchYear=2021").append("&siDo=1100").append("&guGun=1125").append("&type=xml").append("&numOfRows=10").append("&pageNo=1");
			
		} catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader br = null;
		StringBuilder sourceSb = new StringBuilder();
		
		String sbUrl = urlBuilder.toString();
		
		try {
			
			url = new URL(sbUrl);
			con = (HttpURLConnection)url.openConnection();
			
		} catch(MalformedURLException e) {
			System.out.println("API 주소 오류");
			
		} catch(IOException e) {
			System.out.println("API 접속 오류");
		}
		
		BufferedWriter bw = null;
		File file = new File("c:\\storage", "accident.txt");
		
		
		
		try {
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			while((line = br.readLine()) != null) {
				sourceSb.append(line);
			}
			
			br.close();
			
		} catch(IOException e) {
			System.out.println("API 응답 실패");
		}
		
		String source = sourceSb.toString();
		
		try {
			
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(source);

		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
