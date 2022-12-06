package ex03_functional_interface.sec02;

public class Main {

	public static void main(String[] args) {

		Myinterface2 my = (a) -> System.out.println(a);
		my.method(10);
		
	}

}
