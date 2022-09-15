package object.casting1;

class Car{
	String color;
	int door;
	
	void drive() {
		System.out.println("자동차가 움직입니다.");
	}
	void stop() {
		System.out.println("자동차가 멈췄습니다.");
	}
}
class Sobangcha extends Car {
	void water() {
		System.out.println("소방차가 물을 뿌립니다.");
	}
}

public class CastingExam {

	public static void main(String[] args) {
		
		Car car = null;
		Sobangcha sc1 = new Sobangcha();
		Sobangcha sc2 = null;
		
		sc1.water();
		car = sc1; // 자동차 타입이고, 소방차 타입으로 서로 타입이 다른데 성립한다.
		// up-casting : 형변환 생략 가능
		// car.water(); 기능을 지시할 버튼은 없음
		// 컴파일 에러 발생 => Car 타입의 참조변수로는 water()를 호출할 수 없다.
	
		System.out.println("sc1 => " + sc1);
		System.out.println("Car => " + car);// 주소값 같음
		
		// sc2 = car; down-casting은 형변환을 생략할 수 없다.
		sc2 = (Sobangcha)car;
		sc2.water();
	}

}
