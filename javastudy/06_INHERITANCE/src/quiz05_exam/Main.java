package quiz05_exam;

public class Main {

	public static void main(String[] args) {
		
		Exam exam = new Exam("중간고사");																// "중간고사" examName을 가진 exam 객체 하나 생성
		exam.setScore();						// 국, 영, 수학 점수 0~100 사이 랜덤 생성				// exam 객체가 가진 Exam 클래스 setScore 메소드 실행해서 exam 필드에 점수 생성
	
		Student student = new Student("emily");															// "emily" name을 가진 student 객체 하나 생성
		
		student.setExam(exam);																			// 중간고사 이름이 등록되어있는 exam객체를 받아 Student 클래스의 exam 필드로 가져온다.
		
		student.info();																					// 
		
		// 학생이름 : emily
		// 중간고사 성적
		// 국어 : 50, 영어 : 50, 수학 : 50, 총점 : 150, 평균 : 50.0점
		// 기말고사 성적
		// 국어 : 50, 영어 : 50, 수학 : 50, 총점 : 150, 평균 : 50.0점
	}

}
