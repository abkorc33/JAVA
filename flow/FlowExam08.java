package flow;

public class FlowExam08 {

	public static void main(String[] args) {
		int score = (int)(Math.random() * 10) + 1; // 1 ~ 10사이의 임의의 정수를 추출한다.
		score *= 100; // score = score * 100;
		String msg = "당신의 점수는 " + score + "점이고, 상품은 ";
		
		switch(score) {
		case 100:
			msg += "자전거"; break;
		case 200:
			msg += "TV"; break;
		case 300:
			msg += "노트북"; break;
		case 400:
			msg += "자동차"; break;
		default:
			msg += "볼펜"; break;
		}
		System.out.println(msg + "입니다.");

	}

}
