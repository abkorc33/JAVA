package object.polymorphism.poly03;	// 벡터 사용 물건구입

import java.util.Vector;

class Product {
	int price;
	int bonusPoint;
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10);
	}
}

class Tv extends Product{
	Tv() { super(100);}
	public String toString() { return "텔레비전"; }
}

class Notebook extends Product{
	Notebook() { super(200);}
	public String toString() { return "노트북"; }
}

class Audio extends Product{
	Audio() { super(50);}
	public String toString() { return "오디오"; }
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Vector item = new Vector();	// 데이터 타입이 벡터, import java.util.Vector;
	// 10개의 객체를 저장할 수 있는 Vector인스턴스. 기본 10개에 그 다음부터는 알아서 증가시켜줌
	
	void buy(Product p) {	// 제품 구매 행위
		if(money < p.price) {
			System.out.println("돈이 모자라서 제품 구매 불가");
			return;
		}
		money -= p.price;
		item.add(p);	// 구입한 제품을 Vector에 저장한다. add(값)
		bonusPoint += p.bonusPoint;
		System.out.println(p + "을/를 구매하였습니다.");
	}
	
	void refund(Product p) {	// 제품 환불
		if(item.remove(p)) {	// 제품을 반납한다.
			money += p.price;	// 돈을 돌려받는다.
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을/를 반품하였습니다.");
		}else {
			System.out.println("구매하신 제품 중 해당 제품이 없습니다.");
		}
	}
	
	void summary() {	// 구매한 정보를 보여줌
		int sum = 0;
		String itemList = "";
		
		if(item.isEmpty()) {	// vector가 비어있는지 확인한다. 참이면 비어있다는 뜻
			System.out.println("구매한 물건이 없습니다.");
			return;
		}
		
		// vector의 i 번째 있는 객체를 얻어온다.
		for(int i = 0; i < item.size(); i++) {	// size()는 길이를 알고자 할때 사용
			Product p = (Product)item.get(i);	// get()은 정보를 가져올 때 사용
			sum += p.price;
			itemList += (i == 0) ? "" + p : ", " + p;
		}
		System.out.println("구입하신 제품들의 총 구매 비용 : " + sum + "만원입니다.");
		System.out.println("구입하신 제품들은 : " + itemList + "입니다.");
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
		buy1.buy(tv);
		buy1.summary();
		System.out.println();
		
		buy1.refund(tv);
		buy1.summary();
	}

}
