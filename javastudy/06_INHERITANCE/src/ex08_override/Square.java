package ex08_override;

public class Square extends Rectangle{
	
	public Square(String type, double width) { // 생성자의 매개변수를 수정할 수 있다. 대신 상위클래스로 넘겨주는 인자의 형태는 변할 수 없다.
		super(type, width, width);
	}	

}
