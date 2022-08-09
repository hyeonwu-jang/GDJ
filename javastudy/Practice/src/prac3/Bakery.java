package prac3;

public class Bakery { 

	private int price; // 빵가격
	private int cnt; // 빵개수
	private int money; // 자본금


	public Bakery(int price, int cnt, int money) {
		super();
		this.price = price;
		this.cnt = cnt;
		this.money = money;
	}
	

	// 판매 메소드

	public BreadAndChange sell(int money) {
		
	
		
		// money를 입력받아 구매 가능한 빵의 갯수, 생성자를 이용하여 값을 리턴해주는 용도.
		int bread = money / price;
		
		// money를 입력받아 가능한 만큼의 빵을 구매하고 남은 금액, 생성자를 이용하여 값을 리턴해주는 용도.
		int change = money % price;
		
		
		// money를 입력받아 판매하고 남은 빵의 갯수, 
		cnt -= bread;
		
		// money를 입력받아 구매 가능한 빵의 갯수의 금액과 구매하고 남은 잔액을 더한 값 = > 자본금.
		this.money += money - change;
		
		
		return new BreadAndChange(bread, change);
		
	}
		
	
	// 정보 확인
	public void info() {

		System.out.println("빵 " + cnt + "개 ," + " 자본금 " + money + "원");
		
	}
	
	
}
