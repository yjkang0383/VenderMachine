package ch01;

import java.util.Scanner;

public class Customer {

	private int money;
	private String flag;
	
	public void setAction(Store store) {
		
		boolean flags = false;
				
		do {
			System.out.println("���Ǳ� �̿� ���θ� �Է����ּ��� [ Y / N ]");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			flags = store.showSystemLog(str);
			
			System.out.println();
			
		}while(flags);
		
	}
	

}
