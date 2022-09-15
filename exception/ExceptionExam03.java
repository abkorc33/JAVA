package exception;

public class ExceptionExam03 {

	public static void main(String[] args) {
		
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(4);
		} catch (Exception e) {
			System.out.println(5);	// 안나옴, 예외가 발생하지 않아서
		}
		System.out.println(6);

	}

}
