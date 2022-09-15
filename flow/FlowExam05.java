package flow;

public class FlowExam05 {

	public static void main(String[] args) {
		
		// Math클래스 random()메서드를 이용해서 1~10 사이의 임의의 정수를 구할 수 있다.
		//Math.random() => 0 포함 1 미만의 실수가 나온다. 0 ~ 0.9999999
		//Math.random() * 10 = 0 ~ 9.999999
		//(int)(Math.random() * 10) => 0 ~ 9
		//(int)(Math.random() * 10) + 1 => 1 ~ 10
		int score = (int)(Math.random() * 10) + 1;
		System.out.println(score);
		
		switch(score * 100) {
			case 100: System.out.println("당신의 점수는 100점이고 상품은 자전거입니다.");
					break;
			case 200: System.out.println("당신의 점수는 200점이고 상품은 TV입니다.");
					break;
			case 300: System.out.println("당신의 점수는 300점이고 상품은 노트북입니다.");
					break;
			case 400: System.out.println("당신의 점수는 400점이고 상품은 자동차입니다.");
					break;
			default: System.out.println("꽝!");
		}

	}

}
