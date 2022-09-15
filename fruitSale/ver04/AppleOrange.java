package fruitSale.ver04;

import java.util.Scanner;

// 판매자 클래스, 보유한 금액, 판매할 과일 수, 과일금액, 과일 판매 행위
class FruitSale {
	int myMoney;
	int AppleNum;
	int OrangeNum;
	int FruitPrice;
	
	public void AppleSeller(int money, int num, int price) {
		myMoney = money;
		AppleNum = num;
		FruitPrice = price;
	}
	
	public void OrangeSeller(int money, int num, int price) {
		myMoney = money;
		OrangeNum = num;
		FruitPrice = price;
	}
	
	public int AppleSale(int money) {
		int num = money / FruitPrice;
		myMoney += money;
		AppleNum -= num;
		return num;
	}
	
	public int OrangeSale(int money) {
		int num = money / FruitPrice;
		myMoney += money;
		OrangeNum -= num;
		return num;
	}
	
// 사과, 오렌지 판매자 남은과일 개수 판매수익
	public void appleSaleResult() {
		System.out.println();
		System.out.println("[사과 판매자]");
		System.out.println("남은 사과 개수 : " + AppleNum);
		System.out.println("사과 판매 수익 : " + myMoney);
		System.out.println();
	}
	
	public void orangeSaleResult() {
		System.out.println();
		System.out.println("[오렌지 판매자]");
		System.out.println("남은 오렌지 개수 : " + OrangeNum);
		System.out.println("오렌지 판매 수익 : " + myMoney);
		System.out.println();
	}
}

// 구매자 클래스, 보유 금액, 과일 구매 행위
class FruitBuy {
	int myMoney;
	int AppleNum;
	int OrangeNum;
	
	public void Buyer(int money) {
		myMoney = money;
		AppleNum = 0;
		OrangeNum = 0;
	}
	
	public void BuyApple(FruitSale seller) {
		System.out.println();
		System.out.println("사과를 얼만큼 사시겠습니까?");
		int money = Menu.keyboard.nextInt();
		AppleNum += seller. AppleSale(money);
		myMoney -= money;
	}
	
	public void BuyOrange(FruitSale seller) {
		System.out.println();
		System.out.println("오렌지를 얼만큼 사시겠습니까?");
		int money = Menu.keyboard.nextInt();
		OrangeNum += seller. OrangeSale(money);
		myMoney -= money;
	}
	
// 사과 구매자 잔액, 사과개수, 오렌지 개수
	public void BuyResult() {
		System.out.println();
		System.out.println("[과일 구매자]");
		System.out.println("현재 잔액 : " + myMoney);
		System.out.println("사과 개수 : " + AppleNum);
		System.out.println("오렌지 개수 : " + OrangeNum);
		System.out.println();
	}
}

// 메뉴 보여주는 클래스 1사과 2오렌지 3구매자현황 0종료
class Menu {
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void MenuView() {
		System.out.println("1.사과 구매 2.오렌지 구매 3.구매자현황 0.종료");
		System.out.print("해당하는 번호를 누르십시오 : ");
	}
}

public class AppleOrange {

	public static void main(String[] args) {
		
		FruitSale seller1 = new FruitSale();	// 사과장수 생성
		seller1.AppleSeller(0, 50, 1000);		// 돈, 사과갯수, 과일가격
		FruitSale seller2 = new FruitSale();	// 오렌지장수 생성
		seller2.OrangeSeller(0, 50, 1000);		// 돈, 오렌지갯수, 과일가격
		
		FruitBuy buyer1 = new FruitBuy();	// 구매자 생성
		buyer1.Buyer(20000);	// 구매자의 소지금
		
		int choice = 0;
		
		while(true) {
			
		Menu.MenuView();	// 반복문의 처음, 메뉴 보여주기
		choice = Menu.keyboard.nextInt();	// 임의의 입력값 받기
		
			switch(choice) {
			case 1: buyer1.BuyApple(seller1);	// 사과를 산다
					seller1.appleSaleResult();	// 사과판매자현황
					buyer1.BuyResult();		// 구매자현황
				break;
			case 2: buyer1.BuyOrange(seller2);	// 오렌지를 산다
					seller2.orangeSaleResult();	// 오렌지판매자현황
					buyer1.BuyResult();		// 구매자현황
				break;
			case 3: buyer1.BuyResult();	//구매자현황
				break;
			case 0:	// 프로그램 종료
				return;
			}
		}

	}

}