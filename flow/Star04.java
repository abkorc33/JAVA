package flow;

public class Star04 {

	public static void main(String[] args) {
		// 별 공백
		int num = 7;
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < num - i; j++) {
				System.out.print('★');
			}
			System.out.println();
		}

	}

}
