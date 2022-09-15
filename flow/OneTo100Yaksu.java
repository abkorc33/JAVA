package flow;

public class OneTo100Yaksu {

	public static void main(String[] args) {
		// 1부터 100까지 각 정수들의 약수들을 모두 구하자.
		// A라는 수를 B로 나누어 나머지가 0이면 B는 A의 약수이다.
		
		for(int num = 1; num <= 100; num++) {
			System.out.print(num + "의 약수 : ");
			//1부터 num번째까지 순차적으로 반복
			for(int j = 1; j <= 100; j++) {
				if(num % j == 0) {
					// num이라는 숫자를 j로 나누어 나머지가 0이면 j는 num의 약수이다.
					if(num == j)
						System.out.print(j);
					else
						System.out.print(j + ", ");
				}
			}
			System.out.println();
		}
				
	}

}
