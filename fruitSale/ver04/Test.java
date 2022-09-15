package fruitSale.ver04;

import java.util.Scanner;


// 모든 변수 클래스
class Variation{
	
	int apple;
	int applePrice;
	int appleMoney;
	
	int orange;
	int orangePrice;
	int orangeMoney;
	
	
	
	// default 생성자
	Variation(){	
	}

	// 사과 판매자 생성자
	Variation(int apple, int applePrice, int appleMoney ){
		this.apple = apple;
		this.applePrice = applePrice;
		this.appleMoney = appleMoney;
	}
	
	// 오렌지 판매자 생성자
	Variation(int orange, int orangePrice, int orangeMoney, int a ){	
		this.orange = orange;
		this.orangePrice = orangePrice;
		this.orangeMoney = orangeMoney;
	}	
}


// 판매자 등록
class seller extends Variation{
		
	
	final int MAX_CNT = 100 ;
	Variation[] AplSellerStorage = new Variation[MAX_CNT];
	Variation[] OriSellerStorage = new Variation[MAX_CNT];
	int appleIndex = 0;
	int orangeIndex = 0;

	public void sellerMenu() {	

		while(true) {
			System.out.println("=======================================================================");
			System.out.println("1.사과  2. 오렌지");
			System.out.print("원하시는 판매 물품을 고르세요 : ");
			
			int sellerChoice = MenuView.keyboard.nextInt();

			
			if(sellerChoice == 1 || sellerChoice == 2) {
				switch(sellerChoice){
					case 1 : {
						System.out.print("판매할 사과의 갯수 : ");		
						int apple = MenuView.keyboard.nextInt();	
						System.out.print("사과의 가격 : ");		
						int applePrice = MenuView.keyboard.nextInt();		
						System.out.print("판매자님 잔액 : ");		
						int appleProfit = MenuView.keyboard.nextInt();	
						
						AplSellerStorage[appleIndex++] = new Variation( apple, applePrice, appleProfit);
						System.out.println("사과 판매자로 등록 되었습니다.");
						break;
					}
		
					case 2 : {
						System.out.print("판매할 오렌지의 갯수 : ");		
						int orange = MenuView.keyboard.nextInt();	
						System.out.print("오렌지의 가격 : ");		
						int orangePrice = MenuView.keyboard.nextInt();		
						System.out.print("판매자님 잔액 : ");		
						int orangeProfit = MenuView.keyboard.nextInt();	
						
						OriSellerStorage[orangeIndex++] = new Variation( orange, orangePrice, orangeProfit, 1 );
						System.out.println("오렌지 판매자로 등록 되었습니다.");			
						break;
					}
				}
				break;
			} else {
				System.out.println("다시 입력 부탁 드립니다.");
				continue;
			}
		}
	}
} // class seller - End



// 기능 모음집
class Function {
	
	seller seller1 = new seller();
	
	
	public void choice1() {
		
		
	}
	
	public void choice2() {
		
	}
	
	public void choice3() {
		
	}

	public void choice4() {
		seller1.sellerMenu();
	}
	
}




// 메뉴 보여주는 클래스 1사과 2오렌지 3구매자현황 0종료
class MenuView {
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void menu() {
		System.out.println("1.사과 구매 2.오렌지 구매 3.구매자현황 4. 판매자 등록 0.종료");
		System.out.print("해당하는 번호를 누르십시오 : ");
	}
}



// 메인
public class Test {

	public static void main(String[] args) {
		
		Function Function = new Function();
		
		
		int choice = 0;
		
		while(true) {
			
		MenuView.menu();	// 반복문의 처음, 메뉴 보여주기
		choice = MenuView.keyboard.nextInt();	// 임의의 입력값 받기
		
		
		if(0<=choice && choice < 5){
			switch(choice) {
//			case 1: choice1();	
//				break;
//			case 2: choice2();
//				break;
//			case 3: choice3();
//				break;
			case 4: Function.choice4();
				break;
			case 0:	// 프로그램 종료
				return;
			} 		
		} else {
			System.out.println("허용되지 않는 숫자입니다.");
		}
		}
	}
}