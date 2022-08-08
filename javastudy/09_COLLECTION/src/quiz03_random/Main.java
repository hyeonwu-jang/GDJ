package quiz03_random;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇개의 랜덤을 생성할까요? ");
		int count = sc.nextInt();
		
		if(count < 1 || count > 100) {
			System.out.println("다음에는 1~100 사이로 입력하세요");
			return;
		}
		
		int[] random = new int[count];
		
		Set<Integer> set = new HashSet<Integer>();
		
		while(set.size() < count) {
			set.add((int)(Math.random() * 100 + 1));
		}
		
		int idx = 0;
		for(Integer n : set) {
			random[idx++] = n;
		}
		
		for(int i = 0; i < count; i++) {
			System.out.print(random[i] + " ");
			if(( i + 1 ) % 10 == 0) {
				System.out.println();
			}
		}
		
		

	}

}
