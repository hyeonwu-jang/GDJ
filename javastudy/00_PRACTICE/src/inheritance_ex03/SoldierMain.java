package inheritance_ex03;

public class SoldierMain {

	public static void main(String[] args) {
		
		Gun gun = new Gun();
		gun.setBullet(14);
		
		Soldier soldier = new Soldier();
		soldier.getGun();
		System.out.println(gun.getBullet());
		

	}

}
