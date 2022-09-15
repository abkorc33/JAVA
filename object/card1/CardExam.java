package object.card1;

class Card {
	String kind;	// 카드의 무늬	// 인스턴스 변수
	int number;		// 카드의 숫자	// 인스턴스 변수
	static int width = 120;		// 카드의 폭	// 공통으로 쓰는 변수는 static으로 만들어준다.
	static int height = 260;		// 카드의 높이	// 클래스 변수	// new안붙이고 그냥 쓸 수 있음
}

public class CardExam {

	public static void main(String[] args) {
		
		System.out.println("카드의 폭 : " + Card.width);
		System.out.println("카드의 높이 : " + Card.height);
		//System.out.println("카드의 숫자 : " + Card.number);
		
		Card c1 = new Card();	//인스턴스 변수는 생성시 쓸 수 있음
		c1.kind = "Heart";
		c1.number = 4;
		
		Card c2 = new Card();
		c2.kind = "Diamond";
		c2.number = 9;
		
		System.out.println("c1 => " + c1.kind + ", " + c1.number + ", " + c1.width + ", " + c1.height);
		System.out.println("c2 => " + c2.kind + ", " + c2.number + ", " + c2.width + ", " + c2.height);
		
		c1.width = 200;
		c2.height = 400;
		
		System.out.println("c1 => " + c1.kind + ", " + c1.number + ", " + c1.width + ", " + c1.height);
		System.out.println("c2 => " + c2.kind + ", " + c2.number + ", " + c2.width + ", " + c2.height);

	}

}
