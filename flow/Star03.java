package flow;

public class Star03 {

	public static void main(String[] args) {
		
		// 별그리기
		// 내코드
		int i = 0;
		int j = 0;
		for(i =5; i > 0; i--) {
			for(j =0; j < i; j++) {
				System.out.print('★');
			}
			System.out.println();
		}
		// 선생님 코드
		for(i = 0; i < 5; i++) {
			for(j = 0; j < 5-i; j++) {
				System.out.print('★');
			}
			System.out.println();
		}
		for(i = 0; i < 5; i++) {
			for(j = 5; j > i; j--) {
				System.out.print('★');
			}
			System.out.println();
		}

	}

}
