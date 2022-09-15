package object.tv2;

class Tv {	// 구상만 한 것. 설계도
	// 멤버 변수(요소)
	String color;	// 색깔
	boolean power;	// on/off 스위치
	int channel;	//채널
	
	// 기능
	void power() {power = !power;}	// tv를 켰다 껐다 하는 기능(멤버 변수의 값을 컨트롤)
	void channnelUp() {++channel;}	// 채널을 1 올린다.
	void channelDown() {--channel;}	// 채널을 1 내린다.
	
}

public class TvExam {

	public static void main(String[] args) {
		
		Tv t1 = new Tv();	// 둘이 전혀 다른 개체
		Tv t2 = new Tv();	// 메모리에 별도로 공간이 따로 잡혀있음
		System.out.println("t1의 채널 : " + t1.channel);
		System.out.println("t2의 채널 : " + t2.channel);
		
		t1.channel = 8;
		System.out.println("t1의 채널 : " + t1.channel);
		System.out.println("t2의 채널 : " + t2.channel);

	}

}
