package flow;

public class Star01 {

	public static void main(String[] args) {
		// 별 만들기
		// ★
		int i =0;
		int j =0;
			//for문 별찍기
		for(i = 1; i < 5; i++) {
			for(j = 0; j < i; j++) {
			System.out.print('★');
			}
			System.out.println();
		}
		for(i = 4; i > 0; i--) {
			for(j = 0; j < i; j++) {
			System.out.print('★');
			}
			System.out.println();
		}
		//	while문 별찍기
		i = 1;
		j = 0;
		while(i < 5) {
			j = 0;
			while(i != j) {
				System.out.print('★');
				j++;
			}
			System.out.println();
			i++;
		}
		
	}

}
