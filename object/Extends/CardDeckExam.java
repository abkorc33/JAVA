package object.Extends;	// 상속받은 부모 클래스 수정 및 삭제 => 오버라이딩

// 카드 클래스
class Card {
	static final int KIND_MAX = 4;	// 카드의 무늬 수
	static final int NUM_MAX = 	13;	// 무늬 별 카드 수
	
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	
	int kind;	// 카드의 무늬
	int number;	// 카드의 숫자
	
	Card() {	// 기본 생성자
		this(SPADE, 1);
	}
	Card(int kind, int number) {	// 매개변수 생성자
		this.kind = kind;
		this.number = number;
	}
	public String toString() {	// toString을 안하면 객체의 주소값이 나와버림
		String kind = "";
		String number = "";
		
		switch(this.kind) {
		case 4:
			kind = "SPADE";
			break;
		case 3:
			kind = "DIAMOND";
			break;
		case 2:
			kind = "HEART";
			break;
		case 1:
			kind = "CLOVER";
			break;
		}
		switch(this.number) {
		case 13:
			number = "K";
			break;
		case 12:
			number = "Q";
			break;
		case 11:
			number = "J";
			break;
		default:
			number = this.number + "";
			break;
		}
		
		return "카드의 무늬 : " + kind + ", 카드의 숫자 : " + number;
	}
}

// Deck 클래스
class Deck {
	final int CARD_NUM = 52;	// 카드의 개수
	Card c[] = new Card[CARD_NUM];
	
	Deck() {	// Deck의 카드를 초기화 한다.
		int i = 0;
		
		for(int k = Card.KIND_MAX; k > 0; k--) {	// 카드의 무늬 개수(4개)
			for(int n = 1; n < Card.NUM_MAX + 1; n++) {	// 카드 무늬당 13번씩 작업
				c[i++] = new Card(k,n);
			}
			
		}
	}
	
	Card pick(int index) {	// 지정된 위치(index)에 있는 카드를 한장 선택한다.
		if(0 <= index && index < CARD_NUM)
			return c[index];
		else
			return pick();
	}
	
	Card pick() {	// Deck에서 임의의 카드를 한장 선택한다.
		int index = (int)(Math.random() * CARD_NUM);	// 0부터 51까지의 임의 숫자 추출
		return pick(index);
	}
	
	void shuffle() {	// 카드의 순서를 섞는다.
		for(int n = 0; n < 1000; n++) {
			int i = (int)(Math.random() * CARD_NUM);
			Card temp;
			temp = c[0];
			c[0] = c[i];
			c[i] = temp;
		}
	}
}

public class CardDeckExam {

	public static void main(String[] args) {
		
		Deck d = new Deck();	// 카드 한벌을 Deck에 만들어 놓는다.
		Card c = d.pick(0);	// 섞기 전에 제일 위의 카드를 뽑는다.
		System.out.println(c);
		
		d.shuffle();  // 카드를 섞는다.
		c = d.pick(0);	// 카드를 섞은 후 제일 위의 카드를 뽑는다.
		System.out.println(c);

	}

}