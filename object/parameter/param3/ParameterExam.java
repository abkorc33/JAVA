package object.parameter.param3;

public class ParameterExam {

	public static void main(String[] args) {
		
		int[] x = {10};	// 크기가 하나인 배열에 10이 들어있음. 방10개 아님
		System.out.println("main() : x => " + x[0]);	//10
		
		change(x);
		System.out.println("After change().....");
		System.out.println("main() : x => " + x[0]);	//2000

	}
	
	static void change(int[] x) {	//참조변수
		x[0] = 2000;
		System.out.println("change() : x => " + x[0]);	//2000
	}

}