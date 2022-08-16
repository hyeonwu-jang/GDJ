package ex04_outputstream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	
	public static void m1() {
							
		
		// FileOutPutStream : 바이트 단위의 데이터 출력(생성) 스트림
		
		// FileOutPutStream = 바이트 기반 파일 / FileWriter = 문자 기반 파일
				
		File file = new File("c:\\storage", "b1.bin");
		FileOutputStream fos = null;
		
		try {
			// c:\\storage\\b1.bin 파일과 연결되는 바이트 출력 스트림 생성
			fos = new FileOutputStream(file);
			
			// 출력할 데이터 단위
			//  1. 1개 : int
			//  2. 여러 개 : byte[]
			
			// 출력할 데이터
			int c = 'A';
			String str = "pple Mango 맛있다.";
			byte[] b = str.getBytes(StandardCharsets.UTF_8);	// str.getBytes("UTF-8") 도 가능.
			
			// 출력
			fos.write(c);
			fos.write(b);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void m2() {
		
		// 출력속도 향상을 위한 BufferedOutputStream
		
		File file = new File("c:\\storage", "b2.bin");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			
			String str = "안녕하세요 반갑습니다.";		// String을 byte로 보내기
			byte[] b = str.getBytes("UTF-8");			// getBytes()의 default는 charset이다. 문자열을 charset으로 받아 배열에 반환한다.
			
			bos.write(b);
		
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) {
					bos.close();					// fos 메인 스트림 / bos 보조 스트림 / bos.close() 처럼 보조스트림의 처리만 해줘도 됨.
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void m3() {
		
		// 변수를 그대로 출력하는(내보내는) DataOutputStream
		
		File file = new File("c:\\storage", "b3.dat");
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			
			// 출력할 변수
			String name = "에밀리";
			int age = 30;
			double height = 165.5;
			
			// 출력
			dos.writeUTF(name);						// 변수를 내보낼 떄는 타입에 맞는 메소드를 이용하여 write
			dos.writeInt(age);
			dos.writeDouble(height);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dos != null) {
					dos.close();					
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void m4() {
		
		// 객체를 그대로 출력하는 ObjectOutputStream
		
		File file = new File("C:\\storage", "b4.dat");
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			// 1. User를 3개 저장한 ArrayList
			List<User> users = Arrays.asList(
					
					new User(1, "kim", 30),
					new User(2, "lee", 40),
					new User(3, "choi", 50)
					
			);
			
			// 2. User 1개
			User user = new User(4, "min", 60);
			
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(users);
			oos.writeObject(user);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.close();
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
