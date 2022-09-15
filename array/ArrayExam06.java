package array;

public class ArrayExam06 {

	public static void main(String[] args) {
		
		int[] number = new int[10];
		int[] counter = new int[10];
		
		// 0 ~ 9 까지 임의의 정수를 추출하여 number방에 저장한다.
		
		for(int i = 0; i < number.length; i++) {
			System.out.print(number[i] = (int)(Math.random() *10));
		}
		System.out.println();
		
		// 0 ~ 9 까지의 정수가 각각 몇 개인지 알려주세요.
		for(int i = 0; i < number.length; i++) {
			counter[number[i]]++;		// counter안에number[i]의 값인 숫자가 들어가는게 아니라
									//해당 숫자가 counter array의 방 번호이고, 방 안에 +1씩 해주는 것.
		}
		for(int i  = 0; i < number.length; i++) {
			System.out.println(i + "의 개수 : " + counter[i]);
		}
	}

}
