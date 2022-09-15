package object.super1;

class Parent {
	int x = 10;
}

class Child extends Parent {
	void method() {
		System.out.println("x => " + x);		// 10
		System.out.println("thils.x => " + this.x);	// 10
		System.out.println("super.x => " + super.x);	// 10
	}
}

public class SuperExam {

	public static void main(String[] args) {
		Child c = new Child();
		c.method();

	}

}
