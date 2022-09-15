package object.parameter.param1;

class Data {
	int x;
}

public class ParameterExam {

	public static void main(String[] args) {
		
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x => " + d.x);	// 10
		
		change(d.x);
		System.out.println("After change().....");
		System.out.println("main() : x => " + d.x);	// 10

	}
	
	static void change(int x) {	// 기본형 매개변수
		x = 1000;
		System.out.println("change() : x => " + x);	// 1000
	}

}