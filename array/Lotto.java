package array;

public class Lotto {

	public static void main(String[] args) {
		
		int num = 6;	// ball의 개수
		int[] ball = new int[num];	// 랜덤하게 추출한 정수를 저장할 변수
		int imsi;
		int i = 0;
		int j = 0;
		
		for(i = 0; i < num; i++) 
			System.out.print(ball[i] + "\t");
		System.out.println();
		
		// 1. 중복되지 않은 6개의 정수를 추출하여 배열에 저장한다. 
		// 중복어케없앰
		// 2. 오름차순으로 정렬하여 보여준다.
		// 3. 1부터 45번사이의 정수
		
		for(i = 0; i < num; i++) {
			ball[i] = (int)(Math.random() * 45 + 1);
			if(i > 0) {
			for(j = 0; j < i; j++) {
				if(ball[j] == ball[i]) {
					i--;
					break;
					}
				}
			}
		}
		for(i = 0; i < num; i++) {
			System.out.print(ball[i] + "\t");
		}
		System.out.println();
		System.out.println("==============================================");

		for(i = 0; i < num; i++) {				// 이부분
			for( j = 0; j < ball.length-1; j++) {	// 선생님 코드랑 다른데 돌아감
				if(ball[j] > ball[j+1]) {
					imsi = ball[j];
					ball[j] = ball[j+1];
					ball[j+1] = imsi;
				}
			}
		}
		for(i = 0; i < num; i++) {
			System.out.print(ball[i] + "\t");
		}
		
		/* 선생님 코드
		 * for(i = 0; i <num; i++) {
			// 랜덤한 정수를 추출한다.
			ball[i] = (int)(Math.random() * 45 + 1);
			if(i > 0) {	// 첫번째 방은 작업에서 제외시킨다.
				for(j = 0; j < i; j++) {
					// 중복된 숫자가 나오면 다시 뽑는다 => i값을 줄인다.
					if(ball[j] == ball[i]) {
						i--;
						break;
					}
				}
			}
		}
		for(i = 0; i < num; i++) 
			System.out.print(ball[i] + "\t");
		System.out.println();
		// 오름차순 정렬
		for(i = 0; i < ball.length-1; i++) {
			for(j = 0; j < ball.length-1-i; j++) {
				if(ball[j] > ball[j+1]) {
					imsi = ball[j];
					ball[j] = ball[j+1];
					ball[j+1] = imsi;
				}
			}
		}
		for(i = 0; i < num; i++) 
			System.out.print(ball[i] + "\t");*/
	}

}
