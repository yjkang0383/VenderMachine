package ch01;

import java.util.Scanner;

public class Customer {

	private int money;
	private String flag;
	
	public void setAction(Store store) {
		
		boolean flags = false;
				
		do {
			System.out.println("자판기 이용 여부를 입력해주세요 [ Y / N ]");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			flags = store.showSystemLog(str);
			
			System.out.println();
			
		}while(flags);
		
	}
	

}
