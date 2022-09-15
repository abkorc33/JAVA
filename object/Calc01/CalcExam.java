package object.Calc01;

public class CalcExam {

	public static void main(String[] args) {
		
		int num1 = 10, num2 = 3;
		// 클래스를 사용하려면 생성을 해야한다.
		Calc cc = new Calc();
		
		System.out.println("더하기 : " + cc.plus(num1, num2));
		System.out.println("빼기 : " + cc.minus(num1, num2));
		System.out.println("곱하기 : " + cc.multiply(num1, num2));
		System.out.println("나누기 : " + cc.divide(num1, num2));

	}

}
//사칙연산 클래스
class Calc {
	int plus(int num1, int num2) {	//더하기 메서드
		int result = num1 + num2;
		return result;
	}
	int minus(int num1, int num2) {	//빼기 메서드
		return num1 - num2;
	}
	int multiply(int num1, int num2) {	//곱하기 메서드
		return num1 * num2;
	}
	int divide(int num1, int num2) {	//나누기 메서드
		return num1 / num2;
	}
	
}