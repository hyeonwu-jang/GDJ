package ex01_one_dim;

public class Ex01_array {

	public static void main(String[] args) {
		
		// 배열(Array)           <--------------------------------------------------- 웹상의 체크하는 것은 대부분 배열이다
		// 1. 여러 개의 변수를 하나의 이름으로 관리하는 자료 구조
		// 2. 구성 요소
		// 	1) 인덱스 : 각 변수의 위치 정보. 0으로 시작
		//	2) 배열명 : 모든 변수를 관리하는 하나의 이름
		// 3. 각 변수는 배열명에 대괄호[]와 인덱스를 붙여서 구분
		
		// 배열 선언 및 생성
		// 1. 배열 선언
		// 	int[] arr; <- 자바에서 권유하는 사용법. int 타입의 배열이라는 뜻.
		// 	int arr[];
		// 2. 배열 생성
		//	arr = new int[3];
		// 3. 배열 선언 및 생성
		// int[] arr = new int[3];
		
		// 배열 요소
		// 1. 배열로 관리되는 각각의 변수
		// 2. 모든 배열 요소의 호출 <- 호출은 인덱스 번호로 하기 때문에 생성한 수와 다름.
		//	arr[0]
		//  arr[1]
		//  arr[2]
		// 3. 배열 요소는 자동으로 초기화된다. (어떤 값을 가진다.)  <------------------ 먼저 만들어놓고 나중에 사용도 가능함.
		// 	값이 없음을 의미하는 0, 0.0, false, null 값을 가진다.
		
		// 배열의 장점
		// * 변수 3개가 있는 상황
		// 일반 변수 				배열
		// int a, b, c;				int[] arr = new int[3];
		// System.out.println(a);	for(int i = 0; i <3; i++) {	 <--------------------- for문을 만들 때 인덱스 값을 활용함! (0, 1, 2) / i는 0부터 시작.
		// System.out.println(b);	 System.out.println(arr[i]);
		// System.out.println(c);
		
		int[] arr = new int[3];
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		arr[0] = 100;
		arr[1] = 50;
		arr[2] = 80;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		int total = 0;
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		double average = (double)total / arr.length;
		// double average = total / 3.0; <---------------------------------------------- 실무에서는 활용이 어려운 코드. 배열의 길이가 종속되어 있어 좋지 못한 코드이다.
		System.out.println("평균 : " + average + "점");
		
		
		
		
		
		
		
		
		
		
	}

}
