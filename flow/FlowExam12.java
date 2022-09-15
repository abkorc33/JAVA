package flow;

public class FlowExam12 {

	public static void main(String[] args) {
		// for문을 사용해서 구구단 만들기.
		
		/*int number = (int)(Math.random() * 10);
		int i = 1;
		for(i = 1; i < 11 ; i++) {
			System.out.println(i*number);
		} 내가 쓴 코드*/
		
		//System.out.println(); //출력 후 줄바꿈
		//System.out.print("a"); //출력 후 줄바꿈 없음
		//System.out.print("\t"); //Tab
		
		//선생님코드
		
		for(int x = 2; x <= 9; x++) {
			for(int y = 1; y <= 9; y++) {
				System.out.print(x + "x" + y + "=" + x*y + "\t");
			}
			System.out.println(); //구구단 한 단위가 끝나면 줄바꿈이 되도록 함
		}
	}

}
