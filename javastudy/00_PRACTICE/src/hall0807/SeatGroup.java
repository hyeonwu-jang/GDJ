package hall0807;

import java.util.Scanner;

public class SeatGroup {
	
	private Seat[] seats;
	private String seatType;	// S, R, A
	private Scanner sc;
	
	public SeatGroup(String seatType, int cnt) {
		this.seatType = seatType;
		seats = new Seat[cnt];
		sc = new Scanner(System.in);
		for(int i = 0; i < cnt; i++) {
			seats[i] = new Seat();
		}
	}
	
	public boolean reserve() {
		
		System.out.print("예약할 시트번호 >>> ");
		int seatNo = sc.nextInt();
		if(seatNo < 1 || seatNo > seats.length) {
			System.out.println(seatNo + "번은 없는 좌석입니다.");
			return false;
		}
		
		for(int i = 0; i < seats.length; i++) {
			if(seats[seatNo-1].isOcuupied()) {
				System.out.println(seatNo + "번은 이미 예약된 좌석입니다.");
				return false;
			}
		}
		
		System.out.print("예약자 이름 >>> ");
		String name = sc.next();
		seats[seatNo-1].reserve(name);
		System.out.println(seatNo + "번 좌석이 예약되었습니다.");
		return true;
		
	}
	
	public boolean cancel() {
		System.out.print("취소자 이름 >>> ");
		String name = sc.next();
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOcuupied()) {
				if(seats[i].isMatched(name)) {
					seats[i].cancel();
					System.out.println("예약자 " + name + "의 예약이 취소되었습니다.");
					return true;
				}
			}
		}
		
		System.out.println(name + "으로 예약된 좌석이 없습니다.");
		return false;
	}
	
	public void reserveInfo() {
		System.out.println("[" + seatType + "]");
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOcuupied()) {
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
