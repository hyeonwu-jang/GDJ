package quiz07_song;

public class Singer {
	
	private String name;
	private Song[] songs;
	private int idx;
	
	public Singer(String name, int number) {
		super();
		this.name = name;
		songs = new Song[number];
	}
	
	public void addSong(Song song) {
		if(idx == songs.length) {
			return;
		}
		
		songs[idx++] = song;
		
	}
	
	public void info() {
		System.out.println("가수이름 " + name);
		System.out.println("대표곡 ");
		for(int i = 0; i < idx; i++) {
			System.out.println(songs[i]);									// Song 클래스에서 toString 사용되어 출력이 가능함.
		}
	}
	

}
