package prac1;

public class Watch2 {
	/*
	8. 다음 main 메소드를 참고하여 Watch 클래스를 구현하시오.
	public static void main(String[] args) {

	Watch watch = new Watch(16, 15, 30);

	watch.addHour(25);         // 25시간 후(1시간)
	watch.addMinute(61);       // 61분 후  (1시간 1분)
	watch.addSecond(3661);       // 3661초 후(1시간 1분 1초)

	watch.see();  // 19시 17분 31초

	}

	19시 17분 31초
	*/
	
	private int hour;
	private int minute;
	private int second;
	
	public Watch2(int hour, int minute, int second) {
		
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		
	}
	
	public void addHour(int hour) {
		this.hour += hour;
		
		if(this.hour >= 24) {
			this.hour %= 24;
		}
		
	}

	public void addMinute(int minute) {
		this.minute += minute;
		addHour(this.minute / 60);
		this.minute %= 60;
		
	}	
	
	public void addSecond(int second) {
		this.second += second;
		addMinute(this.second / 60);
		this.second %= 60;
	}
	

	
	public void see() {
		System.out.println(this.hour + "시" + this.minute + "분" + this.second + "초");
	}
	
}
