package ex10_downcasting;

public class Main {

	public static void main(String[] args) {
		
		// 클래스타입 : Person
		// 객체(인스턴스) : p
		// Person - Student - Alba
		
		Person p = new Student(); // 업캐스팅
		
		// instanceof 연산자
		// 특정 인스턴스가 어떤 클래스타입인지 점검하는 연산자
		// 해당 클래스타입이면 ture 반환, 아니면 false 반환
		
		System.out.println(p instanceof Person);	// true
		System.out.println(p instanceof Student);	// true
		System.out.println(p instanceof Alba);		// false
		
		
		
		// p가 Student타입의 인스턴스이면 study() 메소드를 호출할 수 있다.
		if(p instanceof Student) {
			((Student) p).study();
		}
		
		// p가 Alba타입의 인스턴스이면 work() 메소드를 호출할 수 있다. / 11 라인에서 p는 Student타입 인스턴스이기에 호출 불가
		if(p instanceof Alba) {
			((Alba) p).work();
		}

		
		
	}

}
