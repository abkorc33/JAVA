package flow;

public class FlowExam06 {

	public static void main(String[] args) {
		// 'A', 'B', 'C', 'D' 중에 하나의 문자를 랜덤하게 추출하자!
		// Math.random() => 0 ~ 0.9999999
		// Math.random() * 4 ==> 0 ~ 3.9999999
		// Math.random() * 4 + 'A'
		// (char)(Math.random() * 4 + 'A')
		char ch = (char)(Math.random() * 4 + 'A');
		int score = 0;
		System.out.println(ch);
		
		switch(ch) 
		{
		case 'A': score = 90; break;
		case 'B': score = 80; break;
		case 'C': score = 70; break;
		case 'D': score = 60; break;
		}
		System.out.println("당신의 점수는 " + score + "점 이상입니다.");

	}

}
