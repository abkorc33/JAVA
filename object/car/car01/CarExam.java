package object.car.car01;

class Car {
	String color;		// 색상
	String gearType;	// 변속기 종류 :  auto(자동), manual(수동)
	int door;			// 문의 개수
	
	Car() {	//생성자 오버로딩
		color = "검정";
		gearType = "수동";
		door = 4;
	}
	
	Car(String c, String g, int d) {	//같은 클래스이름에 매개변수 갯수 다름
		color = c;
		gearType = g;
		door = d;
	}
}

public class CarExam {

	public static void main(String[] args) {
		
		Car c1 = new Car();
		System.out.println("c1 => " + c1.color + ":" + c1.gearType + ":" +c1.door);
		
		Car c2 = new Car("노랑", "자동", 3);
		System.out.println("c2 => " + c2.color + ":" + c2.gearType + ":" +c2.door);

	}

}