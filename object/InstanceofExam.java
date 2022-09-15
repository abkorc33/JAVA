package object;

class Car {}

class Sobangcha extends Car {}

public class InstanceofExam {

	public static void main(String[] args) {
		
		Sobangcha sc = new Sobangcha();
		if(sc instanceof Sobangcha) {
			System.out.println("이것은 소방차 인스턴스입니다.");
		}
		if(sc instanceof Car) {
			System.out.println("이것은 자동차 인스턴스입니다.");
		}
		if(sc instanceof Object) {
			System.out.println("This is and Object instance");
		}

	}

}
