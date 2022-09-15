package flow;

public class FlowExam02 {

	public static void main(String[] args) {
		int score = 85;   //점수
		char grade = ' '; //학점을 저장하기 위한 변수
		//score가 90 이상이면 A => grade = 'A'
		//score가 80 이상 90미만이면 B => grade = 'B'
		//score가 70 이상 90미만이면 C => grade = 'C'
		//나머지는 D학점 => grade = 'D'
		//&& => AND, || => OR
		
		if(score >= 90) {
			grade = 'A';
		} else if(score >= 80) {//조건(score >= 80 && score < 90)
			grade = 'B';
		} else if(score >= 70) {//조건(score >= 70 && score < 80)
			grade = 'C';
		} else {
			grade = 'D';
		}
		
		System.out.println("당신의 학점은 " + grade + "입니다.");

	}

}
