package object.polymorphism.poly01;	// 객체의 다형성
//공동의 조상이므로 물건종류가 다양해도 buy메소드 하나만 사용해도 된다.

class Product {
	int price;	// 제품의 가격
	int bonusPoint;	// 제품 구매 시 제공되는 보너스 점수
	
	Product(int price) {
		this.price = price;	// 제품생산 시 가격을 설정한다.(생성자를 통해서)
		bonusPoint = (int)(price/10);	// 보너스 점수는 제품가격의 10%
	}
}

class Tv extends Product {
	Tv() {	// 조상클래스의 생성자 Product(int price)를 호출한다.
		super(100);	//부모클래스의 Product(int price)를 의미함, tv가격 100만원
	}
	public String toString() {	// Object클래스의 toString()을 오버라이딩 한다.
		return "Tv";
	}
}
class Notebook extends Product {
	Notebook() {	// 조상클래스의 생성자 Product(int price)를 호출한다.
		super(150);	//부모클래스의 Product(int price)를 의미함, Notebook가격 150만원
	}
	public String toString() {	// Object클래스의 toString()을 오버라이딩 한다.
		return "Notebook";
	}
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	
	//void buyTv() {}
	//void buyNotebook() {}
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		money -= p.price;	// 가진 돈에서 물건의 가격만큼 차감한다.
		bonusPoint += p.bonusPoint;	// 보너스점수를 챙긴다.
		System.out.println(p + "을/를 구매하였습니다.");
	}
}

public class PolyArgumentExam {

	public static void main(String[] args) {
		
		Buyer b = new Buyer();	// 구매자 등장
		Tv tv = new Tv();	// 판매할 tv
		Notebook nb = new Notebook();	// 판매할 노트북
		
		b.buy(tv);
		b.buy(nb);
		
		System.out.println("현재 남은 돈 : " + b.money + "만원 입니다.");
		System.out.println("현재 보너스 점수는 " + b.bonusPoint + "포인트 입니다.");
	}

}
