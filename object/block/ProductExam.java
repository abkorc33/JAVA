package object.block;

class Product {
	static 	int count = 0;	// 생성된 제품(인스턴스)의 수를 저장하기 위한 변수
			int serialNo;	//제품(인스턴스) 고유의 번호
	{
		++count;	// 제품이 생산될 때마다 총 생산량은 1씩 증가한다.
		serialNo = count;
	}
	public Product() {	// 생성자
		System.out.println("제품을 1대 생산했습니다.");
	}
}

public class ProductExam {

	public static void main(String[] args) {
		
		Product p1 = new Product();	// 이름만 같고 서로 다른 객체
		Product p2 = new Product();
		Product p3 = new Product();
		
		System.out.println("p1의 제품번호는 " + p1.serialNo);
		System.out.println("p1의 제품번호는 " + p2.serialNo);
		System.out.println("p1의 제품번호는 " + p3.serialNo);
		
		System.out.println("생산된 제품의 총 수량 : " + Product.count);
		System.out.println("생산된 제품의 총 수량 : " + p1.count);	// 이렇게 써도됨

	}

}
