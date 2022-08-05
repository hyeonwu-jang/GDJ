package ex05_throws;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingLot {
	
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	public ParkingLot() {
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	public void addCar() throws RuntimeException {
		
		if(idx == cars.length) {
			throw new RuntimeException("Full");
		}
	}
	
	public void deleteCar() throws RuntimeException {
		
		if(idx == 0) {
			throw new RuntimeException("EMPTY");
		}
	}
	
	public void findCar() throws RuntimeException {
		
		if(idx == 0) {
			throw new RuntimeException("EMPTY");
		}
	}
	
	public void printAllCars() throws RuntimeException {
		
		if(idx == 0) {
			throw new RuntimeException("EMPTY");
		}
	}
	
	public void manage() throws RuntimeException {
		
	
		while(true) {
			
			try {
				
				System.out.print("1. 추가 2. 제거 3. 조회 4. 전체목록 0. 종료 >>> ");
				int choice = sc.nextInt();
				switch(choice) {
				case 1: addCar(); break;
				case 2: deleteCar(); break;
				case 3: findCar(); break;
				case 4: printAllCars(); break;
				case 0: return;
				default : throw new RuntimeException("Bad Requset");
				}
				
			} catch(InputMismatchException e) {												// 잘못된 값을 입력했을 때의 오류(ex. Int 타입이 아닌 경우)							
				sc.next();																	// sc에 "추가"를 입력한 경우 catch로 오지만, "추가" 텍스트가 남아있어 무한루프에 빠진다. 나머지 텍스트를 먹는 코드
				System.out.println("처리 명령은 정수(1~4, 0) 입니다.");
				
			} catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		
		new ParkingLot().manage();
		
		
	}
	
	
	

}
