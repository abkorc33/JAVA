package flow;

public class FlowExam04 {

	public static void main(String[] args) {
		String grade = "A";
		grade = grade + "+";
		int score = 93;
		//score가 90 이상이면 A => grade = 'A'
			//98점 이상이면 A+
			//98점 이하 94점 이상 A
			//94점 미만이면 A-
		//score가 80 이상 90미만이면 B => grade = 'B'
		//나머지는 C학점 => grade = 'C'
		//내 풀이
		if(score >= 98) {
			grade = "A+";
		} else if(score >= 94 && score < 98) {
			grade = "A";
		} else if(score >= 90 && score < 94) {
			grade = "A-";
		} else if(score >= 80 && score < 90) {
			grade = "B";
		} else {
			grade = "c";
		}
		System.out.println("당신의 학점은 " + grade + "입니다.");
		
		// 선생님 풀이, 중첩 조건문
		grade = "";
		score = 93;
		
		if(score >= 90) {
			grade = "A";
			if(score >= 98) {// grade = grade + "+"
				grade += "+";
			}else if(score < 94) {
				grade += "-";
			}
		} else if(score >= 80) {
			grade = "B";
			if(score >= 88) {
				grade += "+";
			}else if(score < 84) {
				grade += "-";
			}
		} else {
			grade = "C";
		}
		System.out.println("당신의 학점은 " + grade + "입니다.");
		
	}

}
