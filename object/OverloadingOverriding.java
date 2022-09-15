package object;

class Parent {
	void parentMethod() {}
}

class Child extends Parent {	//부모클래스를 상속받아서 부모클래스의 메소드를 그대로 쓰면 오버라이딩
	void parentMethod() {}
	void parentMethod(int i) {}	//매개변수 타입이 다르므로 오버로딩
	
	void childMethod() {}	// 일반 메서드
	void childMethod(int i) {}	// 오버로딩
	//void childMethod() {}	// 중복정의라서 오류
}

public class OverloadingOverriding {

	public static void main(String[] args) {
		

	}

}
