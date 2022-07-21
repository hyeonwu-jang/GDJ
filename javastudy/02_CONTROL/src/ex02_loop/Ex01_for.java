package ex02_loop;

public class Ex01_for {

	public static void main(String[] args) {
		
		// for 문
		// 연속된 숫자를 생성할 때 주로 사용한다.
		// 배열과 함께 자주 사용된다.
		// for(초기문; 조건문; 증감문) {
		//     실행문
		// }
		
		// 1 ~ 10 
		for(int n = 1; n <= 10; n++) {
			System.out.print(n);
		}
		
		// 초기문 -> 조건문 -> 실행문 -> 증감문 -> 조건문 -> 실행문 -> 증감문 
		System.out.println(); // 줄 바꿈
		
		
	// 연습
	// 10 ~ 1
		for(int n = 10; n >= 1; n--) {
			System.out.println(n);
		}
		System.out.println();
		
	// 연습
	// 구구단 7단 출력
		for(int n = 1; n <= 9; n++) {
			System.out.println("7 X " + n + " = " + (7 * n));
		}
		
		System.out.println();
		
	// 연습
	// 1 ~ 100 사이의 모든 3의 배수만 출력하기
		for(int n = 1; n <= 100; n++) {
		
			if(n % 3 == 0) {
				System.out.print(n + " ");
			}
		
		}
		
		System.out.println();
		
		/*
		
		for(int n = 1; (n <= 100) && (n % 3 == 0); n++) {   <------------- n이 1일 경우, 3의 배수인 0에는 해당하지 않아 처음부터 출력이 불가하다.
			System.out.println(n);
		}
		
		*/
	
		System.out.println();
		
		int wallet = 0;
		wallet += 1;
		wallet += 2;
		wallet += 3;
		wallet += 100;
		System.out.println(wallet);
		System.out.println();
		
	// 연습
	// 1~100 모든 정수 더하기(5050)
		int total = 0;
		for(int n = 1; n <= 100; n++) {
			
			total += n;
			
		}
		System.out.println(total);
		
		System.out.println();
		
	// 연습 																	<--------------------- 다시 해보기.
	// begin ~ end 모든 정수 더하기
	// begin과 end 중 누가 큰 지 모르는 상황
	// begin을 end보다 항상 작은 값으로 바꾼 뒤 begin ~ end 모두 더하기 진행  
	// begin이 end보다 크다면 begin과 end를 교환
		
		int begin = 12;
		int end = 1;
		
		if(begin > end) {
			int temp;
			temp = begin;
			begin = end;
			end = temp;
		}
		int sum = 0;
		for(int n = begin; n <= end; n++) {
			sum += n;
		}
		System.out.println(sum);
		
		System.out.println();
		
	// 연습
	// 평점(1~5)에 따른 별(★) 출력하기
		
		
		int point = 3;
		String star = "";
											
		for(int n = 0; n < point; n++) {
			star += "★";												// += 사용을 하려면 반드시 초기값이 있어야 함. 그래서 위에서 sta를 빈 공백인 ""로 초기화 하는 것.
		}
		System.out.println(star);

		
		/*
		int star = 5;
		for(int n = 1; n <= star; n++) {
			
			System.out.print("★");
					
				
		}
		*/
		
		
	// 연습
	// 1 ~ 100 사이의 모든 3의 배수만 출력하기
		for(int n = 1; n <= 100; n++) {
			if(n % 3 == 0) {
				System.out.println(n);
			}
		}
	
	// 연습
	// 1~100 모든 정수 더하기(5050)
		int total2 = 0;
		for(int n = 0; n <= 100; n++) {
			total2 += n;
		}
		System.out.println(total2);
	
	// 연습 																	<--------------------- 다시 해보기.
	// begin ~ end 모든 정수 더하기
	// begin과 end 중 누가 큰 지 모르는 상황
	// begin을 end보다 항상 작은 값으로 바꾼 뒤 begin ~ end 모두 더하기 진행  
	// begin이 end보다 크다면 begin과 end를 교환
		
		int begin2 = 2;
		int end2 = 0;
		int total3 = 0;	
		
		if(begin2 > end2) {
			int temp2;
			temp2 = begin2;
			begin2 = end2;
			end2 = temp2;	
		}
		
		for(int n = begin2; n <= end2; n++) {
						
			total3 += n;
		}
		
		System.out.println(total3);
		
	
	// 연습
	// 평점(1~5)에 따른 별(★) 출력하기
		
		int point2 = 3;
		String star2 = "";
		
		for(int n = 1; n <= point2; n++) {
			
			star2 += "★";
		}
		
		System.out.println(star2);
		
	
	
		
	}

}
