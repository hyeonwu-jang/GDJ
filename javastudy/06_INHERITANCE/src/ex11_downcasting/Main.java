package ex11_downcasting;

public class Main {

	public static void main(String[] args) {
	
		/*
		Car[] car = new Car[10];
	
		int idx = 0;
		double random = Math.random();
		
		if(random < 3.3) {							// <= random 범위 실수 (0.0 ~ 1.0) + for문 미이용 (증감하면서 배열에 삽입)
			car[idx] = new Car();
		} else if(random < 6.6) {
			car[idx] = new Ev();
		} else {
			car[idx] = new Hybrid();
		}
		
		for(int i = 0; i < car.length; i++) {		// <= 하위클래수부터 출력하기
			if(car[idx] instanceof Car) {
				car.
			} else if(car[idx] instanceof Ev) {
				
			} else {
				
			}
		}
		
		*/
		
		// 정답
		
		Car[] cars = new Car[10];					// 배열만 생성
		
		// 3분의 1 확률로 배열에 차 집어넣기
		for(int i = 0; i < cars.length; i++) {
			if(Math.random() < 0.33) {
				cars[i] = new Car();				// 배열 안에 클래스타입 객체를 넣는다. 업캐스팅.
			} else if(Math.random() < 0.66) {
				cars[i] = new Ev();					// 
			} else {
				cars[i] = new Hybrid();
			}
		}
		
		for(int i = 0; i < cars.length; i++) {		// if문 이용, 출력할 때는 하위클래스부터 출력해야 함.
			if(cars[i] instanceof Hybrid) {
				((Hybrid)cars[i]).addOil();
			} else if(cars[i] instanceof Ev) {
				((Ev)cars[i]).charge();
			} else {
				cars[i].drive();
			}
		}
		
		

	}

}
