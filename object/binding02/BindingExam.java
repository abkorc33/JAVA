package object.binding02;

class Parent {
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	// 아무것도 없이 상속만 받음
}

public class BindingExam {

	public static void main(String[] args) {
		
		Parent p = new Child();
		Child c = new Child();
		
		System.out.println("p.x => " + p.x);	// 100
		p.method();	// Parent Method
		System.out.println("c.x => " + c.x);	// 100
		c.method();	// Parent Method
		

	}

}
