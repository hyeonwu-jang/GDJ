package hall0807;

public class Seat {
	
	private String name;

	public String getName() {
		return name;
	}

	public void reserve(String name) {			// 예약
		this.name = name;
	}
	
	public void cancel() {						// 예약 취소
		name = null;
	}
	
	public boolean isOcuupied() {				// 예약여부 확인
		return name != null;
	}
	
	public boolean isMatched(String name) {		// 예약자 일치여부 확인
		return name.equals(this.name);
	}

	
	

}
