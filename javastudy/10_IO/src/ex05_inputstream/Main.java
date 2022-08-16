package ex05_inputstream;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.List;

import ex04_outputstream.User;

public class Main {
	
	public static void m1() {
		
		File file = new File("c:\\storage", "b1.bin");
		FileInputStream fis = null;
		
		try {
			
			// 바이트 입력 스트림 생성
			fis = new FileInputStream(file);
			
			// 입력 데이터 단위
			//  1. 1개 : int
			//  2. 여러 개 : byte[]
			
			// 모든 정보를 StringBuilder에 저장한 뒤 확인
			StringBuilder sb = new StringBuilder();
			byte[] b = new byte[5];		// 5바이트씩 읽기 위해서 준비
			int readByte = 0;
			
			// int read(byte[] b)
			// 읽은 내용은 byte배열 b에 저장
			// 읽은 바이트 수를 반환
			// 읽은 내용이 없으면 -1 반환
			
			while((readByte = fis.read(b)) != -1) {		// 반환을 위해 readByte 변수 필요?
				
				sb.append(new String(b, 0, readByte));		// append() 에는 char[], offset, length만 지원, 그래서 new String() 활용하여 길이 지정.
			
			}
			
			// 문자를 바이트 스트림으로 읽었기 때문에
			// 문제가 발생
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void m2() {
		
		// 바이트 입력 스트림을 문자 입력 스트림으로 변환하는 InputStreamReader
		
		File file = new File("c:\\storage", "b2.bin");
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
		try {
			
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[5];				// 5글자씩 읽기 위해서
			int readCnt = 0;
			
			while((readCnt = isr.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCnt);
			}
			
			System.out.println(sb.toString());
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(isr != null) {
					isr.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	

	public static void simsimhaeser() {		// 스캐너에서 활용되는 System.in은 바이트 형식으로 받기 때문에 아래와 같이 InputStreamReader로 활용이 가능함.
		
		try {
			
			// System.in : 키보드와 연결된 바이트 스트림
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// FileInputStream(파일) 대신 System.in(키보드)
			
			System.out.print("입력 >>> ");
			String str = br.readLine();
			
			System.out.println(str);
			
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void m3() {
		
		// 변수를 그대로 입력 받는 DataInputStream
		
		File file = new File("c:\\storage", "b3.dat");
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			
			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			
			String name = dis.readUTF();			// readUTF(), writeUTF() 를 활용하여 InputStreamReader를 사용하지 않고 DataInputStream으로 바이트 문자열을 받고 쓸 수 있다.
			int age = dis.readInt();
			double height = dis.readDouble();
			
			System.out.println(name + ", " + age + ", " + height);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dis != null) {
					dis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void m4() {
		
		// 객체를 그대로 입력 받는 ObjectInputStream
		
		File file = new File("c:\\storage", "b4.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			List<User> users = (List<User>)ois.readObject();		// Object를 받아오는 것이라 경고가 뜸. -> casting
			User user = (User)ois.readObject();
			
			for(User u : users) {
				System.out.println(u);
			}
			System.out.println(user);
			
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	

	public static void main(String[] args) {

//		m1();
//		m2();
//		m3();
		m4();
//		simsimhaeser();
		
	}

}
