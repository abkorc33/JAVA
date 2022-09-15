package array;

public class ArrayExam07 {

	public static void main(String[] args) {
		// 05번과 반대로 뒤로갈수록 작아지게, 랜덤숫자 내림차순 정렬하기
		int[] number = new int[10];
		int count = 0;
		
		for(int i = 0; i < number.length; i++) {
			System.out.print(number[i] = (int)(Math.random() * 10));	//중복될 수 있음
		}
		System.out.println();
		
		for(int i = 0; i < number.length; i++) {
			for(int j = 0; j < number.length-1-i; j++) {
				if(number[j] < number[j+1]) {	// 부등호만 바꿔줌
					int imsi = number[j];
					number[j] = number[j+1];
					number[j+1] = imsi;
					count++;
				}
			}
		if(count == 0) {
			break;
		}else {
			count = 0;
		}
		for(int k = 0; k < number.length; k++) {
			System.out.print(number[k]);
		}
		System.out.println();
		}
		
	}

}
