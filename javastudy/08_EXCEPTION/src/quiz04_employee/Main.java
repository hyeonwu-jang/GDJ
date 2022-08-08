package quiz04_employee;

public class Main {

	public static void main(String[] args) {

				try {
					new Company().manage();
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	
	}

}
