package ex04_input;

import java.util.Scanner;

public class Ex03_Practice {

	public static void main(String[] args) {
		
		// 연습. char 타입의 성별을 입력 받기
		System.out.println("성별(남/여)을 입력하세요 >>> ");
		
		Scanner sc = new Scanner(System.in);
		
		char gender = sc.next().charAt(0);
		
		
		
		
		
		
		
		// 연습. 대문자 6자리로 구성된 인증코드 작성하기 (StringBuilder 활용)
		StringBuilder sbCode = new StringBuilder();
		for(int n = 1; n <= 6; n++) {
			sbCode.append((char)((int)((Math.random() * 26) + 'A')));
		}
		String code = sbCode.toString();
				
		System.out.println(code);
		
		
		// String code;
		
		
		// 연습. 1 2 3 4 5 6 7 8 9 10 만들기 (StringBuilder 활용)
		StringBuilder sbPaging = new StringBuilder();
		for(int n = 1; n <= 10; n++) {
			sbPaging.append(n + " ");
		}
		String paging = sbPaging.toString();
		System.out.println(paging);
		
		
		// 연습
		// 6자리 영문(대문자 + 소문자) 인증번호 만들기
		
		StringBuilder sbDoubleCode = new StringBuilder();
		for(int n = 1; n <= 6; n++) {
			if(Math.random() > 0.5) {
			sbDoubleCode.append((char)((int)((Math.random() * 26) + 'a')));
			} else {
			sbDoubleCode.append((char)((int)((Math.random() * 26) + 'A')));
			}
			
		} 
		String DoubleCode = sbDoubleCode.toString();
		System.out.println(DoubleCode);
		
		
	}

}
