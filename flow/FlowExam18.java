package flow;

public class FlowExam18 {

	public static void main(String[] args) {
		
		int score = 45;
		
		do {
			System.out.println("안녕하세요");
			if(score < 60) {
				System.out.println("이용하실 수 있는 점수가 아닙니다.");
			}else {
				System.out.println("메뉴를 보시고 선택해주세요.");
				System.out.println("메뉴");
			}
			
		} while(score > 60);

	}

}
