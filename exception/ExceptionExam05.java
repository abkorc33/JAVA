package exception;

public class ExceptionExam05 {

	public static void main(String[] args) {
		
		try {
			Exception e = new Exception("고의로 Exception을 발생시켰습니다.");
			throw e;	// 예외를 발생시킨다.
			// 위의 두 줄을 한 줄로 줄여쓸 수 있다.
			// throw new Exception("고의로 Exception을 발생시켰습니다.");
		} catch (Exception e) {
			System.out.println("에러 메세지 : " + e.getMessage());
			// e.printStackTrace();
		}
		System.out.println("프로그램이 정상 종료되었습니다.");

	}

}
