package ex01_one_dim;

import java.util.Scanner;

public class Ex05_arrayPractice {
	
	// 난수의 로또번호 45개 만들기
	public static void q1() {
			int[] lotto = new int[45];
			
			for(int i = 0; i < lotto.length; i++) {
				lotto[i] = (i + 1);								// lotto 배열에 for문의 인덱스 [i]를 넣어 0~ 44까지 차례대로 1~45를 입력하겠다는 코드.
			}
			
			for(int i = 0; i < 6; i++) {
				int n = (int)(Math.random() * 45);				// 생성된 배열을 호출하는 인덱스 번호는 0 ~ 44까지 있음. 길이와 혼동하지 않아야함.
				int temp = lotto[i];
				lotto[i] = lotto[n];
				lotto[n] = temp;

				System.out.println(lotto[i]);
			}
	}
	
	public static void q2() {

	// 5개 정수를 입력받은 후 차례로 출력하는 프로그램

		Scanner sc = new Scanner(System.in);
		int[] number = new int[5];
		
		for(int i = 0; i < 5; i++) {	
			number[i] = sc.nextInt();
			
			System.out.println(number[i]);
		}
		
	}

	public static void main(String[] args) {
		
		// q1();
		q2();
	
		
		
	}

}
