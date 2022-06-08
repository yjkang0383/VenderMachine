package ch01;

import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Admin {
	
	private Store store;
	
	public Admin(Store store) {
		this.store = store;
	}
	
	public void actorAdmin() {
		
		do {
			System.out.println("동작을 입력해주세요. [ [0] 추가 | [1] 삭제 | [2] 수정 | [3] 조회 | [4] 뒤로가기 ]");
			Scanner sc = new Scanner(System.in);
			int play = sc.nextInt();
			
			if(play == 0) {
				System.out.println("[0] : 상품 추가[상품명, 가격, 재고]");
				String name = sc.next();
				int cost = sc.nextInt();
				addPrdt(name, cost);
				
			}
			else if(play == 1) {
				
				if(store.getPrdtList().isEmpty()) {
					System.out.println("삭제할 수 있는 상품이 없습니다.");
				}
				else {
					System.out.println("[1] : 상품 삭제[상품위치]");
					int idx = sc.nextInt();
					delPrdt(idx);
				}
				
				
			}
			else if(play == 2) {
				if(store.getPrdtList().isEmpty()) {
					
					System.out.println("수정할 수 있는 상품이 없습니다.");
				}else {
					
					System.out.println("[2] : 상품 수정[상품위치, 상품명, 가격]");
					int idx = sc.nextInt();
					String name = sc.next();
					int cost = sc.nextInt();
					modifyPrdt(idx, name, cost);
				}
				
			}
			else if(play == 3) {
				
				if(store.getPrdtList().isEmpty()) {
					System.out.println("조회할 수 있는 상품이 없습니다.");
				}else {
					System.out.println("[3] : 상품 조회");
					showinfo();
				}
				
			}
			else if(play == 4) {
				System.out.println("[4] : 뒤로 가기");
				
				break;
			}
			else{
				System.out.println("[관리자모드] : 잘못된 입력값입니다.");
			}
			
			System.out.println();
			
			
		}while(true);
		
	}
	
	public void addPrdt(String name, int cost) {
		
		store.getPrdtList().add(new Product(name, cost));
		System.out.printf("[%s] 상품을 추가했습니다.\n", name);
	}
	
	public void delPrdt(int num) {
		
		System.out.println("삭제가능한 상품 종류 수 : " + store.getPrdtList().size());
		if(store.getPrdtList().size() < num) {
			System.out.println("상품이 존재하지 않습니다.");
		}else {
			System.out.printf("[%d] [%s] 상품을 삭제했습니다.\n", num, store.prdtList.get(num).getPrdtNm());
			store.getPrdtList().remove(num);
			
		}
		
		
	}
	public void modifyPrdt(int idx, String name, int cost) {
		
		System.out.printf("수정 전 : [%d] , 상품명 : [%s] , 상품가격 [%d]\n", idx, store.getPrdtList().get(idx).getPrdtNm(), store.getPrdtList().get(idx).getPrdtCost());
		
		store.getPrdtList().get(idx).setPrdtNm(name);
		store.getPrdtList().get(idx).setPrdtCost(cost);
		
		System.out.printf("수정 후 : [%d] , 상품명 : [%s] , 상품가격 [%d]\n", idx, store.getPrdtList().get(idx).getPrdtNm(), store.getPrdtList().get(idx).getPrdtCost());
	
	}
	public void showinfo() {
		
		if (store.getPrdtList().isEmpty())
			System.out.println("등록된 상품이 없습니다. 상품을 추가해주세요.");
		else {			
			for(int i = 0; i < store.getPrdtList().size(); i++) {
				
				System.out.printf("상품위치 : [%d] 상품명 : [%s] 상품가격 : [%d]\n",i ,store.prdtList.get(i).getPrdtNm(), store.prdtList.get(i).getPrdtCost());
				
			}
		}
		
	}
}
