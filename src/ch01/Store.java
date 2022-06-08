package ch01;

import java.util.ArrayList;
import java.util.Scanner;

public class Store implements Comparable<Store> {
	private int prdtNo;   // 1.��ǰ��ȣ
	private int prdtCost; // 2.��ǰ����
	private int curCoin;   //3. �����ܾ�
    private int[] cash = {100, 500, 1000, 5000, 10000, 50000};
    private int cnt = 0;
	
	Scanner sc = new Scanner(System.in);
	
	/* ��ǰ���� ���� ArrayList ���� */
	ArrayList<Product> prdtList = new ArrayList<Product>();
	
	public int getPrdtNo() {
		return prdtNo;
	}

	public void setPrdtNo(int prdtNo) {
		this.prdtNo = prdtNo;
	}

	public int getPrdtCost() {
		return prdtCost;
	}

	public void setPrdtCost(int prdtCost) {
		this.prdtCost = prdtCost;
	}

	public ArrayList<Product> getPrdtList() {
		return prdtList;
	}

	public void setPrdtList(ArrayList<Product> prdtList) {
		this.prdtList = prdtList;
	}
	
    public void cash_menu(){
	    for(int i = 0 ; i <= cash.length-1 ; i++)
        {
            System.out.println((i+1) + "." + cash[i] + "��");
        }
    }
    
    public void buyAble_menu(int count) {
    	count = 0;
		System.out.println("===================== �Ǹ� ���� ��ǰ ===================== ");
    	for(int i = 0; i < prdtList.size(); i++) {
    		System.out.printf("�Ǹ����� ��ǰ : [%d]�� ��ǰ [%s] : [%d]��\n", i, prdtList.get(i).getPrdtNm(), prdtList.get(i).getPrdtCost());
    	}
		System.out.println("====================================================== ");
		System.out.println("");
		
		for(int j = 0; j < prdtList.size(); j++) {
			if(this.curCoin >= prdtList.get(j).getPrdtCost()) {
				System.out.printf("���Ű��� ��ǰ : [%d]�� ��ǰ [%s] : [%d]��\n", j, prdtList.get(j).getPrdtNm(), prdtList.get(j).getPrdtCost());
				System.out.printf("");
				
				count++;
				this.cnt=count;
				}
    		}
		}
   
    
    public int CountCoin() {
    	System.out.println("�ݾ��� �־��ּ���");
	    int num = sc.nextInt();

		    this.curCoin += cash[num-1];
		    return curCoin;
    }
    
    public int getMinCost(){
    	int minCost = prdtList.get(0).getPrdtCost();
    	for(int i = 1; i < prdtList.size(); i++) {
    		if(minCost > prdtList.get(i).getPrdtCost()){
        		minCost = prdtList.get(i).getPrdtCost();
        	}
    	}
    	return minCost;
    }
    
public void insertCoin() {
	do {
	    CountCoin();
	    System.out.printf("���� �ݾ�  [%d]��\n", this.curCoin);
	    buyAble_menu(cnt);
	    	
	    if(cnt >= 1){
	    	System.out.println("�����Ͻðڽ��ϱ�? ���� �� �����Ͻðڽ��ϱ�? [Y ����   N ���� ]");
	    	String answer = sc.next();
	    		
    		if (answer.equals("Y")){
    			selectPrdt();
    			
				if(this.curCoin < getMinCost()) {
					System.out.println("�ȳ���������");
					break;
					
				}else if(this.curCoin >= getMinCost()) {
					return ;
				}
    		}
    		else {
    			insertCoin();
    			}
    		}
	    }while(true);
}
	    
public void selectPrdt() {
			if(curCoin < prdtList.get(prdtNo).getPrdtCost()) {
				
				System.out.println("�ܾ��� �����մϴ�. ���� �� �������ּ���.");
				return;
			}
	
			else {
				
				System.out.println("��ǰ��ȣ�� �Է����ּ���.");
				int idx = sc.nextInt();
				this.prdtNo = idx;
				
				/*1. ���Աݾ� - ��ǰ�ݾ�*/
				this.curCoin -= prdtList.get(prdtNo).getPrdtCost();
				
				/*2. ��� */
				System.out.printf("��ǰ��ȣ : [%d] ��ǰ�� : [%s] ���� : [%d] �� �����ϼ̽��ϴ�. ��ȯ�ݾ� [%d]"
						, prdtNo
						, prdtList.get(prdtNo).getPrdtNm()
						, prdtList.get(prdtNo).getPrdtCost()
						, curCoin);
				
				if(this.curCoin < getMinCost()) {
					System.out.println("�ȳ���������");
					
				}else if(this.curCoin >= getMinCost()) {
					return ;
				}
			}
	}
	
	public boolean showSystemLog(String str) {
		
			if (str.equals("Y")) {
				/*���Ǳ� �̿�*/
				
				if (prdtList.isEmpty()) {
					System.out.println("��ϵ� ��ǰ�� �����ϴ�. ��ǰ�� ������ּ��� ");
					Admin admin = new Admin(Store.this);
					admin.actorAdmin();
					return true;
				}	
				
				System.out.println("���Ǳ⸦ �̿��մϴ�. �ݾ��� �������ּ���.");
				cash_menu();
				insertCoin();
				return true;
				}
				
				//state = false;

			else if(str.equals("N")) {
				/*���Ǳ� �̿����*/
				System.out.println("�ȳ��� ������.");
				return false;
			}
			else if(str.equals("2022")) {
				/*�����ڸ�� */
				System.out.print("������ ����Դϴ�. ");
				
				Admin admin = new Admin(Store.this);
				admin.actorAdmin();
				return true;
			}
			else
				System.out.println("�Է°��� �߸������ϼ̽��ϴ�.");
				return true;
	}

	@Override
	public int compareTo(Store arg0) {
		// TODO Auto-generated method stub
		return Integer.compare(this.prdtCost, arg0.getPrdtCost());
	}
}
