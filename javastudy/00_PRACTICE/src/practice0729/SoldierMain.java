package practice0729;

public class SoldierMain {

	public static void main(String[] args) {
		
		Gun gun = new Gun("K2", 2);  // 모델명, 총알수

		Soldier soldier = new Soldier("람보", gun);  // 군인명, 총

		soldier.shoot();  // 빵야! 1발 남았다.
		soldier.shoot();  // 빵야! 0발 남았다.
		soldier.shoot();  // 헛빵!
		soldier.shoot();  // 헛빵!
		soldier.shoot();  // 헛빵!
		soldier.shoot();  // 헛빵!

		soldier.reload(3);  // 3발이 장전되었다. 현재 3발.
		soldier.info();
		soldier.reload(6);  // 3발이 장전되었다. 현재 6발.
		soldier.info();
		soldier.reload(3);  // 0발이 장전되었다. 현재 6발.
		soldier.info();
		soldier.reload(5);  // 0발이 장전되었다. 현재 6발.
		soldier.info();

		soldier.reload(5);  // 0발이 장전되었다. 현재 6발.
		soldier.info();
		

	}

}
