package ex13_abstract;

public class Main {

	public static void main(String[] args) {
		
		// Shape 클래스타입의 객체는 존재할 수 없는 객체이다.
		// abstract 처리해서 객체의 생성을 막을 수 있다.
		
	//	Shape s1 = new Shape("도형");		// 도형이 아니라서 객체 생성을 막아둠.
	//	System.out.println(s1.getType());
	//	System.out.println(s1.getArea());
		
		Shape s2 = new Circle("원", 1);
		System.out.println(s2.getType());
		System.out.println(s2.getArea());
	}

}
