package flow;

public class Star06 {

	public static void main(String[] args) {
		// 별 그리기
		// 까만별 x자, 5 x 5 배열로, 나머지는 공백
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(i + j == 4 || i == j) {					
				System.out.print("★");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}

}
