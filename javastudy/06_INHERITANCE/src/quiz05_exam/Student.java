package quiz05_exam;

public class Student {
	
	private String name;
	private Exam exam;
	
	public Student(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public void info() {
		System.out.println("학생명 : " + name);
		System.out.println(exam);
		
		System.out.println("----------------------------");
		exam.examInfo();
		
	}
	
	
	
	/*
	private String name;
	private Exam exam;
	
	
	public Student(String name) {
		super();
		this.name = name;
	}
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public void info() {
		System.out.println(name);
		System.out.println();
		System.out.println(exam.getScore());
		
	}
	 */
}
