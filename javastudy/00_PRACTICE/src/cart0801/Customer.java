package cart0801;

public class Customer {
	
	private Product[] cart = new Product[10];
	private int money;
	private int bonusPoint;
	private int total;
	private int idx;
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
	public void buy(Product product) {
		int price = product.getPrice();
		
		if(money > price) {
			return;
		}
		
		
		
		cart[idx++] = product;
		money -= price;
		money += total;
		
		
	}
	
	public void receipt() {
		for(int i = 0; i < idx; i++) {
			
		}
	}
	
	
	
	
	

	
	

}
