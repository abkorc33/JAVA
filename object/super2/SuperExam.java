package object.super2; //super는 상속받은 부모클래스의 값을 의미함

class Parent {
	int x = 10;
}

class Child extends Parent {
	int x = 20;
	void method() {
		System.out.println("x    => " + x);	// 20
		System.out.println("this.x  => " + this.x);	// 20
		System.out.println("super.x  => " + super.x);	// 10
	}
}

public class SuperExam {

	public static void main(String[] args) {
		Child c = new Child();
		c.method();
	}

}
