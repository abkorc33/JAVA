package array;

public class ArrayExam03 {

	public static void main(String[] args) {
		// 0 ~ 9까지 100번 랜덤하게 섞기
		
		int[] number = new int[10];
		
		for(int i = 0; i < number.length; i++) {
			number[i] = i;	// 배열을 0 ~ 9 까지의 정수로 초기화한다.
			System.out.print(number[i] + "\t");
		}
		System.out.println();
		
		// 첫번째 방의 값과 랜덤하게 추출한 방의 값을 100번 교환한다.
		for(int i = 0; i < 100; i++) {
			int r = (int)(Math.random() * 10);	// 0~9 사이의 임의의 정수를 추출.
			
			int imsi = number[0];
			number[0] = number[r];
			number[r] = imsi;
		}
		for(int i = 0; i < number.length; i++) {
			System.out.print(number[i] + "\t");
		}
	}

}
