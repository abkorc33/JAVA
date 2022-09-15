package flow;

public class Exercise06 {

	public static void main(String[] args) {
		
		// 정수의 각 자리수를 더하면 얼마인가요?
		int num = 13579;
		int sum = 0;
		/* System.out.println(num / 10000);
		System.out.println((num - num % 1000 -10000) / 1000);
		System.out.println((num - num % 100 -13000) / 100);
		System.out.println((num - num % 10 -13500) / 10);
		System.out.println((num - num % 1 -13570)); 
		
		System.out.println(Math.round(num / 10000));
		System.out.println(Math.round(num / 1000));
		System.out.println(Math.round(num / 100));
		System.out.println(Math.round(num / 10)); */
		
		while(num > 0) {
			sum += num % 10;	// 10으로 나눈 나머지 값을 합산한다.
			num /= 10;	//num을 10으로 나눈 값을 다시 num에 저장한다. 이 줄이 없으면 9무한반복.
		}				//num /= 10;을 했기 때문에 단위수가 줄어들면서 
						//num % 10;을 통해 9,7,5,3,1의 나머지값이 나올수 있는것.
		System.out.println("합계 : " + sum);
	}

}
