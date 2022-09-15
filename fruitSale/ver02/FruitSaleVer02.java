package fruitSale.ver02;

class FruitSeller {
	int numOfApple;		// 사과 보유 개수
	int myMoney;		// 판매 수익
	int APPLE_PRICE;	// 사과 1개당 판매금액
	
	// 사과를 파는 행위(돈을 받고(parameter) 사과를 건네준다.(return))
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;	// 받은 돈에 해당하는 사과의 개수를 계산한다.
		myMoney += money;	// 돈을 받아서 주머니에 넣는다.
		numOfApple -= num;	// 판매한 수량만큼 사과의 개수를 차감한다.
		return num;	// 사과를 구매자에게 건네준다.
	}
	// 판매 현황 보기
	public void showSaleResult() {
		System.out.println("남은 사과 : " + numOfApple);
		System.out.println("판매 수익 : " + myMoney);
	}
	public void initMembers(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price;
	}
}

class FruitBuyer {
	int myMoney = 50000;	// 구매자 객체마다 금액을 틀리게 생성하려면 이부분을 수정해야한다.
	int numOfApple = 0;
	
	// 과일을 구매하는 행위 : 누구에게 돈을 주고 과일을 건네받는다.
	public void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);	// 돈을 주고 사과를 산다.
		myMoney -= money;
	}
	
	// 시장에 가서 장을 본 결과를 보는 행위
	public void showBuyResult() {
		System.out.println("현재 잔액 : " + myMoney);
		System.out.println("사과 개수 : " + numOfApple);
	}
}

public class FruitSaleVer02 {

	public static void main(String[] args) {
		FruitSeller seller1 = new FruitSeller();	// 사과 장수1
		seller1.initMembers(0, 100, 1000);
		
		FruitSeller seller2 = new FruitSeller();	// 사과 장수2
		seller2.initMembers(10000, 50, 1400);
		
		FruitSeller seller3 = new FruitSeller();	// 사과 장수3
		seller3.initMembers(5000, 70, 1500);

		FruitBuyer buyer1 = new FruitBuyer();	// 과일 구매자1
		
		FruitBuyer buyer2 = new FruitBuyer();	// 과일 구매자2
		
		buyer1.buyApple(seller2, 3900);
		buyer1.buyApple(seller3, 4500);
		
		System.out.println("과일 판매자 1의 상황");
		seller1.showSaleResult();
		System.out.println("과일 판매자 2의 상황");
		seller2.showSaleResult();
		System.out.println("과일 판매자 3의 상황");
		seller3.showSaleResult();
		
		System.out.println("과일 구매자 1의 상황");
		buyer1.showBuyResult();
		System.out.println("과일 구매자 2의 상황");
		buyer2.showBuyResult();
		
	}

}