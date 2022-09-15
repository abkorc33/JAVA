package flow;

public class Exercise01 {

	public static void main(String[] args) {
		// 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수들의 총합을 알아내주세요.
		// 1,5,7,11,13,17,19 를 다 더한 값(73) 이 나와야함.
		// and(&&), or(||), 같다(==), 같지 않다(!=)
		/* int i = 1;
		int sum = 0;
		
		for(i = 1; i <= 20 ; i++) {
			if((i % 2 == 0) || (i % 3 == 0)) continue;
			sum = i++;
			System.out.println(sum); 내코드, 2배수,3배수 거르는건ok, 합계에서 막힘
		} */
		
		int sum = 0;
		for(int i = 1; i <= 20; i++) {
			if(i % 2 == 0 || i % 3 == 0) continue;	//2, 3의 배수를 만나면 처음으로 돌려보내기(제외한단소리)
				sum += i;
		}
		System.out.println(("합계: " + sum));
		
		sum = 0;
		for(int i = 1; i <= 20; i++) {
			if(i % 2 != 0 && i % 3 != 0)	//if(2, 3의 배수가 아니면 이라는 뜻)
				sum += i;
		}
		System.out.println(("합계: " + sum));
	}

}
