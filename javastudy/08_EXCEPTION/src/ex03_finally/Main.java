package ex03_finally;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// finally 블록
		// 1. try-catch문 마지막에 추가하는 블록
		// 2. 언제나 마지막에 실행되는 블록 (예외 발생, 발생하지 않아도 실행)
		// 3. 생략가능

		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("나이 입력 >>> ");
			String strAge = sc.nextLine();
			int age = Integer.parseInt(strAge);
			System.out.println(age >= 20 ? "성인" : "미성년자");
			// sc.close();											// 위에서 잘못된 값이 스캐너에 입력되는 경우 해당 라인을 건너뛰어 catch 블록으로 가게된다.
		} catch(Exception e) {
			System.out.println("예외 발생");
		} finally {													// 실제로 finally는 자원을 반납할 때 주로 사용됨.
			sc.close();
			System.out.println("finally 블록 실행");
		}
	}
}
