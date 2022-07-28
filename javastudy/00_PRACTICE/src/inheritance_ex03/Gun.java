package inheritance_ex03;

public class Gun {
	
	private String model;
	private int bullet;
	private final int MAX_BULLET = 15;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getBullet() {
		return bullet;
	}
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	public void shoot() {
		if(bullet == 0) {
			System.out.println("Reload");
			return;
		}
		bullet--;
	}
	
	public void reload(int bullet) {
		if(this.bullet > MAX_BULLET) {
			return;
		}
		this.bullet += bullet;
		
		this.bullet = (this.bullet > 15) ? MAX_BULLET : this.bullet;
		
		
		
		
		
	}
	

}
