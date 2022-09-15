package operator;

public class Exercise02 {

	public static void main(String[] args) {
		int num = 10;
		// num의 값이 양수인가요? 음수인가요?
		// 단, 삼항 연산자 사용
		System.out.println(num > 0 ? "양수" : "음수");
		
		num = 0;
		// num의 값이 양수인가요? 음수인가요? 0인가요?
		// 삼항연산자 사용
		System.out.println(num > 0 ? "양수" : num == 0 ? "0" : "음수");
	}
}