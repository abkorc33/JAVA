package flow;

public class Exercise03 {

	public static void main(String[] args) {
		// 1 + (-2) + 3 + (-4) + ..... 짝수를 음수로 더해나갔을 때,
		// 몇 까지 더해야 100 이상이 되는가? 답 199도출하기
		
		/*int i = 0;
		int j = 0;
		int sum = 0;
		
		for(i = 1, j = -2 ; sum >= 100; i++, j--) {
			if(j % 2 != 0) continue;
			if(i % 2 == 0) continue;
			sum += i+j;
		}
		System.out.println(sum);  */
		
		int sign = 1;	//값의 부호를 바꾸어 저장하는 변수
		int sum = 0;	//총합을 저장할 변수
		int i = 0;
		
		for(i = 1; true ; i++, sign = -sign) {	//sign의 초기값 1에서부터 해당 줄의 코드를 만나 -1됨
			sum += i * sign;	//1을 시작으로 1, -1, 1, -1...반복이기 때문에 
			System.out.println(i);	//i와 곱해져서 짝수만 음수일 수 있는 것
			if(sum >= 100) break;	//합계가 100이 되어서 반복문을 빠져나올 시점의 i의 갯수는 199
		}
		System.out.println(i + "까지 더하면 100이상이 됩니다. 합계: " + sum);
	}

}
