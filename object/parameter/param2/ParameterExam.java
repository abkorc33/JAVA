package object.parameter.param2;

class Data {
	int x;
}

public class ParameterExam {

	public static void main(String[] args) {
		
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x => " + d.x);	//10
		
		change(d);
		System.out.println("After change()......");
		System.out.println("main() : x => " + d.x);	//1000

	}
	
	static void change(Data d) {	//참조형 매개변수 //d의 주소값을 받았기 때문에 값 변경 가능
		d.x = 1000;
		System.out.println("change() : x " + d.x);	//1000
	}

}