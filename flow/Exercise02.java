package flow;

public class Exercise02 {

	public static void main(String[] args) {
		// 1 + (1+2) + (1+2+3) + ..... (1+2+3+4...+10) 은 얼마인가요? 220이 답
		/* i++;
		 * sum += i
		 * total += sum */
		
		int i = 0;
		int sum = 0;
		int total = 0;
		
		for(i = 1; i <= 10; i++) {
			sum += i;
			total += sum;
		}
		System.out.println(total); // 중첩된 총합은 조건문 밖에서 print해야됨

	}

}
