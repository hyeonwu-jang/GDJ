package ex02_loop;

public class Ex05_nested_for {

	public static void main(String[] args) {
		
	// 1일차 1교시
	// 1일차 2교시
	// ...
	// 1일차 8교시
	// 2일차 1교시
	// ...
	// 3일차 8교시
		
		
		
		for(int day = 1; day <= 3; day++) {
			
			for(int hour = 1; hour <= 8; hour++) {
				
				System.out.println(day + "일차" + hour + "교시");
			}
			
		}
		
	// 구구단 문제
	// 2x1=2
	// 2x2=4
	// ...
	// 9x9=81
		
		
		
		for(int dan = 2; dan <= 9; dan++) {
			
			for(int n = 1; n <= 9; n++) {
				
				System.out.println(dan + "x" + n + "=" + (dan * n));
			}
			
		}
		
		
	// 연습
	// 2x1=2
	// 2x2=4
	// ...
	// 5x5=25
		
		for(int dan = 2; dan <= 5; dan++) {
			
			for(int n = 1; n <= 9; n++) {
				System.out.println(dan + "x" + n + "=" + (dan * n));
				if(dan == 5 && n == 5) {
					break;
				}
				
			}
		
		
		}
		
		// 라벨(label)을 이용한 풀이 								<---- 이중 for문에서 유용하게 활용된다.
		outer: for(int dan = 2; dan <= 9; dan++) {
			for(int n = 1; n <= 9; n++) {
				System.out.println(dan + "x" + n + "=" + (dan * n));
				if(dan == 5 && n == 5) {
					break outer;
				}		
			}
		}
		
		
	// 2x1=2	3x1=3	...	9x1=9
	// 2x2=4	3x2=6	...	9x2=18
	// ...
		
		System.out.println();
		
			
		for(int n = 1; n <= 9; n++) {
			
			for(int dan = 2; dan <= 9; dan++) {
			
				System.out.print(dan + "x" + n + "=" + (dan * n)+ "\t");
			}
			
			System.out.println();
		}
		
		/*
		 
		int i;
		int j;
		
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				System.out.print(j+ " ");
			}
			System.out.println();
		}
		
		*/
		
		
		
	// 연습
	// 2x1=2
	// 2x2=4
	// ...
	// 5x5=25
		
		for(int dan = 2; dan <= 5; dan++) {
			for(int n = 1; n <= 9; n++) {
				
				System.out.println(dan + "x" + n + "=" + (dan*n));
				
				if(dan == 5 && n == 5) {
					break;
				}
			
			}

		}
	
	// 연습(라벨문 이용)
	// 2x1=2
	// 2x2=4
	// ...
	// 5x5=25
		
		outer2: for(int dan = 2; dan <= 9; dan++) {
			for(int n = 1; n <= 9; n++) {
				

				System.out.println(dan + "x" + n + "=" + (dan*n));
				
				if(dan == 5 && n == 5) {
					break outer2;							// <====== outer2 바깥 라벨을 입력하지 않으면 if 조건문에 해당하는 5x6, 5x7, 5x8, 5x9가 중단되고 밖으로 나가서 다시 6단부터 x9까지 실행한다.
				}
			
			}

		}
		
		
		
	
	// 연습
	// 2x1=2	3x1=3	...	9x1=9
	// 2x2=4	3x2=6	...	9x2=18
	// ...
		
		for(int n = 1; n <= 9; n++) {
			
			for(int dan = 2; dan <= 9; dan++){
				
				System.out.print(dan + "x" + n + "=" + (dan*n) + "\t");
				
			}
			System.out.println();
		}
		
		
		
		
		
		
	}

}
