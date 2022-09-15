package object.binding01;

class Parent {
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}
class Child extends Parent {
	int x = 200;
	void method() {
		System.out.println("Child Method");
	}
}
// 메서드의 경우는 참조변수 타입에 상관없이 항상 실제 인스턴스의 타입인 Child클래스에 정의된 메서드가 호출된다
// 인스턴스 변수의 경우 참조변수의 타입에 따라서 달라진다.
public class BindingExam {

	public static void main(String[] args) {
		
		Parent 	p = new Child();	//메소드를 child껄로 만들어서
		Child	c = new Child();	//Child Method 둘 다 이걸로 나옴
		
		System.out.println("p.x =>" + p.x);	// 100 해당 클래스에 설정된 값으로 나옴
		p.method();
		System.out.println("c.x =>" + c.x);	// 200
		c.method();
	}

}
