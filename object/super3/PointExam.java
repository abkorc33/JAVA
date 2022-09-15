package object.super3;

class Point {
	int x;
	int y;
	
	Point() {}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	String getLocation() {
		return "x:" + x + ", y:" + y;
	}
}
// object클래스를 제외한 모든 클래스의 생성자 첫 줄에는
// 생성자(같은 클래스의 다른 생성자 또는 조상의 생성자)를 호출해야한다.
// 그렇지 않으면 컴파일러가 자동적으로 super();를 생성자의 첫 줄에 만들어준다.
class Point3D extends Point {
	int z;
	
	Point3D(int x, int y, int z) {//자손의 생성자의 첫 문장에서 조상의 생성자를 호출해야 한다.
		super();	// 설정한 매개변수를 넣어주거나, 부모클래스에 기본 생성자를 추가해야한다.
		this.x = x;
		this.y = y;
		this.z = z;
	}
	String getLocation() {	//오버라이딩, 부모 클래스의 객체 내용을 바꿔버림
		return "x: " + x + ", y: " + y + ", z: " + z;
	}
}

public class PointExam {

	public static void main(String[] args) {
		Point3D p3 = new Point3D(1,2,3);
		System.out.println(p3.getLocation());

	}

}
