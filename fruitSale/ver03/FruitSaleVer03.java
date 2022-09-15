package fruitSale.ver03;	// 생성자를 통한 초기화

class FruitSeller {
	int numOfApple;
	int myMoney;
	final	int APPLE_PRICE;	// 상수(final)는 선언과 동시에 값을 지정해야 하나
								//초기화를 통해서 지정할 수 있다.
	public FruitSeller() {
		//myMoney = 15000;
		//numOfApple = 200;
		//APPLE_PRICE = 1500;
		this(15000, 200, 1500);	// 다른 생성자 또 만들 때 직접 이름xx this로 만들어준다
	}
	public FruitSeller(int money, int num) {
		this(money, num, 1500);
	}
	public FruitSeller(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;
	}
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		myMoney += money;
		numOfApple -= num;
		return num;
	}
	public void showSaleResult() {
		System.out.println("남은 사과 : " + numOfApple);
		System.out.println("판매 수익 : " + myMoney);
	}
}

class FruitBuyer {
	int myMoney;
	int numOfApple;
	
	public FruitBuyer(int money) {	// 생성자를 통해 돈을 준비한다.
		myMoney = money;
		numOfApple = 0;
	}
	public void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);	// 돈을 주고 사과를 받는다.
		myMoney -= money;	// 사과를 구매한 만큼 돈을 차감한다.
	}
	public void showBuyResult() {
		System.out.println("현재 잔액 : " + myMoney);
		System.out.println("사과 개수 : " + numOfApple);
	}
}

public class FruitSaleVer03 {

	public static void main(String[] args) {
		FruitSeller seller1 = new FruitSeller();
		FruitSeller seller2 = new FruitSeller(0, 150, 1300);
		
		FruitBuyer buyer1 = new FruitBuyer(15000);
		FruitBuyer buyer2 = new FruitBuyer(20000);
		
		buyer1.buyApple(seller2, 5000);
		buyer2.buyApple(seller1, 3000);
		
		System.out.println("과일 판매자 1의 현황");
		seller1.showSaleResult();
		System.out.println("과일 판매자 2의 현황");
		seller2.showSaleResult();
		
		System.out.println("과일 구매자 1의 현황");
		buyer1.showBuyResult();
		System.out.println("과일 구매자 2의 현황");
		buyer2.showBuyResult();
	}

}