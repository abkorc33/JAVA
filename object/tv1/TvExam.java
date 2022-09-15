package object.tv1;

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
		
		Tv t;	// Tv를 가리키는 참조변수를 선언한다. // 담을 수 있는 방이 생김
		t = new Tv();	// Tv를 생성한다. new붙으면 메모리에 올라감
		
		System.out.println(t.channel);
		
		t.channel = 11;
		System.out.println("현재 채널은 " + t.channel + "번 입니다.");
		
		t.channelDown();	// 메서드 호출, 이 위치에서 일을 시킴
		System.out.println("현재 채널은 " + t.channel + "번 입니다.");

	}

}
