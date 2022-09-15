package operator;

public class OperatorExam06 {

	public static void main(String[] args) {
		// 삼항 연산자
		int x = 10;
		int y = -10;
		
		int absX = (x >= 0) ? x : -x;
		int absY = (y >= 0) ? y : -y; // -1 x (-10)
		
		System.out.println("x가 10일때 x의 절대값은 " + absX + "입니다.");
		System.out.println("y가 -10일때 y의 절대값은 " + absY + "입니다.");

	}

}
