package flow;

public class FlowExam01 {

	public static void main(String[] args) {
		int visitCount = 10;
		if(visitCount < 1) {
			System.out.println("처음 오셨군요. 방문해주셔서 감사합니다.");
		} else {
			System.out.println("다시 방문해주셔서 감사합니다.");
		}
			System.out.println("즐거운 시간 되십시오.");
			System.out.println("방문횟수는 " + visitCount + "번입니다."); //10번
			System.out.println("방문횟수는 " + ++visitCount + "번입니다."); //11번
			
	}

}
