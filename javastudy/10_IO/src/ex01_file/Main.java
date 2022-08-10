package ex01_file;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Main {

	public static void m1() {
	
		// File 클래스
		// 1. 패키지 : java.io
		// 2. 파일 및 디렉터리 관리
		// 3. 생성 방법
		// 	1) new File("경로", "파일")
		//	2) new File("파일")
		// 4. 윈도우의 경로 구분 방법 : 백슬래시(\)
		// 5. 리눅스의 경로 구분 방법 : 슬래시(/)
		
		// 폴더(디렉터리) 만들기
		File dir = new File("C:\\storage");			// '\' 하나는 이스케이프 문자로 인식하여 두개 사용
		
		// 존재하지 않으면 만들겠다.
		if(dir.exists() == false) {	// if(!dir.exists())
			dir.mkdirs();
		}
		
		// 존재하면 삭제하겠다.
		else {
			// dir.delete();	// 지금 지운다.
			dir.deleteOnExit();		// JVM이 종료되면 지운다.
		}
	}
	
		
	public static void m2() {
		
		File file = new File("C:\\storage", "my.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			else {
				file.delete();
			}
		} catch(IOException e) {
			// 개발할 때 넣는 catch 블록 코드
			e.printStackTrace();	// 에러를 콘솔에 찍어라.
		}
	}
	
	public static void m3() {
		
		File file = new File("C:\\storage", "my.txt");
		
		System.out.println("파일명 : " + file.getName());
		System.out.println("경로 : " + file.getParent());
		System.out.println("전체경로(경로 + 파일명) : " + file.getPath());
		
		System.out.println("디렉터리인가? " + file.isDirectory());
		System.out.println("파일인가? " + file.isFile());
		
		long lastModifiedDate = file.lastModified();
		System.out.println("수정한 날짜 : " + lastModifiedDate);
	
		String lastModified = new SimpleDateFormat("a hh:mm yyyy-MM-dd").format(lastModifiedDate);	// 객체 생성과 동시에 메소드 호출 new ObjectClass . method();
		
		System.out.println("수정한날짜 : " + lastModified);
		// 오전 09:49 2022-08-10
		
		long size = file.length();	// byte 단위로 출력
		System.out.println("파일크기 : " + size + "byte");
		
	}
	
	public static void m4() {
		
		File dir = new File("c:\\GDJ");
		
		File[] list = dir.listFiles();	// 디렉터리 내부의 모든 파일/디렉터리를 File 객체로 가져옴
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i].getName());
		}
	}
	
	
	public static void q1() {
		

//		File dir = new File("c:\\GDJ");
//		File[] list = dir.listFiles();
//		
//		int dirCnt = 0;
//		int fileCnt = 0;
//		int listLength = 0;
//		
//		for(int i = 0; i < list.length; i++) {
//			
//			Long lastModifiedDate = list[i].lastModified();
//			String lastModified = new SimpleDateFormat("yyyy-MM-dd a hh:mm").format(lastModifiedDate);
//			
//			if(list[i].isHidden()) {
//				continue;
//			} else if(list[i].isFile()) {
//				System.out.println(lastModified + "\t\t" + list[i].length() + " " + list[i].getName());
//				fileCnt++;
//				listLength += list[i].length();
//			} else {
//				System.out.println(lastModified + "\t" + "<DIR>\t" + list[i].getName());
//				dirCnt++;
//			}
//		}
//
//		System.out.println("\t\t" + fileCnt + "개 파일 \t" + listLength + "바이트");
//		System.out.println("\t\t" + dirCnt + "개 디렉터리");

																														//		.git
																														//2022-08-02 오전 08:58		363 .gitignore
																														//2022-08-03 오전 08:54	<DIR>	.metadata
																														//2022-07-18 오후 12:38	<DIR>	bootstudy
																														//2022-07-18 오후 12:38	<DIR>	dbstudy
																														//2022-07-18 오후 12:38	<DIR>	images
																														//2022-08-09 오후 05:04	<DIR>	installer
																														//2022-08-10 오전 09:07	<DIR>	javastudy
																														//2022-07-18 오후 12:38	<DIR>	jspstudy
																														//2022-08-02 오전 08:58		5 README.md
																														//2022-07-18 오후 12:38	<DIR>	springstudy
																														//2022-07-18 오후 12:38	<DIR>	webstudy
																														//2개 파일 	368바이트
																														//9개 디렉터리

		
		// 강사님 풀이
		
			File dir = new File("c:\\GDJ");
			File[] list = dir.listFiles();
			
			int dirCnt = 0;
			int fileCnt = 0;
			long totalSize = 0;
			
			for(File file : list) {
				if(file.isHidden()) {
					continue;
				}
				String lastModified = new SimpleDateFormat("yyyy-MM-dd a hh:mm").format(file.lastModified());
				String directory = " ";
				String size = "";
				
				
				if(file.isDirectory()) {
					directory = "<DIR>";
					size = "     ";
					dirCnt++;
				} else {
					directory = "       ";
					size = new DecimalFormat("#,##0").format(file.length()) + "";
					fileCnt++;
					totalSize += Long.parseLong(size.replace(",", ""));
				}
				
				String name = file.getName();
				System.out.println(lastModified + " " + directory + " " + size + " " + name);
			}
			System.out.println(dirCnt + "개 디렉터리");
			System.out.println(fileCnt + "개 파일 " + new DecimalFormat("#,##0").format(totalSize) + "바이트");
//		
		}
	
	public static void m5() {
		
		// 플랫폼마다 다른 경로 구분자 지원
		File file = new File("C:" + File.separator + "storage" + File.separator + "my.txt");
		System.out.println(file.getName());
		
	}
	
	public static void q2() {
		
		// c:\storage 디렉터리 삭제하기 --- 내용물이 있으면 삭제가 안됨.
		String sep = File.separator;
		File dir = new File("c:" + sep + "storage");
		File file = new File("c:" + sep + "storage", "my.txt");
		
		if(file.exists()) {
			file.delete();
		}
		
		if(dir.exists()) {
			dir.delete();	
		}
		
	}
	

	public static void main(String[] args) {
	
		q2();
		

	}

}
