package exception;	// catch문은 여러 개 만들 수 있다.

public class ExceptionExam06 {

	public static void main(String[] args) {
		
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0);	// 예외발생
			System.out.println(4);	// 이 구문은 실행되지 않는다.
		} catch(ArithmeticException ae) {	// 여러개의 Exception은 아래로 갈수록 범위가 넓어져야한다.
			if(ae instanceof ArithmeticException)
				System.out.println("true");
			System.out.println("ArithmeticException");
		} catch(Exception e) {	// ArithmeticException을 제외한 모든 예외가 처리된다.
			System.out.println("Exception");
		}
		
		System.out.println(6);

	}

}
