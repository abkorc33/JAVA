package exception;

public class ExceptionExam07 {

	public static void main(String[] args) {
		
		// printStackTrace() - 예외발생 당시의 호출스택(call stack)에 있었던 메서드의 정보와
		// 					   예외 메시지를 화면에 출력한다.
		// getMessage() - 발생한 예외 클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0);	// 예외발생
			System.out.println(4);	// 실행 안됨
		} catch(ArithmeticException ae) {
			// 참조변수 ae를 통해서 생성된 ArithmeticException인스턴스에 접근할 수 있다.
			ae.printStackTrace();
			System.out.println("예외 메세지 : " + ae.getMessage());
		} finally {
			System.out.println("finally를 수행해야 집에 갈 수 있습니다.");
		}
		System.out.println(6);
		
	}

}
