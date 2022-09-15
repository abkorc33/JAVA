package flow;

public class FlowExam09 {

	public static void main(String[] args) {
		// 0 ~ 100 사이의 정수 값이 나오도록 하자.
		int score = (int)(Math.random() * 101); 
		char grade = ' ';
		
		switch(score/10) { //score를 10으로 나누면 나온 몫으로 구분해 코드의 반복을 줄일수있음
		case 10: 
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';
		}
		System.out.println("당신의 점수는 " + score + "점이고, 학점은 " + grade + "학점입니다.");
	}
}


