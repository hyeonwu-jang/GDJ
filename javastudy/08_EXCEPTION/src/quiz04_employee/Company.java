package quiz04_employee;

import java.util.Scanner;

public class Company {
	
	private Employee[] employees;
	private int idx;
	private Scanner sc;
	
	public Company() {
		employees = new Employee[5];
		sc = new Scanner(System.in);
		
	}
	
	public void addEmployee() {
		
		if(employees.length > 5) {
			System.out.println(" 가득참");
			return;
		}
		
		System.out.print("사원 추가 = y 취소 = n >>> ");
		
		String yesNo = sc.next().substring(0,1);
		sc.nextLine();
		
		if(yesNo.equalsIgnoreCase("y")) { 			// y를 입력하면
		
			System.out.print("정규직 등록 = 1 일용직 등록 = 2 >>> ");
			int inputNo = sc.nextInt();
			
				switch(inputNo) {
					
				case 1:	System.out.print("사번 입력 >>> ");			// 정규직 등록
						int regNo = sc.nextInt();
						
						System.out.print("이름 입력 >>> ");
						String regName = sc.next();
						sc.nextLine();
						
						System.out.print("급여 입력 >>> ");
						int salary = sc.nextInt();
		
						employees[idx++] = new Regular(regNo, regName, salary);	
						
							
						System.out.println("사번 : " + regNo + ", 이름 : " + regName + ", 급여 : " + salary + "원 등록되었습니다.");
						break;
				

				case 2: System.out.print("사번 입력 >>> ");			// 일용직 등록
						int temNo = sc.nextInt();
							
						System.out.print("이름 입력 >>> ");
						String temName = sc.next();
						sc.nextLine();
						
						Temporary tem = new Temporary(temNo, temName);
						
						System.out.print("시급 입력 >>> ");
						int pay = sc.nextInt();
						tem.setPay(pay);
						
						
						System.out.print("근무시간 입력 >>> ");
						int workTime = sc.nextInt();
						tem.setWorkTimes(workTime);
					
						employees[idx++] = tem;	
						
						System.out.println("사번 : " + temNo + ", 이름 : " + temName + ", 시급 : " + pay + "원, 근무시간 : " + workTime + "시간 등록되었습니다.");
				
						break;
						
				default : System.out.println("잘못된 값을 입력하셨습니다.");
				
				}
				
			
		} else {
			System.out.println("사원 등록이 취소되었습니다.");
			return;
		}
	}
						
			
		
	public void dropEmployee() {
		
		System.out.print("삭제하실 사원의 번호를 입력하세요 >>> ");
		int inputNo = sc.nextInt();
		
		for(int i = 0; i < employees.length; i++) {
			if(inputNo == idx) {
				System.arraycopy(employees, 0, employees, i + 1, idx + i - 1);
			}
		}
		
		
		
		
		if(inputNo == idx - 1) {
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void findEmployee() {
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void printAllEmployees() {
	
		System.out.println("=============== 사원 명단 출력 ===============");
			
		
			for(int i = 0; i < employees.length; i++) {
				if(employees[i] != null) {
					System.out.println(employees[i]);														// employees[i]는 출력이 되는데 왜 employees[i].toString은 출력이 이상하게 되는지?
				}
			}
	}
	
	public void manage() {
		
		
		while(true) {
			System.out.print("1. 추가 2. 삭제 3. 조회 4. 목록 0. 종료 >>> ");
			int inputNo =  sc.nextInt();
			
			switch(inputNo) {
			case 1: addEmployee(); break;
			case 2: dropEmployee(); break;
			case 3: findEmployee(); break;
			case 4: printAllEmployees(); break;
			case 0: return;
			default : return;
			}
		}
		
	}
}
