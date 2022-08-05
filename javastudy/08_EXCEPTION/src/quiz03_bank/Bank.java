package quiz03_bank;

public class Bank {
	
	// 문제
	
	// 마이너스 입금 불가, 코드값 1000
	// 마이너스 출금 불가, 코드값 2000
	// 잔액보다 큰 출금 불가, 코드값 2001
	
	// deposit() throws BankException
	// withdrawal() throws BankException
	// transfer() throws BankException
	
	// -----------------------------------
	
	private String account;
	private long balance;
	
	
	
	public Bank(String account, long balance) {
		super();
		this.account = account;
		this.balance = balance;
	}
	
	
	
	public void deposit(long money) throws BankException {
		
		if(money < 0) {
			throw new BankException("마이너스 입금 불가", 1);
		}
		
		balance += money;
		
	}
	
	
	public long withdrawal(long money) throws BankException {
		
		if(money < 0) {
			throw new BankException("마이너스 출금 불가", 2);
		} else if(balance < money) {
			throw new BankException("잔액 부족", 3);
		} 
		
		balance -= money;
		return money;
	}
	
	
	public void transfer(Bank acc, long money) throws BankException {
		
		acc.deposit(withdrawal(money));
	}
		
	public void inquiry() {
		
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "Bank [account=" + account + ", balance=" + balance + "]";
	}

	
	
	
	
	
}
