package object.car.car03;

public class CarExam {

	public static void main(String[] args) {
		
		int num1 = 0;	// 변수선언
		System.out.println(num1);
		
		Car c1 = new Car("빨강", "수동", 3);
		System.out.println("C1 => " + c1.color + ":" + c1.gearType + ":" + c1.door);	//빨강:수동:3
		
		Car c2 = new Car("빨강", "수동", 3);
		System.out.println("C2 => " + c2.color + ":" + c2.gearType + ":" + c2.door);	//빨강:수동:3
		
		Car c3 = new Car(c1);
		System.out.println("C2 => " + c3.color + ":" + c3.gearType + ":" + c3.door);	//빨강:수동:3
		
		c1.door = 10;
		System.out.println("C1 => " + c1.color + ":" + c1.gearType + ":" + c1.door);	//빨강:수동:10
		System.out.println("C2 => " + c2.color + ":" + c2.gearType + ":" + c2.door);	//빨강:수동:3
		System.out.println("C2 => " + c3.color + ":" + c3.gearType + ":" + c3.door);	//빨강:수동:3
		//별개의 생성자이기 때문에(new Car) c1을 바꿔봤자 c1을 참조한 c3는 안바뀜
		//객체는 생성되면 각자 별도의 공간에 있음.

	}

}

class Car {
	String color;
	String gearType;
	int door;
	
	Car() {
		this("검정", "수동", 4);
		System.out.println("기본생성자를 수행합니다.");
	}
	
	Car(Car c) {	// 인스턴스의 복사를 하기 위한 생성자
		color = c.color;
		gearType = c.gearType;
		door = c.door;
	}
	
	Car(String color, String g, int d) {
		this.color = color;	//같을 경우 구분을 위해 this. 붙임
		gearType = g;	//변수명이 다를 경우 그냥 써도 됨.
		door = d;
	}
	void drive() {
		System.out.println("자동차 움직인다.");
	}
}
