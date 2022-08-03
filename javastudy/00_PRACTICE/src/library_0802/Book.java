package library_0802;

public class Book {
	
	private String title;
	private String author;
	private int bookNo;
	
	public Book(String title) {
		super();
		this.title = title;
	}

	public Book(String title, String author, int bookNo) {
		super();
		this.title = title;
		this.author = author;
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
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	@Override
	public String toString() {
		return "[title=" + title + ", author=" + author + ", bookNo=" + bookNo + "]";
	}
	
	
	
	
	

}
