package parking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingLot {
	
	private String name;
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	private void addCar() throws RuntimeException {
		if(idx == cars.length) {
			throw new RuntimeException("차량이 가득 찼습니다.");
		}
		
		System.out.println("현재 등록된 차량 " + idx + "대");
		System.out.print("차량번호 >>> ");
		String carNum = sc.next().trim();
		sc.nextLine();
		
		System.out.print("모델명 >>> ");
		String carName = sc.next().trim();
		sc.nextLine();
		
		Car car = new Car(carNum, carName);
		cars[idx++] = car;
		
		System.out.println("차량번호 " + carNum + "차량이 등록되었습니다.");
		
	}
		
	private void deleteCar() throws RuntimeException {
		if(idx == 0) {
			throw new RuntimeException("등록된 차량이 없습니다.");
		}
		
		System.out.print("제거할 차량번호 >>> ");
		String carNum = sc.next().trim();
		sc.nextLine();
		
		for(int i = 0; i < idx; i++) {															// 배열의 길이는 삭제될 예정이라 for문에 사용 불가?
			
			if(cars[i].getCarNo().equals(carNum)) {												// 차량 번호가 같으면
				System.arraycopy(cars, i + 1, cars, i, idx - i - 1);
				cars[--idx] = null;															
				System.out.println("차량번호 " + carNum + "차량이 삭제되었습니다.");
				return;
			} 
			
		}
		System.out.println("대상 차량이 존재하지 않습니다.");
	}
	
	private void printAllCars() throws RuntimeException {
	
		if(idx == 0) {
			throw new RuntimeException("등록된 차량이 없습니다.");
		}
		
		System.out.println(name + " 차량 목록");
		for(int i = 0; i < cars.length; i++) {
			
			if(cars[i] != null) {
				
				System.out.println(cars[i].toString());		
			}
		}
	}
	
	public void manage() {
		
			
		while(true) {
			
			try {
				
				System.out.print("1. 추가 2. 삭제 3. 전체 0 종료 >>> ");
				int input = sc.nextInt();
				
				switch(input) {
				
				case 1: addCar(); break;
				case 2: deleteCar(); break;
				case 3: printAllCars(); break;
				case 0: System.out.println("주차관리 프로그램을 종료합니다."); return;
				default : System.out.println("존재하지 않는 메뉴입니다.");
				}
				
			} catch(InputMismatchException e) {
				System.out.println("처리 명령은 정수(1~4, 0) 입니다.");
				sc.next();
			
			} catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
