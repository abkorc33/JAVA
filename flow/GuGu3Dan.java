package flow;

public class GuGu3Dan {

	public static void main(String[] args) {
		// 구구단
		// 3씩 어케 증가시킴? for문 맨 끝 조건에 i++이 아니라 i+=3
		// i라는 변수에 3씩 증가시키는 값 저장, i값을 기준으로 x값의 범위 조절
		// 구구단을 출력하는데 1,2,3단 출력, 4,5,6단 출력, 7,8,9단 출력순으로 실행시켜보자.
		
		int x = 0;
		int y = 0;
		int i = 0;
		
		for(i = 1; i < 10; i+=3) {
			for(y = 1; y < 10; y++) {
				for(x = i; x < i + 3; x++) {
					System.out.print(x + "x" + y + "=" +(x*y)+ "\t");
				}
				System.out.println();	
			}
			System.out.println("--------------------------");
		}
		
		/*for(i = 1; i < 4; i++) {
			for(y = 1; y < 10; y++) {
				for(x = 3 * i - 2; x < i * 3 + 1; x++) {
					System.out.print(x + "x" + y + "=" +(x*y)+ "\t");
				}
				System.out.println();	
			}
			System.out.println("--------------------------");
		}	// i의 값을 강제했을 때*/
		
	}

}
