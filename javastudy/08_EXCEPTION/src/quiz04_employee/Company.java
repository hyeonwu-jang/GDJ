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
		
		
		//if(employees.length > 5) {											// 틀림.
		if(idx == employees.length) {
			throw new EmployeeException("사원이 가득찼습니다.", 1);
		}
		
		System.out.print("1. 사원 추가 (y) 2. 취소 (n) >>> ");
		
		String yesNo = sc.next().substring(0,1);
		sc.nextLine();
		
		if(yesNo.equalsIgnoreCase("y")) { 			// y를 입력하면
		
			System.out.print("1. 정규직 등록 2. 일용직 등록 >>> ");
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
						
				// default : System.out.println("잘못된 값을 입력하셨습니다.");			// 틀림
				default : throw new EmployeeException("잘못된 값을 입력하셨습니다.", 3);
						  
				
				}
				
			
		} else {
			System.out.println("사원 등록이 취소되었습니다.");
			return;
		}
	}
						
			
		
	public void dropEmployee() throws EmployeeException {
		
		// if(employees[idx] == null) { 										// 틀림.
		   if(idx == 0) {
			throw new EmployeeException("사원이 없습니다.", 2);
		}
		
		System.out.print("삭제하실 사원의 번호를 입력하세요 >>> ");
		int inputNo = sc.nextInt();
		
		// for(int i = 0; i < employees.length; i++) { 							// 틀림.
			for(int i = 0; i < idx; i++) {
			if(inputNo == employees[i].getEmpNo()) {
				System.arraycopy(employees, i + 1, employees, i, idx - i - 1);
				employees[--idx] = null;
				System.out.println(inputNo + "번 사원이 삭제되었습니다.");
				return;
			}
		}
																				//  틀림. 찾는 사원이 없는 경우.
		throw new EmployeeException("입력한 값과 일치하는 정보가 없습니다.", 4);
	}
		
		
	public void findEmployee() throws EmployeeException {
		 
		if(idx == 0) {															// 틀림. 
				throw new EmployeeException("사원이 없습니다.", 2);
		}
		 
		System.out.print("1. 사원번호로 찾기 2. 이름으로 찾기");
		int inputNo = sc.nextInt();
		switch(inputNo) {
		case 1: System.out.print("찾으실 사원번호를 입력하세요 >>> ");
				int empNo = sc.nextInt();
				// for(int i = 0; i < employees.length; i++) {
				for(int i = 0; i < idx; i++) {
					if(empNo == employees[i].getEmpNo()) {
						System.out.println(employees[i].toString());
						return;
					}
					
				}
	
		case 2: System.out.print("찾으실 이름을 입력하세요 >>> ");
				String empName = sc.next();
				sc.nextLine();
				
				// for(int i = 0; i < employees.length; i++) {
				for(int i = 0; i < idx; i++) {
					if(empName.equals(employees[i].getName())) {
						System.out.println(employees[i].toString());
						return;
					}
					
				}
				
				
		// default : System.out.println("잘못된 값을 입력하셨습니다.");						틀림.
		default : throw new EmployeeException("잘못된 값을 입력하셨습니다.", 3);
		
		}
		
		
		
	}

	
	public void printAllEmployees() throws EmployeeException {
	
		if(idx == 0) {															 
			throw new EmployeeException("사원이 없습니다.", 2);
		}
		
		/*
		if(employees[idx] == null) {																틀림.
			throw new EmployeeException("사원이 없습니다.", 2000);
		}
		*/
		
		System.out.println("=============== 사원 명단 출력 ===============");
		
		/*
			for(int i = 0; i < employees.length; i++) {
				if(employees[i] != null) {
					System.out.println(employees[i]);														// employees[i]는 출력이 되는데 왜 employees[i].toString은 출력이 이상하게 되는지?
				}
			}
		*/	
		
		
		System.out.println("전체 사원 목록(" + idx + "명)");
		for(int i = 0; i < idx; i++) {
			System.out.println(employees[i]);
		}
	}
	
	
	
	public void manage() throws EmployeeException {
		
		// try {																				틀림,
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
					// default : return;														틀림,
					default : throw new EmployeeException("잘못된 값을 입력하셨습니다.", 3);
					}
					
					/*
					
					} catch(EmployeeException e) {
						System.out.println(e.getMessage() + e.getErrorCode());
					} catch(InputMismatchException e) {
						System.out.println("잘못된 값을 입력하셨습니다.");
					} 
			
					*/
					
				} catch(InputMismatchException e) {  // InputMismatchException -> EmployeeException으로 변경
					sc.next();
					try {
						throw new EmployeeException("잘못된 값을 입력하셨습니다.", 3);  // 잘못된 요청
					} catch(EmployeeException e2) {
						System.out.println(e2.getMessage() + "," + e2.getErrorCode());
					}
				} catch(EmployeeException e) {
					System.out.println(e.getMessage() + "," + e.getErrorCode());
				} 
					
					
					
					
					
					
					
					
				
					
					
			}	
	}
	
	
	
	
	
}
