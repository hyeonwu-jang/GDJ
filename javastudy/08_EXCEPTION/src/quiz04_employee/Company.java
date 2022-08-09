package quiz04_employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Company {
	
	private Employee[] employees;
	private int idx;
	private Scanner sc;
	
	public Company() {
		employees = new Employee[5];
		sc = new Scanner(System.in);
		
	}
	
	public void addEmployee() throws EmployeeException {
		if(idx == employees.length) {
			throw new EmployeeException("Full", 1);
		}
	
		System.out.print("1. 정규직 등록 2. 일용직 등록 >>> ");
		int inputNo = sc.nextInt();
			
		switch(inputNo) {
			
		case 1:	
				System.out.print("사번 입력 >>> ");			// 정규직 등록
				int regNo = sc.nextInt();
				
				System.out.print("이름 입력 >>> ");
				String regName = sc.next();
				sc.nextLine();
			
				System.out.print("기본급 입력 >>> ");
				int salary = sc.nextInt();

				employees[idx++] = new Regular(regNo, regName, salary);	
				
				System.out.println("사번 : " + regNo + ", 이름 : " + regName + ", 급여 : " + salary + "원 등록되었습니다.");
				break;
		

		case 2: 
				System.out.print("사번 입력 >>> ");			// 정규직 등록
				int temNo = sc.nextInt();
				
				System.out.print("이름 입력 >>> ");
				String temName = sc.next();
				sc.nextLine();
		
				System.out.print("시급 입력 >>> ");
				int pay = sc.nextInt();
				
				System.out.print("근무시간 입력 >>> ");
				int workTime = sc.nextInt();
				
				Temporary tem = new Temporary(temNo, temName);
				tem.setPay(pay);
				tem.setWorkTimes(workTime);
				employees[idx++] = tem;	
				
				System.out.println("사번 : " + temNo + ", 이름 : " + temName + ", 시급 : " + pay + "원, 근무시간 : " + workTime + "시간 등록되었습니다.");
				break;
				
		default : throw new EmployeeException("Bad request", 3);
	
		}
	}
						
	public void dropEmployee() throws EmployeeException {
		
	    if(idx == 0) {
		throw new EmployeeException("Empty", 2);
		}
		
		System.out.print("삭제하실 사원의 번호를 입력하세요 >>> ");
		int inputNo = sc.nextInt();
		
		for(int i = 0; i < idx; i++) {
			if(inputNo == employees[i].getEmpNo()) {
				System.arraycopy(employees, i + 1, employees, i, idx - i - 1);
				employees[--idx] = null;
				System.out.println(inputNo + "번 사원이 삭제되었습니다.");
				return;
			}
		}

		throw new EmployeeException("Not found", 4);
	}
		
		
	public void findEmployee() throws EmployeeException {
		 
		if(idx == 0) {															
				throw new EmployeeException("Empty", 2);
		}
		 
		System.out.print("1. 사원번호로 찾기 2. 이름으로 찾기");
		
		int inputNo = sc.nextInt();
		
		switch(inputNo) {
		
		case 1: System.out.print("찾으실 사원번호를 입력하세요 >>> ");
				int empNo = sc.nextInt();
				
				for(int i = 0; i < idx; i++) {
					if(empNo == employees[i].getEmpNo()) {
						System.out.println(employees[i].toString());
						return;
					}
				}
	
		case 2: System.out.print("찾으실 이름을 입력하세요 >>> ");
				String empName = sc.next();
				sc.nextLine();
				
				for(int i = 0; i < idx; i++) {
					if(empName.equals(employees[i].getName())) {
						System.out.println(employees[i].toString());
						return;
					}
				}

		default : throw new EmployeeException("Bad request", 3);
		
		}
	}

	
	public void printAllEmployees() throws EmployeeException {
	
		if(idx == 0) {															 
			throw new EmployeeException("Empty", 2);
		}
		
		System.out.println("=============== 사원 명단 출력 ===============");
		
		System.out.println("전체 사원 목록(" + idx + "명)");
		for(int i = 0; i < idx; i++) {
			System.out.println(employees[i]);
		}
	}
	
	
	
	public void manage() throws EmployeeException {
		
		while(true) {
			try {
			
				System.out.print("1. 추가 2. 삭제 3. 조회 4. 목록 0. 종료 >>> ");
				int inputNo =  sc.nextInt();
				
					switch(inputNo) {
					case 1: addEmployee(); break;
					case 2: dropEmployee(); break;
					case 3: findEmployee(); break;
					case 4: printAllEmployees(); break;
					case 0: return;
					default : throw new EmployeeException("Bad request", 3);
					}
					
				} catch(InputMismatchException e) {  // InputMismatchException -> EmployeeException으로 변경
					sc.next();
					try {
						throw new EmployeeException("Bad request", 3);  // 잘못된 요청
					} catch(EmployeeException e2) {
						System.out.println(e2.getMessage() + "," + e2.getErrorCode());
					}
				} catch(EmployeeException e) {
					System.out.println(e.getMessage() + "," + e.getErrorCode());
				} 
				
					
					
					
					
					
					
					
					
				
					
					
			}	
	}
	
	
	
	
	
}
