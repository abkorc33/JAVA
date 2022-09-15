package flow;

public class FlowExam20 {

	public static void main(String[] args) {
		// 1부터 20까지 1씩 증가시키는 값을 보여주세요.
		// 조건, 짝수만 보여주고, while문을 사용
		
		/*int i = 0;
		while(i % 2 > 0) {
			if(i > 20)
				break;
			i++;
		}System.out.println(i); 내 코드*/
		
		/*int num = 1;
		while(true) {
			if(num > 20)	break;
			if(num % 2 ==0)	System.out.println(num++); //잘못된 코드, 증가가 안돼서 무한반복 
		}*/
		
		int num = 1;
		while(true) {
			if(num > 20)	break;
			if(num % 2 ==0)	System.out.println(num); // 바로 밑 코드랑 같은 값
			num++;
		}
		
		num = 1;
		while(num <= 20) {
			//if(num > 20)	break;
			if(num % 2 ==0)	System.out.println(num);
			num++;
		}
		// 1부터 20까지 1씩 증가시키는 값을 보여주세요.
		// 조건, 짝수만 빼고 보여주고, while문을 사용
		num = 0;
		while(true) {
			num++;
			if(num % 2 == 0) continue;
			if(num > 20)	break;
			System.out.println(num);
		}
		
	}
}
