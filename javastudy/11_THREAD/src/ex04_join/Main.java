package ex04_join;

public class Main {

	public static void main(String[] args) {
		
		// Calculator를 2개 준비
		// 작업을 반으로 나눠서 진행
		
		// Calculator가 동시에 연산을 수행하려면 Calculator를 스레드로 처리해야 함.
		
//		ex1)
		
//		Calculator calc1 = new Calculator(1, 5000);
//		Thread thread1 = new Thread(calc1);
//		thread1.start();
//		
//		Calculator calc2 = new Calculator(5001, 10000);
//		Thread thread2 = new Thread(calc2);
//		thread2.start();
//		
//		System.out.println(calc1.getTotal() + calc2.getTotal());	// 	0
//																	// 	Main에서는 thread1, thread2 각각 실행 중인 상태(미완료)이나, 20 코드는 현재 시점의 결과물을 요청해서 0이 먼저 출력됨.

//		ex2)
		
		Calculator calc3 = new Calculator(1, 5000);
		Thread thread3 = new Thread(calc3);
		thread3.start();

		Calculator calc4 = new Calculator(5001, 10000);
		Thread thread4 = new Thread(calc4);
		thread4.start();
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(calc3.getTotal() + calc4.getTotal());	// 50005000
																	// Main에서 각각의 thread 실행 후 잠깐의 sleep를 선언하여 원하는 결과가 출력됨.
		
//		ex3)
		
		Calculator calc1 = new Calculator(1, 5000);
		Thread thread1 = new Thread(calc1);
		thread1.start();
		
		Calculator calc2 = new Calculator(5001, 10000);
		Thread thread2 = new Thread(calc2);
		thread2.start();
		
		// 모든 계산기의 동작이 끝날 때까지 기다린다.
		// join() : 스레드가 종료(die)될 때까지 기다림
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(thread1.isAlive());						// false
		System.out.println(thread2.isAlive());						// false
		
		System.out.println(calc1.getTotal() + calc2.getTotal());	// 50005000
																	// join() 활용하여 스레드가 모두 종료되고 실행결과 출력
		
		
		
		
		
	}

}
