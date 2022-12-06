package com.gdu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiSearchBook {
	
	public static void main(String[] args) {
		
		String clientId = "4H16u9bbdy10BBd8HKjl";
		String clientSecret = "FSJHue2eMD";
		
		try {
			
			Scanner sc = new Scanner(System.in);
			String query = sc.nextLine();
			query = URLEncoder.encode(query, "UTF-8");
			
			String apiURL = "https://openapi.naver.com/v1/search/book?query=" + query;
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			BufferedReader br = null;
			if(con.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			con.disconnect();
			
			JSONObject obj = new JSONObject(sb.toString());
			
			File dir = new File("C:/download");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			query = URLDecoder.decode(query, "UTF-8");
			
			File file = new File(dir, query + ".html");
			PrintWriter out = new PrintWriter(file);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>검색결과</title>");
			out.println("</head>");
			out.println("<body>");
			
			JSONArray arr = obj.getJSONArray("items");
			
			for(int i = 0; i < arr.length(); i++) {
				JSONObject obj2 = arr.getJSONObject(i);
				String title = obj2.getString("title");
				String link = obj2.getString("link");
				String image = obj2.getString("image");
				
				if(title.contains(query)) {
					
				}
				
				if(title.contains(query)) {
					out.println("<a href='" + link + "'>" + title.replace(query, "<b>" + query + "</b>") + "</a><br>");
				};
				
				out.println("<img src='" + image + "' height='50px' width='50px'>");
				out.println("<hr>");
			}
			
			out.println("</body>");
			out.println("</html>");
			out.close();
			
		} catch(Exception e) {
			
			try {
				File dir = new File("C:/download/log");
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				File file = new File(dir, "error_log.txt");
				PrintWriter out = new PrintWriter(file);
				out.println("예외 메시지 : " + e.getMessage());
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
				Date now = new Date();
				String nowTime = sdf.format(now);
				
				out.println("예외 발생시간 : " + nowTime);
				out.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	
}
