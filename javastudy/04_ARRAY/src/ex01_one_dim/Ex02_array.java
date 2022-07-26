package ex01_one_dim;

public class Ex02_array {

	public static void main(String[] args) {
		
		// 배열의 초기화
		// int[] arr = new int[] {10, 20, 30, 40, 50};
		int[] arr = {10, 20, 30, 40, 50};
		
		// 최대/최소
		int max = arr[0];
		int min = arr[0]; // <----------------------------------- 최소값의 초기화는 0으로 주면 안된다(0이 최소값이 될 수도 있기 때문에) / 배열의 첫번째 값[0]을 초기값으로 쓴다.
		
		for(int i = 1; i <arr.length; i++) {  // <--------------- int i = 1로 선언한다. (if문 안의 max, min에서 arr[0]을 선언했기 때문에 for문의 index값을 [1]부터 시작하도록 선언)
			if(max < arr[i]) {
				max = arr[i];
			}
			
			if(min > arr[i]) {
				min = arr[i];
			}
			
		}
		
		System.out.println("최대 : " + max);
		System.out.println("최소 : " + min);

	}

}
