package ex02_datetime;

public class Ex01_System {

	public static void main(String[] args) {
		
		// 1. 타임스탬프(timestamp) <===================================  파일 이름으로 사용하기도 함.
		// 1970-01-01 0:00부터 1/1000초마다 증가하는 long 타입의 정수값
		// 중복을 예방하는 수단으로 활용되기도 함. (수치가 수시로 변화하기 때문에)
		long timestamp = System.currentTimeMillis();
		System.out.println(timestamp);
		
		// 2. 나노타임(nanoTime)
		// s > ㎳(천분의 1초) > ㎲(백만분의 1초) > ㎱(십억분의 1초) > ㎰
		// 나노초(㎱) 값을 가지는 long 타입의 정수 값
		// 어떤 기준일자는 없어서 두 개의 나노초(㎱)사이의 경과시간 계산용
		long beginTime = System.nanoTime();
		int total = 1 + 2 + 3 + 4 + 5;
		long endTime = System.nanoTime();
		System.out.println(total + " 계산에 걸린 시간 : " + (endTime - beginTime) + "ns");
		
		
		
	}

}
