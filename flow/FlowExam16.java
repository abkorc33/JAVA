package flow; //FlowExam12와 연결됨

public class FlowExam16 {

	public static void main(String[] args) {
		// while문을 사용하여 구구단을 만들어보세요.
		
		int x = 2;
		while(x <= 9) { //for(int x = 2; x <= 9; x++)
			int y = 1;
			while(y <= 9) { //for(int y = 1; y <= 9; y++)
				System.out.print(x + "x" + y + "=" + x*y + "\t");
				y++;
			}
			x++;
			System.out.println();
		}
		
	}
}
