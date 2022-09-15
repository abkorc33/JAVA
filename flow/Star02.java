package flow;

public class Star02 {

	public static void main(String[] args) {
		// 별그리기 왼쪽 공백
		int i =0;
		int j =0;

		for(i = 1; i < 5; i++) {
			for(j = 4; j > 0; j--) {
				if(j > i) {
					System.out.print(" ");
				} else {
				System.out.print('★'); 
				}
			}
			System.out.println();
		}

	}

}
