package practice0729;

public class Soldier {
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
	
	private Gun gun;
	private String name;
	
	Soldier(String name, Gun gun) {
		this.gun = gun;
		this.name = name;
	}
	
	public void shoot() {
		gun.shoot();
	}
	
	public void reload(int bullet) {
		gun.reload(bullet);
	}
	
	public void info() {
		System.out.print(name + " : ");
		gun.info();
	}
	
	
}
