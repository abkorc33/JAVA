package object.car.car02;

import object.car.car02.Car;

class Car {
	String color;		// 색상
	String gearType;	// 변속기 종류 :  auto(자동), manual(수동)
	int door;			// 문의 개수
	
	Car() {
		this("검정", "수동", 4);	// this는 같은 생성자를 의미한다.
	}
	Car(String color) {
		this(color, "수동", 4);
	}
	
	Car(String color, String gearType, int door) {	//같은 클래스이름에 매개변수 갯수 다름
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

public class CarExam {

	public static void main(String[] args) {
		
		Car c1 = new Car();
		System.out.println("c1 => " + c1.color + ":" + c1.gearType + ":" +c1.door);
		
		Car c2 = new Car("노랑", "자동", 3);
		System.out.println("c2 => " + c2.color + ":" + c2.gearType + ":" +c2.door);
		
		Car c3 = new Car("빨강");
		System.out.println("c3 => " + c3.color + ":" + c3.gearType + ":" +c3.door);

	}

}