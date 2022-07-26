package ex04_throw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// throw
		// 1. 예외 객체를 만들어서 직접 throw 할 수 있다.
		// 2. 자바는 예외로 인식하지 않지만 실제로는 예외인 경우에 주로 사용된다.
		// 


		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("나이 입력 >>> ");
			String strAge = sc.nextLine();
			int age = Integer.parseInt(strAge);
			if(age < 0 || age > 100) {
				throw new RuntimeException("나이는 0 이상 100 이하만 가능합니다.");
			}
			System.out.println(age >= 20 ? "성인" : "미성년자");
			// sc.close();											// 위에서 잘못된 값이 스캐너에 입력되는 경우 해당 라인을 건너뛰어 catch 블록으로 가게된다.
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		} finally {													// 실제로 finally는 자원을 반납할 때 주로 사용됨.
			sc.close();
			System.out.println("finally 블록 실행");
		}
	}
}
