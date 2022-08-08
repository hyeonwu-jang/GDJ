package quiz01_library;

public class Book {

	private int bookNo;				// 1~100 자동부여
	private String title;			// 사용자입력
	private String author;			// 사용자입력
		
	public Book() {															// 일반적으로 기본 생성자와 필드활용 생성자 2개를 만든다.
				
	}	
	
	public Book(int bookNo, String title, String author) {
		super();
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", title=" + title + ", author=" + author + "]";
	}


	@Override
	public boolean equals(Object obj) {											// 전달받은 객체와 비교하려는 객체의 참조값 비교(필드값 전체를 통한 비교)
		if (this == obj)														// 이런 오버라이드 없이 그냥 equals 사용하면 무조건 false
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookNo != other.bookNo)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
		
		

}
