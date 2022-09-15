package flow;
import java.util.ArrayList; //array 쓰려고 import함, 내 코드..복잡함

public class FlowExam07 {

	public static void main(String[] args) {
		int score = (int)(Math.random() * 10) + 1; // 1 ~ 10사이의 임의의 정수를 추출한다.
		String a = "당신의 점수는 ";
		String b = " 이고, 상품은 ";
		ArrayList goods = new ArrayList();
		goods.add("자전거");
		goods.add("노트북");
		goods.add("TV");
		goods.add("자동차");
		goods.add("볼펜");
		
		switch(score * 100) {
		case 100:
			System.out.println(a + score + b + goods.get(0)); break;
		case 200:
			System.out.println(a + score + b + goods.get(1)); break;
		case 300:
			System.out.println(a + score + b + goods.get(2)); break;
		case 400:
			System.out.println(a + score + b + goods.get(3)); break;
		default:
			System.out.println(a + score + b + goods.get(4)); break;
		}

	}

}
