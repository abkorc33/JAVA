package object;

class Data01{
	int money;
	
	Data01() {
		System.out.println("기본 생성자입니다.");
		money = 100;
	}
}

class Data02 {
	int money;
	Data02(int x) {	// 매개변수 있는 생성자
		money = x;
	}
	Data02() {	// 매개변수 없는 생성자(기본 생성자)
		money = 10;
	}
}

public class ConstructorExam {

	public static void main(String[] args) {
		Data01 d1 = new Data01();
		System.out.println("나의 돈은 " + d1.money + "만원입니다.");
		
		Data02 d21 = new Data02(200);
		System.out.println("나의 돈은 " + d21.money + "만원입니다.");
		Data02 d22 = new Data02();
		System.out.println("나의 돈은 " + d22.money + "만원입니다.");
	}

}