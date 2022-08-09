package prac3;

public class Customer {
	
	private int money; // 가진돈
	private int cnt; // 구매한 빵개수

	public Customer(int money) {
		super();
		this.money = money;
	}

	// 구매 메소드 (구매 후 출력)
	// Bakery에서 판매한 빵을 가질 수 있다.(Bakery의 sell() 메소드 사용)
	public void buy(Bakery bakery, int buyMoney) {
	    
		
		BreadAndChange bnc = bakery.sell(buyMoney);	// 생성자 호출을 위한 sell() 메소드 대입 
		
		cnt += bnc.getBread();
		money += bnc.getChange();
		
		money -= buyMoney;
		
		System.out.println("구매한 빵 " + cnt + "개" + "남은 돈 " + money);
		
		
	}
	
	

}
