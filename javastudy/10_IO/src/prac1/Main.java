package prac1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void m1() {
		
		// C:\\storage\\prac1.txt 파일을 
		// 1글자씩 읽어서
		// C:\\storage\\prac1_copy.txt 파일로 보내기
		
		// FileWriter, FileReader 사용
		// int read() 메소드 사용
		
		// 걸린 시간 출력하기
		
		File file = new File("c:\\storage", "prac1.txt");				// Reader용 파일
		File file2 = new File("c:\\storage", "prac1_copy.txt");			// Writer용 파일
		
		FileReader fr = null;											// FileReader 초기화
		FileWriter fw = null;											// FileWirter 초기화
		
		try {
			fr = new FileReader(file);									// reader 파일 선언
			fw = new FileWriter(file2);									// writer 파일 선언
			
			int c;														// 1글자씩 읽을 int타입 변수 c 선언
			
			long begin = System.currentTimeMillis();
			while((c = fr.read()) != -1) {								// 변수 c에 FileReader로 읽어온 file을 1글자씩 가져와서 c에 대입하고, 그 값이 -1이 반환되기 전까지 계속 반복
				fw.write(c);											// 반복하면서 FileWriter를 이용하여 fw 변수가 file이 대입된 c를 이용하여 write 메소드를 호출.
			}
			long end = System.currentTimeMillis();
			
			System.out.println("복사시간 : " + (end - begin) * 0.001 + "초");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(fw != null) fw.close();
				if(fr != null) fr.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	
	public static void m2() {
		
		// m1() 메소드 다시 풀기
		
		// 100글자씩 읽어서 보내기
		// BufferedReader, BufferedWriter 사용
		
		File src = new File("c:\\storage", "prac1.txt");
		File cpy = new File("c:\\storage", "prac1_copy.txt");
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader(src));
			bw = new BufferedWriter(new FileWriter(cpy));
			
			char[] cbuf = new char[100];
			int readCnt = 0;
			
			long begin = System.currentTimeMillis();
			while((readCnt = br.read(cbuf)) != -1) {
				
				bw.write(cbuf, 0, readCnt);
				
			}
			long end = System.currentTimeMillis();
			
			System.out.println("복사시간 : " + (end - begin) * 0.001 + "초");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
				if(br != null) {
					br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		m2();

	}

}
