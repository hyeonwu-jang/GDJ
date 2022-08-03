package library;

import java.util.Scanner;

public class Library {
	
	private Scanner sc;					// 클래스 안에서 계속 사용하기 때문에 필드에 선언해 둠(생성x)
	private Book[] books;
	private int idx;					// 배열이 사용되어 인덱스도 필드로 선언
	
	public Library() {
		sc = new Scanner(System.in);
		books = new Book[100];			// books 안에 새로운 Book 배열 객체를 넣는다(100개 짜리)
	}
	
	private void addBook() {

		if(idx == books.length) {
			System.out.println("더 이상 등록할 수 없습니다.");
			return;
		}
		
		System.out.println("=== 책 등록 ===");
		System.out.print("제목 입력 >>> ");
		String title = sc.next();
		System.out.print("저자 입력 >>> ");
		String author = sc.next();
		Book book = new Book(idx + 1, title, author);
		books[idx++] = book;
		
		
	}
	
	private void removeBook() {
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		}
		System.out.println("=== 책 삭제 ===");
		System.out.print("삭제할 책의 번호 >>> ");
		int bookNo = sc.nextInt();
		for(int i = 0; i < idx; i++) {
			if(books[i].getBookNo() == bookNo) {
				System.arraycopy(books, i + 1, books, i, idx - i - 1);
				books[--idx] = null;
				System.out.println("책 번호가 " + bookNo + "인 책을 삭제했습니다.");				
				return;
			}
		}
		System.out.println("책 번호가 " + bookNo + "인 책이 없습니다.");
	}
	
	private void findBook() {
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		}
		System.out.println("=== 책 조회 ===");
		System.out.print("조회할 책 제목 입력 >>> ");
		String title = sc.next();
		for(int i = 0; i < idx; i++) {			
			// 저장된 책 제목 : books[i].getTitle()
			// 조회할 책 제목 : title
			// String의 동등비교 : equals() 
			if(books[i].getTitle().equals(title)) {
				System.out.println(books[i]);
				return; // findBook() 메소드 종료
			}														// else를 for문 안에 넣는 실수가 자주 발생함.
		}
		System.out.println("제목이 " + title + "인 책은 없습니다.");
	}
	
	private void printAllBooks() {		// private 선언으로 외부에서 접근 불가
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다.");
			return;
		}
		System.out.println("=== 전체조회 ===");
		for(int i = 0; i < idx; i++) {
			System.out.println(books[i]);
		}
	}
	
	public void manage() {				// public 선언으로 외부에서는 manage를 이용해서 접근하도록.
		
		while(true) {
			System.out.print("1. 추가 2. 삭제 3. 조회 4. 전체목록 0. 프로그램 종료 >>> ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1: addBook(); break;
			case 2: removeBook(); break;
			case 3: findBook(); break;
			case 4: printAllBooks(); break;
			case 0: System.out.println("Library 프로그램을 종료합니다. 감사합니다."); 
					return;				// manage() 메소드 종료
			default : System.out.println("알 수 없는 명령입니다. 다시 시도하세요."); 
			}
		}
		
	}

}
