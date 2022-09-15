package flow;

public class FlowExam19 {

	public static void main(String[] args) {
		// 1부터 숫자를 누적해서 100이 넘으면 반복문을 탈출합시다
		int sum = 0;
		int i = 1;
		
		while(true) {
			if(sum > 100)
				break;
			sum += i;
			i++;
		}
		System.out.println("i = " + i); //i = 15
		System.out.println("sum = " + sum);  //sum = 105

	}

}
