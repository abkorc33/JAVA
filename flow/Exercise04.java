package flow;

public class Exercise04 {

	public static void main(String[] args) {
		// 두 개의 주사위를 던졌습니다.
		// 눈의 합이 6이 되는 모든 경우의 수를 출력하세요.
		// 1+6, 2+4, 3+3, 4+2, 5+1
		
		/*int i = 0;
		int j = 0;
		int sum = 0;
		
		for(i = 1 ; i <= 6 ; i++) {
			for(j = 6 ; j >= 1 ; j--) {
				sum = i + j;
				if(sum != 6) continue;
			}System.out.println(i + j);
		}*/
		
		for(int i = 1; i <= 6; i++)
			for(int j = 1; j <= 6; j++)
				if(i + j == 6)
					System.out.println(i + "+" + j + "=" + (i+j));

	}

}
