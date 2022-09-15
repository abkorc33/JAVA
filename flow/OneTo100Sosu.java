package flow;

public class OneTo100Sosu {

	public static void main(String[] args) {
		// 1부터 100까지의 정수에서 모든 소수를 구하십시오.
		// 소수는 1과 자기 자신으로만 나누어 지는 수를 말한다.
		// 나누는 횟수를 2번 이하로 제한, 이걸 어케함? 선생님코드에 count++활용
		// 작업대상이 되는 수가 1을 제외한 나머지 수로 나누어지는 횟수찾기
		int count = 0;
		
		/*for(int number = 1; number <=100; number++) {
				System.out.print(number + "의 소수 : ");
			for(int i = 1; i <= 100; i++) {
				if(number % i == 0) { 
					if(number / i < 3)
				System.out.print(i+",");
				}
			}
			System.out.println();
		} */
		
		// 1은 소수가 아니므로 2부터 작업을 시작한다. 선생님코드
		for(int number = 2; number <=100; number++) {
			for(int j = 2; j <= number; j++) {
				if(number % j == 0) {
					count++;
				}
			}
			// 하나의 숫자에 대해서 나누기가 모두 끝났으면
			if(count == 1) {
				System.out.print(number + " ");
			}
			// 하나의 숫자에 대해서 작업이 모두 끝나면 count를 초기화한다.
			count = 0;
		}

	}

}
