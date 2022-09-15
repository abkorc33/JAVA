package object.polymorphism.poly02;	// 배열 사용 물건구입

class Product {
	int price;
	int bonusPoint;
	
	Product(int price) { // 제품 생산시 제품의 단가를 설정한다. 
		this.price = price;	// 제품가격
		bonusPoint = (int)(price/10);	// 보너스점수 == 제품가격의 1/10
	}
	
	Product() {
		price = 0;
		bonusPoint = 0;
	}
}

class Tv extends Product {
	Tv() {
		super(100);	// 부모클래스의 생성자인 Product(int price)를 의미한다
	}
	public String toString() {	// 오버라이딩
		return "텔레비전";
	}
}

class Notebook extends Product {
	Notebook() {
		super(200);	// 부모클래스의 생성자인 Product(int price)를 의미한다
	}
	public String toString() {	// 오버라이딩
		return "노트북";
	}
}

class Audio extends Product {
	Audio() {
		super(50);	// 부모클래스의 생성자인 Product(int price)를 의미한다
	}
	public String toString() {	// 오버라이딩
		return "오디오";
	}
}

class Buyer {	// 고객, 물건을 사는 사람
	int money = 1000;	// 소유금액
	int bonusPoint = 0;
	Product[] item = new Product[10];	// 구매한 제품에 대한 정보를 저장하기 위한 배열
	int counter = 0;	// Product배열에 사용될 카운터
	
	void buy(Product p) {	// 구매행위, 공동의 조상이므로 물건종류가 다양해도 buy메소드 하나만 사용해도 된다.
		if(money < p.price) {
			System.out.println("잔액이 부족합니다." + p +"을/를 구매할 수 없습니다.");
			return;
		}
		
		money -= p.price;	// 제품을 사기 위해서 돈을 지불한다.
		item[counter++] = p;	// 물건에 대한 정보를 item목록에 추가한다.
		bonusPoint += p.bonusPoint;	// 제품의 보너스점수를 받는다.
		System.out.println(p + " 을/를" + p.price + "만원을 주고 구매했습니다.");
	}
	
	void summary() {	// 구매한 제품에 대한 정보를 보여주는 행위
		int sum = 0;	// 구매한 제품들의 가격합계
		String itemList = "";	// 구매한 제품 목록
		
		// 반복문을 사용하여 구매한 제품들의 총 가격과 목록을 만든다.
		// 배열에 제품정보가 없으면 반복문을 종료시킨다.
		// 마지막 제품 뒤에는 쉼표를 붙이지 말것.
		for(int i = 0; i < item.length; i++) {
			if(item[i] == null) break;
			if(i > 0) itemList += ", ";
			sum += item[i].price;
			itemList += item[i];
			// itemList += (i == 0) ? "" + item[i] : ", " + item[i];
		}
		System.out.println("총 구매 금액 : " + sum + "만원");
		System.out.println("구매 목록 : " + itemList);
		
	}
}
public class PolyArgumentExam {

	public static void main(String[] args) {
		Tv tv = new Tv();
		Notebook nt = new Notebook();
		Audio ad = new Audio();
		Buyer buy1 = new Buyer();

		buy1.buy(tv);
		buy1.buy(nt);
		buy1.buy(ad);
		buy1.summary();

	}

}
