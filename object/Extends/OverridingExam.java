package object.Extends;

// 부모클래스
class ParentClass {
	int money = 20000000;
	
	public void study() {
		System.out.println("죽어라 공부하자!");
	}
}

class AirPlane {
	int pass = 0;
}

public class OverridingExam extends ParentClass {

	public static void main(String[] args) {
		AirPlane air = new AirPlane();
		System.out.println(air);	//주소값 나옴
		
		ParentClass pc = new ParentClass();
		pc.study();

	}

}