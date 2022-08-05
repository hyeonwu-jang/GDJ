package prac2;

public class Seat {
	
	private String name;		// 시트 예약한 사람 이름

	
	// 예약한 사람 확인
	public String getName() {
		return name;
	}

	// 예약
	public void reserve(String name) {
		this.name = name;
	}
	
	// 예약 취소
	public void cancel() {
		name = null;
	}
	
	// 예약 여부 확인
	public boolean isOccupied() {
		return name != null; // null이 아니면 true 반환 (예약되어 있으면 true 반환)
	}
	
	// 예약자 확인
	public boolean isMatched(String name) {
		return name.equals(this.name);				// 문자열이라 equals 쓰기. 실수 많이함..
	}
	
	
	
			// 생성자로 this.name = name 을 만들지 않는 이유는 좌석을 예약할 때 등록되는 방식의 프로그램이라서. name은 시트 예약한 사람의 이름임.
	
	
	
	
	

}
