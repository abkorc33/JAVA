package object.binding03;

class Parent {
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	int x = 200;
	void method() {
		System.out.println("x    => " + x);	// 200
		System.out.println("this.x => " + this.x);	// 200
		System.out.println("super.x => " + super.x);	// 100
	}
}

public class Binding03 {

	public static void main(String[] args) {
		
		Parent p = new Child();
		Child c = new Child();
		
		System.out.println("p.x => " + p.x);	// 100
		p.method();	// Child메서드가 호출됨 200,200,100
		
		System.out.println("c.x => " + c.x);	// 200
		c.method();
	}

}
