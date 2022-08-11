package ex03_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONReader {		// Reader는 데이터를 자바 String으로 저장하기 위함.

	public static void main(String[] args) {
		
		File file = new File("c:\\storage", "product.json");											// 파일 경로 설정
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {								// try() -> 데이터를 읽는 BufferedReader br 변수 생성
			
			StringBuilder sb = new StringBuilder();														// StringBuilder 생성
			String line = null;																			// file 데이터를 가져올 String 변수 line 선언 (Null)
			while((line = br.readLine()) != null) {														// while 반복문 -> br로 읽어온 데이터의 첫번째 줄을 line에 대입하고, null값이 아닐때까지 반복
				sb.append(line);																		// line에 있는 데이터를 StringBuilder sb로 입력(append)
			}
			String str = sb.toString();																	// String 변수 str에 sb에 입력된 데이터를 str로 출력(toString)
			
			JSONArray arr = new JSONArray(str);															// 데이터의 형식이 배열로 되어있으니 JSONArray 배열 선언하고 str에 입력된 데이터를 받아옴
			
			List<Product> products = new ArrayList<Product>();											// 객체를 담을 List 타입 ArrayList 생성
			
			for(int i = 0, length = arr.length(); i < length; i++) {									// 
				
				JSONObject obj = arr.getJSONObject(i);
				Product product = new Product();
				product.setNumber(obj.getString("number"));
				product.setName(obj.getString("name"));
				product.setPrice(Integer.parseInt(obj.getString("price")));
				products.add(product);
			}
			
			for(Product product : products) {
				System.out.println(product);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
