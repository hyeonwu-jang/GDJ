package ex02_try_catch;

import java.io.File;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void m1() {
		
		try {
		
			String[] hobbies = new String[3];
			hobbies[1] = "swimming";
			hobbies[2] = "running";
			for(String hobby : hobbies) {
				System.out.println(hobby.substring(0,2));
			}
		} catch(Exception e) {		// RuntimeException, NullPointerException 가능 ( NullPointerException extends RuntimeException extends Exception)
			System.out.println("NullPointerException 발생");
		}
		
	}
	
	public static void m2() {
		try {
			String input = "20,21,,22,23,24,25";											// split 메소드는 문자를 구분하여 '배열'로 만드는 것.
			String[] inputs = input.split(",");		// 구분해서 String 배열에 넣는다
			int[] ages = new int[inputs.length];		// int 타입의 새로운 ages 배열을 생성한다
			for(int i = 0; i < inputs.length; i++) {		// 
				ages[i] = Integer.parseInt(inputs[i]);
				System.out.println("변환 값 : " + ages[i]);
			}
			
		} catch(NumberFormatException e) {	// RuntimeException, NullPointerException 가능
			System.out.println("NumberFormatException 발생");
		} catch(Exception e) {														// 다중 catch 활용 시 자식 -> 부모 순
			System.out.println("Exception 발생");
		}
		
	}
	
	public static void m3() {
		
		// 어떤 예외가 발생하는지 확인해서
		// try - catch문 넣기 (Exception, RuntimException 사용하지 않기)
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("정수1 >>> ");
			int a = sc.nextInt();
			System.out.print("정수2 >>> ");
			int b = sc.nextInt();
			System.out.println(a + "+" + b + "=" + (a + b));
			System.out.println(a + "-" + b + "=" + (a - b));
			System.out.println(a + "*" + b + "=" + (a * b));
			System.out.println(a + "/" + b + "=" + (a / b));
			System.out.println(a + "%" + b + "=" + (a % b));
			sc.close();
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException 발생");
		} catch(InputMismatchException e) {
			System.out.println("InputMismatchException 발생");
		}
		
	}
	
	public static void m4() {
		try {
			File file = new File("c:\\sample.txt"); // try-catch문이 없으면 실행이 불가능한 Checked Exception
			FileReader fr = new FileReader(file);	
		} catch(Exception e) {
			
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
	
		m4();
		
		
		
	}
	
	
}
