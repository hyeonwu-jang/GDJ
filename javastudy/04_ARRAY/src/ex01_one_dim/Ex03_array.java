package ex01_one_dim;

import java.util.Arrays;

public class Ex03_array {

	public static void main(String[] args) {
		
		// 배열의 데이터타입
		// int[] : 참조 타입(Reference Type)
		
		
	/*
	    int[] arr = {10000, 20000, 30000};
	  	
		     |-------|
		arr	 | 0x123 |
		     |-------|
		     | ... 	 |
		     |-------|
	   arr[0]| 10000 | 0x123
		     |-------|
	   arr[1]| 20000 | 
		     |-------|
	   arr[2]| 30000 | 
		     |-------|
		 
	*/
		
	
		// 배열의 길이 늘리기
		// 1. 배열의 길이는 변경할 수 없다.
		// 2. 늘어난 길이의 새로운 배열을 만들고,
		//    기존 배열의 값을 모두 새로운 배열로 옮기고,
		//    기존 배열의 참조값을 새로운 배열의 참조값으로 수정한다.
		
		
		// 길이가 5인 배열을 사용하다가
		// 길이기 1000인 배열로 바꾸기
		
		int[] arr = {1, 2, 3, 4, 5};
		
		// 늘어난 길이의 새로운 배열을 만들고,
		int[] temp = new int[1000];
		
		// 기존 배열의 값을 모두 새로운 배열로 옮기고, //  (arr, 0,            temp, 0,                            arr.length)
		System.arraycopy(arr, 0, temp, 0, arr.length); // arr, 0 에 있는 것을 temp, 0으로 옮기는 것이 시작이다 / arr.length 길이만큼 옮긴다
		
		// 기존 배열의 참조값을 새로운 배열의 참조값으로 수정한다. <-------------------------------------- 기존 배열이 생성한 공간은 아무도 활용하지 못하는 참조값이 되며 메모리 누수라고 부른다. System.gc
		arr = temp;
		
		// 이제 arr 배열의 길이는 1000이다.
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr)); // Arrays클래스(ctrl + space로 import 자동완성) toString 메소드를 이용, String 문자열로 배열 내부의 내용을 확인
		
	
		
		

	}

}
