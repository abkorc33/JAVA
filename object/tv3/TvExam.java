package object.tv3;

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
		
		Tv t1 = new Tv();	// t1, t2 같은 데이터 타입이니까 값을 주고받을 수 있음
		Tv t2 = new Tv();	// 변수이고 참조변수이다. 주소값을 가진다.
		System.out.println("t1의 채널 : " + t1.channel);
		System.out.println("t2의 채널 : " + t2.channel);
		
		t2 = t1;	// 둘 다 같은 주소가 되어버린다. t2의 주소값이 t1으로 바뀜 
		t1.channel = 11;	// 하나를 바꿔봤자 둘다 바뀐다. 같은 주소를 갖고있으니까
		// 쓰임이 없어져버린 주소값은 java버츄얼 머신이 폐쇄해버린다.
		
		System.out.println("t1의 채널 : " + t1.channel);
		System.out.println("t2의 채널 : " + t2.channel);

	}

}
