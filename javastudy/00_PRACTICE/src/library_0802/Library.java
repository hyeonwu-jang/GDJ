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
			System.out.println("책의 등록 가능한 수가 초과되었습니다.");
			return;
		}
		
		System.out.println("===책 등록===");
		System.out.print("제목 입력 >>> ");
		String title = sc.next();
		sc.nextLine();
		
		System.out.println("===저자 등록===");
		System.out.print("저자 입력 >>> ");
		String author = sc.next();
		sc.nextLine();
		
		Book book = new Book(title, author, idx + 1);
		books[idx++] = book;
		
		System.out.println(book.getBookNo() + "번에 책이 추가되었습니다.");
		
	
	}
	private void removeBook() {
		System.out.println("=== 책 삭제 ===");
		int bookNo = sc.nextInt() -1;
		System.arraycopy(books, bookNo, books, bookNo, bookNo);
	}
	
	
	private void findBook() {
		System.out.println("=== 책 조회 ===");
		System.out.print("조회할 책의 제목을 입력하세요. >>> ");
		String title = sc.next();
		sc.nextLine();
		
		for(int i = 0; i < books.length; i++) {
			if(books[i].getTitle().equals(title)) {
				System.out.println(books[i].toString());
				continue;
			} else {
				System.out.println("찾으시는 책이 존재하지 않습니다.");
				return;
			}
		}
	}
	
	
	
	private void printAllBook() {
		System.out.println("===전체출력===");
	
		for(int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				System.out.println("출력할 내용이 없습니다.");
				return;
			}
			System.out.println(books[i].toString());
		}
		
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
