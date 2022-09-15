package array;

public class ArrayExam04 {

	public static void main(String[] args) {
		// 45개의 정수값을 저장하기 위한 배열을 생성한다.
		int[] ball = new int[45];
		
		int imsi = 0;	// 두 방의 값을 바꾸는데 사용할 임시변수
		int r = 0;	//임의의 정수를 추출하여 저장할 변수
		
		// 배열의 각 요소(방)에 1 ~ 45까지의 값을 순서대로 저장한다.
		// 여기서 숫자를 지정해줬기 때문에 중복이 없음
		for(int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
			System.out.print(ball[i] + ", ");
		}
		System.out.println();
		
		// 배열에 저장된 값들이 잘 섞이도록 100번 반복작업을 한다.
		// 첫번째 방의 값과 임의의 추출한 값에 해당하는 방의 값을 교환한다.
		// 배열 index를 가지고 자리를 바꾸므로 중복 숫자 없음
		for(int i = 0; i < 100; i++) {
			r = (int)(Math.random() * 45);	// 임의의 방 번호를 추출한다.
			
			imsi = ball[0];
			ball[0] = ball[r];
			ball[r] = imsi;
		}
		
		// 배열 ball의 앞에서부터 6개 방의 값을 출력한다.
		for(int i = 0; i < 6; i++) {
			System.out.print(ball[i] + "\t");
		}
		
	}

}
