package ex12_object_class;

public class Person {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println("먹는다");
	}
	
	@Override
	public String toString() {
		return "이름 : " + name;	// System.out.println(person); 에서 사용됨
	}
	
	@Override
	public boolean equals(Object anObject) {	// p1.equals(p2)에서 사용됨 (객체 사이에서의 값 비교)
		Person p = ((Person) anObject);			// Object 클래스타입 객체는 모든 것을 저장할 수 있다. 그래서 매개변수로 설정한 뒤, 다운캐스팅하여 필요한 클래스에서 equasl 메소드를 사용할 수 있다.
		return name.equals(p.name);				// name.equals => String 타입의 equals를 활용한다. 
	}
	
	
	
	
}
