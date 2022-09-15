package object;

public class OverloadingExam {

	public static void main(String[] args) {
		Calc cc = new Calc();
		
		System.out.println("cc.plus(3, 3) => " + cc.plus(3, 3));
		System.out.println("cc.plus(3, 3, 3) => " + cc.plus(3, 3, 3));
		System.out.println("cc.plus(3L, 3L) => " + cc.plus(3L, 3L));
		System.out.println("cc.plus(3, 3L) => " + cc.plus(3, 3L));
		System.out.println("cc.plus(3L, 3) => " + cc.plus(3L, 3));
		
		int[] num1 = {70, 80, 90};
		System.out.println("cc.plus(int[] num1) => " + cc.plus(num1));

	}

}

class Calc {
	int plus(int num1, int num2) {
		System.out.println("int plus(int num1, int num2) ==>");
		return num1 + num2;
	}
	int plus(int num1, int num2, int num3) {	//타입은 같으나 변수 갯수가 3개
		System.out.println("int plus(int num1, int num2, int num3) ==>");
		return num1 + num2 + num3;
	}
	long plus(long num1, long num2) {	//타입이 다름
		System.out.println("long plus(long num1, long num2) ==>");
		return num1 + num2;	
	}
	long plus(int num1, long num2)  {	//변수 안의 타입이 각각 다름
		System.out.println("long plus(int num1, long num2");
		return num1 + num2;
	}
	long plus(long num1, int num2) {	//순서가 달라도 오버로딩 성립
		System.out.println("long plus(long num1, int num2)");
		return num1 + num2;
	}
	int plus(int[] num1) {
		System.out.println("int plus(int[] num1) ==>");
		int result = 0;
		for(int i = 0; i < num1.length; i++) {
			result += num1[i];
		}
		return result;
	}
	
}
