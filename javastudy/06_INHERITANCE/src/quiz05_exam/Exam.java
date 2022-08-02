package quiz05_exam;

public class Exam {
	
	private String examName;
	private int kor;
	private int eng;
	private int mat;
	
	public Exam(String examName) {
		super();
		this.examName = examName;
	}
	
	public void setScore() {
		kor = (int)((Math.random() * 101));
		eng = (int)((Math.random() * 101));
		mat = (int)((Math.random() * 101));
	}
	
	public void examInfo() {									// 메인에서는 안내되지 않았으나, 캡슐화의 관점에서 본 클래스에서 구현함. (examInfo) / 이유는 private 필드가 이곳에 몰려있어서.
		System.out.println(examName + " 성적");
		System.out.println("국어 : " + kor + ", 영어: " + eng + ", 수학 : " + mat);
		int total = kor + eng + mat;
		System.out.println("총점 : " + total + ", 평균 : " + (total / 3.0));
		
	}
	
	/*
	 
	public int getScore() {
		int total = kor + eng + mat;
		return total;
	}
	*/
	
	/*
	private String subject;
	private int score;

	

	public int getScore() {
		return score;
	}

	public void setScore() {
		this.score = (int)((Math.random() * 100) + 1);
	}
	*/
	
	
	

}
