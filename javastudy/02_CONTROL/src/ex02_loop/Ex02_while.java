package ex02_loop;

public class Ex02_while {

	public static void main(String[] args) {
		
		// while문 											<- 정보를 읽어들일 때 많이 쓴다. 정보의 양이 얼마인지 모르기 때문에 사용. // for문은 반복해야할 횟수를 안다. for문이 70% 이상 사용된다.
		// 특정 실행문을 반복할 때 사용한다.
		// 특정 반복 횟수가 정해지지 않은 경우에 사용한다.
		// while(조건문) {
		//       실행문
		// }
		
		int balance = 79350;
		int money = 450;
		
		while(balance >= money) {
			System.out.println("잔액 " + balance + " 인출액 " + money);
			balance -= money;
		}
		System.out.println("잔액 " + balance);
		
		/* 																	내가 연습한거
		
		int balance2 = 79350;
		int money2 = 450;
		for(int n = balance2/money2; n > 0; n--) {
			System.out.println("잔액 " + balance2 + " 인출액 " + money2);
			balance2 -= money2;
		}
		System.out.println("잔액 " + balance2);
		
		*/
	}

}
