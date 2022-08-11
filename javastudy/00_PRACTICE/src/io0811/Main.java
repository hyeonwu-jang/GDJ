package io0811;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	
	
	public static void m1() {	// FileWriter 사용해서 1글자 쓰기
	
		File file = new File("c:\\storage\\prac", "m1.txt");
		
		FileWriter fw = null;
		int c = '1';
		char[] cbuf = {'a', 'b', '오', 'd', 'e'};
		
		try {
			
			fw = new FileWriter(file);
			fw.write("dddd");
			fw.write(cbuf + "");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) {
					fw.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public static void m2() {	// FileWriter 사용 try - catch - resources문
		
		File file = new File("c:\\storage\\prac", "m2.txt");
		
		try(FileWriter fw = new FileWriter(file)) {
			
			
			fw.write("\n");
			fw.write("asdfasdfasdfafd");
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}

		
		
		
	}

	public static void m3() {	// FileReader 사용해서 한글자 받아오기
		
		JSONObject obj = new JSONObject();
		obj.put("name", "abc");
		obj.put("age", 10);
	
		JSONObject obj2 = new JSONObject();
		obj2.put("name", "qqq");
		obj2.put("age", 13);
		
		JSONArray arr = new JSONArray();
		arr.put(obj);
		arr.put(obj2);
		
		File file = new File("c:\\storage\\prac", "m3");
		
		
		try(FileWriter fw = new FileWriter(file)) {
			fw.write(arr);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void m4() {	// FileReader 사용해서 여러글자 받아오기
		
	
		// list를 JSON String으로 만들어서
		// C:\\storage\\product.json 파일에 write
		
		List<String> product1 = Arrays.asList("100", "새우깡", "1500");
		List<String> product2 = Arrays.asList("101", "오감자", "2000");
		List<String> product3 = Arrays.asList("102", "죠리퐁", "3000");
		
		List<List<String>> list = Arrays.asList(product1, product2, product3);
		
		
		JSONArray arr = new JSONArray();							
		
		for(List<String> line : list) {
			JSONObject obj = new JSONObject();
			obj.put("number", line.get(0));
			obj.put("name", line.get(1));
			obj.put("price", line.get(2));
			arr.put(obj);

			
		}
		
		File file = new File("c:\\storage\\prac\\", "product.json");
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(file);
			fw.write(arr.toString());
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) {
					fw.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
		
	
	public static void main(String[] args) {
		m4();
	}

}
