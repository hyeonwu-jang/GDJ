package library_0802;

import java.util.Scanner;

public class Library {
	
	private Scanner sc;
	private Book[] books;
	private int idx;
	
	public Library() {
		sc = new Scanner(System.in);
		books = new Book[10];
		
	}
	
	private void addBook() {
		
		if(idx == books.length) {
			return;
		}
		
		System.out.println("===책 등록===");
		System.out.println("제목 입력 >>> ");
		String title = sc.next();
		System.out.println("===저자 등록===");
		System.out.println("저자 입력");
		String author = sc.next();
		
		Book book = new Book(title, author, idx + 1);
		books[idx++] = book;
			
	}
	private void removeBook() {
		System.out.println("=== 책 삭제 ===");
		int bookNo = sc.nextInt() -1;
		System.arraycopy(books, bookNo, books, bookNo, bookNo);
	}
	private void findBook() {
		
	}
	private void printAllBook() {
		
	}
	
	public void manage() {
		
		while(true) {
			System.out.print("1. 추가 2. 삭제 3. 검색 4. 전체출력 0. 종료 >>> ");
			int inputNo = sc.nextInt();
			switch(inputNo) {
			case 1: addBook();	break;
			case 2: removeBook(); break;
			case 3: findBook(); break;
			case 4: printAllBook(); break;
			case 0: System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("잘못된 값을 입력하셨습니다. 다시 시도해주세요.");
			}
		}
		
	}
	
	
	

}
