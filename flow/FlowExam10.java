package flow;

public class FlowExam10 {

	public static void main(String[] args) {
		// 1부터 10까지 정수를 누적하면 얼마인가요? for문을 사용해서 만들어주세요.
		
		int sum = 0;  //합계를 저장하기 위한 변수
		int i;
		/*
		int i = 0;
		for( i = 0 ; i < 10 ; i++); {
			System.out.println(i);
		} 내가 쓴 코드 */ 
		
		for(i = 1; i < 11; i++) {
			sum += i; //sum = sum + i;
		}
		System.out.println(sum);
		//System.out.println(i-1 + "까지의 합은 " + sum + "입니다."); 
		//i가 for문 안에서 선언됐기 때문에 밖에서 사용할 수 없음. 
		//밖에서 i선언해주고 for문에서 초기화 하면 사용 가능
		System.out.println(i-1 + "까지의 합은 " + sum + "입니다.");
	}

}
