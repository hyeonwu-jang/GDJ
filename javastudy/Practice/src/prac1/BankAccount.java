package prac1;

public class BankAccount {
	/*
	9. 다음 main 메소드를 참고하여 BankAccount 클래스를 구현하시오.
	public static void main(String[] args) {

	BankAccount me  = new BankAccount("1234", 10000);
	BankAccount mom = new BankAccount("4321", 100000);

	me.deposit(10000);  // 내 계좌에 10000원 입금
	me.deposit(-100);   // 내 계좌에 마이너스 입금 (불가)

	me.withdraw(5000);  // 내 계좌에서 5000원 출금
	me.withdraw(100);   // 내 계좌에서 잔액보다 큰 금액 출금 (불가)

	me.inquiry();  // 계좌번호: 1234, 잔액: 15000원

	mom.transfer(me, 50000);  // 엄마가 나에게 50000원 이체
	mom.transfer(me, -100);  // 실패

	mom.transfer(me, 100000000);  // 실패

	mom.inquiry();  // 계좌번호: 4321, 잔액: 50000원
	me.inquiry();  // 계좌번호: 1234, 잔액: 64900원

	}

	계좌번호: 1234, 잔액: 14900원
	계좌번호: 4321, 잔액: 50000원
	계좌번호: 1234, 잔액: 64900원
	*/
	
	String account;
	long money;
	BankAccount bankAccount;
	
	BankAccount(String account, long money) {
		
		this.account = account;
		this.money = money;	
	}
	
	public void deposit(long money) {
		if(money <= 0) {
			return;
		}
		
		this.money += money;
	}
	
	public long withdraw(long money) {
		if(this.money < money || money <= 0) {
			return 0;
		}
		this.money -= money;
		return money;
	}
	
	public void inquiry() {
		System.out.println(account + " : " + money);
	}
	
	public void transfer(BankAccount bankAccount, long money) {
		bankAccount.deposit(withdraw(money));
	}
}
