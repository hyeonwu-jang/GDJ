package prac2;

import java.util.Scanner;

public class SeatGroup {
	
	private String seatType; // "S","R","A"
	private Seat[] seats;
	private Scanner sc;
	
	public SeatGroup(String seatType, int cnt) {
		this.seatType = seatType;
		seats = new Seat[cnt];
		sc = new Scanner(System.in);		
		for(int i = 0; i < cnt; i++) {
			seats[i] = new Seat();
		}
	}
	
	// 예약
	public boolean reserve() {
		reserveInfo();
		// 시트번호는 1부터 시작
		System.out.print("예약할 시트번호 >>> ");
		int seatNo = sc.nextInt();
		if(seatNo < 1 || seatNo > seats.length) {
			System.out.println(seatNo + "번 좌석은 없는 좌석입니다.");
			return false;
		}
		
		// 예약된 시트인지 확인
		if(seats[seatNo-1].isOccupied()) {
			System.out.println(seatNo + "번 좌석은 이미 예약된 좌석입니다.");
			return false;
		}
		
		// 예약 진행
		System.out.print("예약자 이름 >>> ");
		String name = sc.next();
		seats[seatNo - 1].reserve(name);
		System.out.println(seatNo + "번 좌석 예약이 완료되었습니다.");
		return true;
	}
	
	
	
	// 예약 취소
	public boolean cancel() {
		reserveInfo();
		System.out.print("취소자 이름 >>> ");
		String name = sc.next();
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied()) {	// 예약된 좌석만 비교, 생성자에서 seat를 넣었기 떄문에 null은 없음. name으로 예약 여부를 비교해야함.
				if(seats[i].isMatched(name)) { // 예약자 이름과 취소자 이름이 같으면 true 반환
					seats[i].cancel();
					System.out.println("예약자 " + name + "의 예약이 취소되었습니다.");
					return true;
				}
			}
		}
		System.out.println(name + "으로 예약된 좌석이 없습니다.");
		return false;
	}
	
	// 예약 상황 출력
	public void reserveInfo() {
		System.out.println("[" + seatType + "]");
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied()) {
				System.out.print(seats[i].getName().substring(0,1) + "* ");
			} else {
				System.out.print((i + 1) + (i < 9 ? "   " : "  "));
			}
			if((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
}
