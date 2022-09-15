package operator;

public class OperatorExam05 {

	public static void main(String[] args) {
		// 몫(/), 나머지(%)
		// 10을 8로 나누면 몫은 얼마고, 나머지는 얼마인가요?
		// 내 풀이
		int i = 10, a = 8;
		int b = i / a;
		int c = i % a;
		System.out.println("몫은" + b + ", 나머지는" + c);
		
		//선생님 풀이
		int share = 10 / 8; //몫
		int remain = 10 % 8; //나머지
		System.out.println("10을 8로 나누면 ");
		System.out.println("몫은 " + share + "이고, 나머지는 " + remain + "입니다.");
		
		System.out.println("10을 8로 나누면 ");
		System.out.println("몫은 " + (10 / 8) + "이고, 나머지는 " + (10 % 8) + "입니다.");
	}

}
