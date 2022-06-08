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
			System.out.println("������ �Է����ּ���. [ [0] �߰� | [1] ���� | [2] ���� | [3] ��ȸ | [4] �ڷΰ��� ]");
			Scanner sc = new Scanner(System.in);
			int play = sc.nextInt();
			
			if(play == 0) {
				System.out.println("[0] : ��ǰ �߰�[��ǰ��, ����, ���]");
				String name = sc.next();
				int cost = sc.nextInt();
				addPrdt(name, cost);
				
			}
			else if(play == 1) {
				
				if(store.getPrdtList().isEmpty()) {
					System.out.println("������ �� �ִ� ��ǰ�� �����ϴ�.");
				}
				else {
					System.out.println("[1] : ��ǰ ����[��ǰ��ġ]");
					int idx = sc.nextInt();
					delPrdt(idx);
				}
				
				
			}
			else if(play == 2) {
				if(store.getPrdtList().isEmpty()) {
					
					System.out.println("������ �� �ִ� ��ǰ�� �����ϴ�.");
				}else {
					
					System.out.println("[2] : ��ǰ ����[��ǰ��ġ, ��ǰ��, ����]");
					int idx = sc.nextInt();
					String name = sc.next();
					int cost = sc.nextInt();
					modifyPrdt(idx, name, cost);
				}
				
			}
			else if(play == 3) {
				
				if(store.getPrdtList().isEmpty()) {
					System.out.println("��ȸ�� �� �ִ� ��ǰ�� �����ϴ�.");
				}else {
					System.out.println("[3] : ��ǰ ��ȸ");
					showinfo();
				}
				
			}
			else if(play == 4) {
				System.out.println("[4] : �ڷ� ����");
				
				break;
			}
			else{
				System.out.println("[�����ڸ��] : �߸��� �Է°��Դϴ�.");
			}
			
			System.out.println();
			
			
		}while(true);
		
	}
	
	public void addPrdt(String name, int cost) {
		
		store.getPrdtList().add(new Product(name, cost));
		System.out.printf("[%s] ��ǰ�� �߰��߽��ϴ�.\n", name);
	}
	
	public void delPrdt(int num) {
		
		System.out.println("���������� ��ǰ ���� �� : " + store.getPrdtList().size());
		if(store.getPrdtList().size() < num) {
			System.out.println("��ǰ�� �������� �ʽ��ϴ�.");
		}else {
			System.out.printf("[%d] [%s] ��ǰ�� �����߽��ϴ�.\n", num, store.prdtList.get(num).getPrdtNm());
			store.getPrdtList().remove(num);
			
		}
		
		
	}
	public void modifyPrdt(int idx, String name, int cost) {
		
		System.out.printf("���� �� : [%d] , ��ǰ�� : [%s] , ��ǰ���� [%d]\n", idx, store.getPrdtList().get(idx).getPrdtNm(), store.getPrdtList().get(idx).getPrdtCost());
		
		store.getPrdtList().get(idx).setPrdtNm(name);
		store.getPrdtList().get(idx).setPrdtCost(cost);
		
		System.out.printf("���� �� : [%d] , ��ǰ�� : [%s] , ��ǰ���� [%d]\n", idx, store.getPrdtList().get(idx).getPrdtNm(), store.getPrdtList().get(idx).getPrdtCost());
	
	}
	public void showinfo() {
		
		if (store.getPrdtList().isEmpty())
			System.out.println("��ϵ� ��ǰ�� �����ϴ�. ��ǰ�� �߰����ּ���.");
		else {			
			for(int i = 0; i < store.getPrdtList().size(); i++) {
				
				System.out.printf("��ǰ��ġ : [%d] ��ǰ�� : [%s] ��ǰ���� : [%d]\n",i ,store.prdtList.get(i).getPrdtNm(), store.prdtList.get(i).getPrdtCost());
				
			}
		}
		
	}
}
