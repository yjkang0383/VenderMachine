package ch01;

import java.util.ArrayList;
import java.util.Scanner;

public class Store implements Comparable<Store> {
	private int prdtNo;   // 1.상품번호
	private int prdtCost; // 2.상품가격
	private int curCoin;   //3. 현재잔액
    private int[] cash = {100, 500, 1000, 5000, 10000, 50000};
    private int cnt = 0;
	
	Scanner sc = new Scanner(System.in);
	
	/* 상품명을 담을 ArrayList 선언 */
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
            System.out.println((i+1) + "." + cash[i] + "원");
        }
    }
    
    public void buyAble_menu(int count) {
    	count = 0;
		System.out.println("===================== 판매 중인 상품 ===================== ");
    	for(int i = 0; i < prdtList.size(); i++) {
    		System.out.printf("판매중인 상품 : [%d]번 상품 [%s] : [%d]원\n", i, prdtList.get(i).getPrdtNm(), prdtList.get(i).getPrdtCost());
    	}
		System.out.println("====================================================== ");
		System.out.println("");
		
		for(int j = 0; j < prdtList.size(); j++) {
			if(this.curCoin >= prdtList.get(j).getPrdtCost()) {
				System.out.printf("구매가능 상품 : [%d]번 상품 [%s] : [%d]원\n", j, prdtList.get(j).getPrdtNm(), prdtList.get(j).getPrdtCost());
				System.out.printf("");
				
				count++;
				this.cnt=count;
				}
    		}
		}
   
    
    public int CountCoin() {
    	System.out.println("금액을 넣어주세요");
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
	    System.out.printf("현재 금액  [%d]원\n", this.curCoin);
	    buyAble_menu(cnt);
	    	
	    if(cnt >= 1){
	    	System.out.println("구입하시겠습니까? 돈을 더 투입하시겠습니까? [Y 구입   N 투입 ]");
	    	String answer = sc.next();
	    		
    		if (answer.equals("Y")){
    			selectPrdt();
    			
				if(this.curCoin < getMinCost()) {
					System.out.println("안녕히가세요");
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
				
				System.out.println("잔액이 부족합니다. 돈을 더 투입해주세요.");
				return;
			}
	
			else {
				
				System.out.println("상품번호를 입력해주세요.");
				int idx = sc.nextInt();
				this.prdtNo = idx;
				
				/*1. 투입금액 - 상품금액*/
				this.curCoin -= prdtList.get(prdtNo).getPrdtCost();
				
				/*2. 출력 */
				System.out.printf("상품번호 : [%d] 상품명 : [%s] 가격 : [%d] 을 구입하셨습니다. 반환금액 [%d]"
						, prdtNo
						, prdtList.get(prdtNo).getPrdtNm()
						, prdtList.get(prdtNo).getPrdtCost()
						, curCoin);
				
				if(this.curCoin < getMinCost()) {
					System.out.println("안녕히가세요");
					
				}else if(this.curCoin >= getMinCost()) {
					return ;
				}
			}
	}
	
	public boolean showSystemLog(String str) {
		
			if (str.equals("Y")) {
				/*자판기 이용*/
				
				if (prdtList.isEmpty()) {
					System.out.println("등록된 상품이 없습니다. 상품을 등록해주세요 ");
					Admin admin = new Admin(Store.this);
					admin.actorAdmin();
					return true;
				}	
				
				System.out.println("자판기를 이용합니다. 금액을 투입해주세요.");
				cash_menu();
				insertCoin();
				return true;
				}
				
				//state = false;

			else if(str.equals("N")) {
				/*자판기 이용안함*/
				System.out.println("안녕히 가세요.");
				return false;
			}
			else if(str.equals("2022")) {
				/*관리자모드 */
				System.out.print("관리자 모드입니다. ");
				
				Admin admin = new Admin(Store.this);
				admin.actorAdmin();
				return true;
			}
			else
				System.out.println("입력값을 잘못설정하셨습니다.");
				return true;
	}

	@Override
	public int compareTo(Store arg0) {
		// TODO Auto-generated method stub
		return Integer.compare(this.prdtCost, arg0.getPrdtCost());
	}
}
