package quiz06_game;

public abstract class GameUnit {
	
	private String name;
	private int energy;
	private int power;
	private boolean isAlive;				// boolean alive; 로 해도 동일한 getter/setter가 생성됨.
/*
	public GameUnit(String name) {									이렇게하면 이름 값만 들어가고 나머지 값은 생성될 때 들어가지 않는다.
		this.name = name;
	}
*/
	public GameUnit(String name, int energy, int power) {
		super();
		this.name = name;
		this.energy = energy > 0 ? energy : 0;
		this.power = power;
		this.isAlive = energy > 0;
	}
	
	public void info() {
		System.out.println(name + " 에너지 : " + energy + "공격력 : " + power);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public abstract void attack(GameUnit unit);
	


	

}
