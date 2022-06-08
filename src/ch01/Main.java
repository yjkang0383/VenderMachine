package ch01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		
		Customer buyer = new Customer();
		Store store = new Store();
		buyer.setAction(store);
	}
}
