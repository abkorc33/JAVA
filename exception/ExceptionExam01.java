package exception;

public class ExceptionExam01 {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		// 프로그램 상으로는 문제가 없으나 수학적으로 0으로 나누기가 안돼서 오류발생
		// 예외처리
		for(int i = 0; i < 10; i++) {
			// number를 임의의 정수(0 ~ 9)를 추출하여 나눈 결과를 보여준다.
			result = number /  (int)(Math.random() * 10); // 문제발생 구간
			System.out.println(result);
		}

	}

}
