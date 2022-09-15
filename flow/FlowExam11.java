package flow;

public class FlowExam11 {

	public static void main(String[] args) {
		// 1부터 10까지 정수를 누적하면 얼마인가요? for문을 사용해서 만들어주세요.
		// 단, 짝수만 더한 값을 알아내주세요.
		
		int sum = 0;
		/*for(int i = 1; i < 11 && (i % 2) == 0; i++) {
			sum += i;
		}
		System.out.println(sum); 내가 쓴 코드, 틀린 답*/
		
		for(int i = 0; i <= 10; i += 2 ) { //선생님코드
			sum += i;
			System.out.println(i + " : " + sum);
		}

	}

}
