package ex03_number;

public class Ex01 {

	public static void main(String[] args) {

		// 산술 연산
		
		int a = 7;
		int b = 2;
		int result1 = a + b;
		int result2 = a - b;
		int result3 = a * b;
		int result4 = a / b; // 몫
		int result5 = a % b; // 나머지
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		
		// 연습
		// 25를 2와 5로
		
		int n = 25;
		int ten = n / 10;
		int one = n % 10;

		System.out.println(ten);
		System.out.println(one);
		
		// 연습
		
		int second = 90;
		int m = second / 60;
		int s = second % 60;
		System.out.println(m);
		System.out.println(s);
		
		// 연습
		// a = 7, b = 2이므로
		// a 나누기 b는 3.5
		
		double result = (double)a / (double)b;
		System.out.println(result);
		
		// 복합 대입 연산자
		// +=, -=, *=, /=, %= 등
		int wallet = 0;
		wallet = wallet + 5000;
		wallet += 5000; // wallet = wallet + 5000
		wallet -= 3000; // wallet = wallet - 3000
		System.out.println(wallet);
		
		// 연습
		// 통장잔액(balance)에서 이자 5%를 받았음을 나타내자.
		long balance = 10000;
		balance *= 1.05; // balance 자동 타입변환promotion (정수->실수)
		// balance = balance * 1.05; /오류/ 이유는 결과인 더블 타입의 실수가 롱 타입인 정수로 들어가야 하기에
		balance = (long)(balance * 1.05); //  /성공/ balance * 1.05 결과를 long으로 casting 해서 저장할 수 있다.
		System.out.println(balance);
		
		
		// balance = balance + balance * 0.05; /실패/ balance + balance * 0.5 결과는 double이기 때문에 long balance에 저장할 수 없다.
		balance = (long)(balance + balance * 0.05); // /성공/ balance + balance * 0.05 결과를 long으로 casting해서 저장할 수 있다.
		
		
		
		
		
		
	}

}
