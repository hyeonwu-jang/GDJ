package prac2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	
	public static void q1() {
		
		// eclipse-jee-2021-03-R-win32-x86_64.zip 복사하기
		// 복사할 파일명은 eclipse.zip
		
		File file = new File("c:\\GDJ\\installer", "eclipse-jee-2021-03-R-win32-x86_64.zip");	// Input 파일 통로
	//	FileInputStream fis = null;
		
		File fileCopy = new File("c:\\GDJ\\installer", "eclipse.zip");	// Output 파일 통로
	//	FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(new FileOutputStream(fileCopy));
			
			
			byte[] b = new byte[1024];		// 1kb
			int readByte = 0;
			
			while((readByte = bis.read(b)) != -1) {
				bos.write(b, 0, readByte);
			}
						
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bis != null) {
					bis.close();
				}
				if(bos != null) {
					bos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	public static void q2() {
		
		// 파일 이동하기 (원본 삭제)
		
		File src = new File("c:\\GDJ\\installer", "eclipse.zip");

		File dir = new File("c:\\storage");		// 폴더가 없으면 폴더 생성하기.(이동을 위해)
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File des = new File("c:\\storage", "eclipse.zip");	// src.getName() 가능 = eclipse.zip
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(des));
			
			byte[] b = new byte[1024];
			int readByte = 0;
			
			while((readByte = bis.read(b)) != -1) {
				bos.write(b, 0, readByte);
			}
			
			bos.close();									// 스트림을 닫아놓은 뒤 파일 삭제, 닫아놓지 않으면 삭제가 안됨.
			bis.close();
			
			// 원본과 복사본의 크기가 동일하면 원본을 제거
			if(src.length() == des.length()) {
				src.deleteOnExit();							// delete() 함수는 실행 즉시 파일을 삭제하고 deleteOnExit() 함수는 JVM이 종료할때 파일을 삭제한다
			}	
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	
	public static void main(String[] args) {

//		q1();
		q2();
	}

}
