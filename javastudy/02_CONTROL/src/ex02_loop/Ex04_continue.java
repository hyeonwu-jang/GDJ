package ex02_loop;

public class Ex04_continue {

	public static void main(String[] args) {

		// continue문
		// 반복문의 시작 지점으로 이동한다.
		// 실행에서 제외할 코드가 있는 경우에 사용한다. continue는 대체품이 있어서 반드시 필요한 것은 아니다.
		
		/*
		 
		while() {
			a;
			b;
			c;
			continue;  // a b c만 실행하고 다시 while()문으로 이동한다. if랑 같이 사용될 수 있다.
			d;
			e;
			f;
			g;
			h;
		}
		
		*/
		
		// 1~100 중에서 3의 배수를 제외하고 모두 더하기
		int total = 0;
		int n = 0;
		
		while(n < 100) {

			n++;
			
			if(n % 3 == 0) {
				continue;
			}
			
			total += n;
			
			
		}
		
		System.out.println(total);
		
		
		int total2 = 0;
		int n2 = 0;
		
		while(n2 < 100) {
			n2++;
			if(n2 % 3 != 0) {
				total2 += n2;
			}
		}
		
		System.out.println(total2);
		
		
		
		
		// continue 없이 코드를 만드는 건 언제나 가능하다.
		
		total = 0;
		n = 0;
		
		while(n < 100) {
			n++;
			if(n % 3 != 0) {
				total += n;
			}
		}
		
		
		
		
	}

}
