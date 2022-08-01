package quiz02_coffee;

public class Americano {
	
	private String type;
	private int shot;
	private Espresso espresso;
	
	public Americano(Espresso espresso, int shot, String type) {
		super();
		this.espresso = espresso;
		this.type = type;
		this.shot = shot;
	}
	
	public void info() {
		espresso.info();
		System.out.println(shot + "샷");
		System.out.println(type + " 아메리카노");
	}
	

}
