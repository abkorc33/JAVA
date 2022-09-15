package object;

public class MemberCall {
	
			int iv = 10;	// 인스턴스변수
	static 	int cv = 20;	// 클래스 변수
	
			int iv2 = cv;
	// static 	int cv2 = iv; 
	//클래스변수는 인스턴스 변수를 사용할 수 없음. iv는 아직 존재하지 않는다.
	static 	int cv2 = new MemberCall().iv;	//이렇게는 사용 가능하나, 보통 이 방법 안씀.
	//객체를 생성해야지만 클래스변수에 인스턴스 변수를 사용할 수 있다.
	
	static void staticMethod1() {
		System.out.println(cv);
		//System.out.println(iv); 클래스 매서드에서 인스턴스 변수는 사용할 수 없다.
		MemberCall c = new MemberCall();
		System.out.println(c.iv);	// 객체를 생성한 후에 인스턴스 변수를 참조가능하다.
		
	}
	
	void instanceMethod1() {
		System.out.println(cv);	//인스턴스 매서드에서 클래스 변수 사용 가능.
		System.out.println(iv);	//인스턴스 매서드에서 인스턴스 변수 사용 가능.
	}
	
	static void staticMethod2() {
		staticMethod1();
		// instanceMethod1();	클래스 매서드에서는 인스턴스 매서드를 호출할 수 없다.
		MemberCall c = new MemberCall();
		c.instanceMethod1(); 	//인스턴스를 생성한 후에 인스턴스 매서드를 호출 가능.
	}
	
	void instanceMethod2() {
		staticMethod1();
		instanceMethod1();
	}

}