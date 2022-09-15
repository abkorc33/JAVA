package exception;

public class ExceptionExam04 {

	public static void main(String[] args) {
		
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0);	// 예외발생
			System.out.println(4);	// 건너뜀
		} catch (ArithmeticException ae) {	// 실행됨
			System.out.println(5);
		}
		System.out.println(6);
	}	// 12356으로 나옴 4건너뛴다.

}
