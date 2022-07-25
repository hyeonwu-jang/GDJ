package ex04_input;

import java.util.Scanner;

public class Ex02_Scanner {

	public static void main(String[] args) {
		
		// java.util.Scanner 클래스
		// 데이터타입별로 입력 받을 수 있는 메소드를 제공
		// int	  : nextInt()
		// long   : nextLong()
		// double : nextDouble()
		// String : nextLine() - 공백 포함 입력, next() - 공백 포함 불가능
		
		
		Scanner sc = new Scanner(System.in); // 객체 sc는 System.in(키보드)으로부터 입력을 받는다.
		
		System.out.print("이름을 입력하세요 >>> ");
		String name = sc.next(); // next는 String 입력받는 메소드
		
		System.out.print("나이를 입력하세요 >>> ");
		int age = sc.nextInt(); // nextInt는 int 입력받는 메소드
		
		System.out.println(name);
		System.out.println(age);
		
		// 연습. char 타입의 성별을 입력 받기
		System.out.println("성별(남/여)을 입력하세요 >>> ");
		char gender = sc.next().charAt(0);
		System.out.println(gender);

		sc.close(); // 생략이 가능하다.
		
		// -------------------------------------------------------------------------------------------
		
		// 연습. 대문자 6자리로 구성된 인증코드 작성하기 (StringBuilder 활용)
		StringBuilder sbCode = new StringBuilder();
		
		
		
		for(int n = 1; n <= 6; n++) {
			sbCode.append((char)((int)((Math.random() * 26) + 'A')));
		}
		String code = sbCode.toString();
		System.out.println("인증코드 : " + code);
		
		
	
		// 연습. 1 2 3 4 5 6 7 8 9 10 만들기 (StringBuilder 활용)
		StringBuilder sbPaging = new StringBuilder();
		
		
		
		for(int n = 1; n <= 10; n++) {
			sbPaging.append(n + " ");	
		}
		String paging = sbPaging.toString();
		System.out.print(paging);
		
		
		
		
		
	
		
		
	}

}
