package fruitSale.ver01;

//과일장수 객체
class FruitSeller {
			int numOfApple = 100;	// 사과 보유 갯수
			int myMoney = 0;	// 보유 금액
	final 	int APPLE_PRICE = 1000;	// 값이 바뀌지 않을 때 final 씀, 사과 1개 금액
	
	// 파는 행위
	public int saleApple(int money) {	// 돈을 받는다. =>(int money)
		int num = money / APPLE_PRICE;	// 받은 돈에 해당하는 사과의 개수
		myMoney += money;	// 받은 돈을 돈주머니에 넣는다.
		numOfApple -= num;	// 판매한 사과만큼 사과의 갯수가 줄어든다.
		return num;	// 사과를 구매자에게 준다.
	}
	// 판매 현황
	public void showSaleResult() {
		System.out.println("남은 사과의 개수 : " + numOfApple);
		System.out.println("오늘 번 돈 : " + myMoney);
	}
}

//과일구매자 객체
class FruitBuyer {
	int myMoney = 50000;	// 보유 금액
	int numOfApple = 0;		// 사과 보유 갯수
	
	// 과일 구매 행위 (어느 과일장수에게 돈을 주고 사과를 구매한다.)
	public void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);	// 과일장수에게 돈을 주고 과일을 건네받는다.
		myMoney -= money;	// 과일 판매 금액을 차감한다.
	}
	
	// 시장에서 장 본 결과
	public void showBuyResult() {
		System.out.println("현재 남은 돈 : " + myMoney);
		System.out.println("사과 구매 개수 : " + numOfApple);
	}
}
public class FruitSaleVer01 {

	public static void main(String[] args) {
		// 시장, 과일장수와 과일구매자가 거래함
		// 과일 장수 3명 등장
		FruitSeller seller1 = new FruitSeller();
		FruitSeller seller2 = new FruitSeller();
		FruitSeller seller3 = new FruitSeller();
		
		// 과일 구매자 등장
		FruitBuyer buyer = new FruitBuyer();
		
		// 과일 구매하는 행위
		buyer.buyApple(seller1, 10000);
		buyer.showBuyResult();  // 과일 구매자의 현재 상황 
		seller1.showSaleResult();  // 과일 판매자의 현재 상황
		
		buyer.buyApple(seller2, 20000);
		buyer.showBuyResult();  // 과일 구매자의 현재 상황 
		seller2.showSaleResult();  // 과일 판매자의 현재 상황

	}

}
