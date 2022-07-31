package practice0729;

public class Gun {
	/*
	10. 다음 main 메소드를 참고하여 Gun 클래스와 Soldier 클래스를 구현하시오.
	public static void main(String[] args) {

	Gun gun = new Gun("K2", 2);  // 모델명, 총알수

	Soldier soldier = new Soldier("람보", gun);  // 군인명, 총

	soldier.shoot();  // 빵야! 1발 남았다.
	soldier.shoot();  // 빵야! 0발 남았다.
	soldier.shoot();  // 헛빵!

	soldier.reload(3);  // 3발이 장전되었다. 현재 3발.
	soldier.reload(6);  // 3발이 장전되었다. 현재 6발.
	soldier.reload(6);  // 0발이 장전되었다. 현재 6발.

	soldier.info();

	}

	빵야! 1발 남았다.
	빵야! 0발 남았다.
	헛빵!

	3발 장전되었다. 현재 3발

	3발 장전되었다. 현재 6발

	0발 장전되었다. 현재 6발
	람보 : K2(6)
	*/
	
	private String model;
	private int bullet;
	private final int MAX_BULLET = 15;
	
	Gun(String model, int bullet) {
		this.model = model;
		this.bullet = bullet;
	}
	
	public void reload(int bullet) {
		
		if(bullet <= 0) {
			return;
		}
		
		this.bullet += bullet;
		
		if(this.bullet < MAX_BULLET) {
			System.out.println(bullet + "발 장전되었다. 현재 " + this.bullet + "발");
		} else {
			this.bullet = MAX_BULLET;
			System.out.println(bullet + "발 장전되었다. 현재 " + this.bullet + "발");
		}
		

		// if(this.bullet > MAX_BULLET)
	
			
		
		
	}
	
	public void shoot() {
		if(bullet <= 0) {
			System.out.println("헛빵!");
			return;
		} 
		bullet--;
		System.out.println("빵야! " + bullet + "발 남았다.");
	}
	
	public void info() {
		System.out.println(model + "(" + bullet + ")");
	}
	
	
	
	
}
