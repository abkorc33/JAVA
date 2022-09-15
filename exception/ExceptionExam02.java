package exception;

public class ExceptionExam02 {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		// 프로그램 상으로는 문제가 없으나 수학적으로 0으로 나누기가 안돼서 오류발생
		// 예외처리
		for(int i = 0; i < 10; i++) {
			try {
				result = number / (int)(Math.random() * 10);
				System.out.println(result);
			} catch (ArithmeticException e) {
				System.out.println("숫자를 0으로 나눌 수 없습니다.");
				// 프로그램이 멈추지 않고 진행된다.
			}
		}

	}

}
