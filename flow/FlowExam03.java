package flow;

public class FlowExam03 {

	public static void main(String[] args) {
		int score = 79;
		char grade = ' ';
		//score가 90 이상이면 A => grade = 'A'
		//score가 80 이상 90미만이면 B => grade = 'B'
		//나머지는 C학점 => grade = 'C'
		
		//삼항연산자를 사용
		//grade = (score >= 90) ? 'A' : score >= 80 && score < 90 ? 'B' : 'C'; 내가한거
		//grade = 조건 ? 참일 경우 : 거짓일 경우
		grade = (score >= 90) ? 'A' : ((score >= 80) ? 'B' : 'C');
		System.out.println("당신의 학점은 " + grade + "입니다.");

	}

}
