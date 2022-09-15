package flow;

public class FlowExam21 {

	public static void main(String[] args) {
		
		//3의 배수만 빼고 보여주세요.
		for(int i = 0; i <= 20; i++) {
			// if(i % 3 != 0) System.out.println(i); 3으로 나눴을 때 0이(3의 배수) 되지 않는 숫자만 표시
			if(i % 3 == 0) continue; //continue 사용해도됨
			System.out.println(i);
		}

	}

}
