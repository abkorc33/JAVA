package array;

public class ArrayExam08 {

	public static void main(String[] args) {
		
		int[] number = new int[10];
		int count = 0;
		
		for(int i = 0; i < number.length; i++) {
			System.out.print(number[i] = (int)(Math.random() * 10));
		}
		System.out.println();
		
		for(int i = 0; i < number.length-1; i++) {			//06번과 거울보듯이 반대
			for(int j = number.length-1; j >= 1+i; j--) {	// 오른쪽에서 왼쪽으로 비교
				if(number[j-1] > number[j]) {		// 앞의 값이 뒤에값보다 크면 바꿔줌, 오름차순 정렬
					int imsi = number[j-1];
					number[j-1] = number[j];
					number[j] = imsi;
					count++;
				}
			}
			if(count == 0) {
				break;
			}else {
				count = 0;
			}
			for(int j = 0; j < number.length; j++) {
				System.out.print(number[j]);
			}
			System.out.println();
		}
	}

}
