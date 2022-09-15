package object.Extends;

class Tv {
	boolean power;	// 전원 상태
	int channel;	// 채널
	
	void power() {	power =! power;	}
	void channelUp() {	++channel;	}
	void channelDown() { --channel;	}
}

class CaptionTv extends Tv {	// 상속받아서 기능추가만 해줌
	
	boolean caption;	//자막버튼
	
	void displayCation(String text) {
		if(caption) {	// 캡션상태(on == true)에서만 자막(text)을 보여준다.
			System.out.println(text);
		}
	}
}

public class CaptionTvExam {

	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;	// 조상 클래스로부터 상속받은 멤버
		ctv.channelUp();    // 조상 클래스로부터 상속받은 멤버

		System.out.println("현재 채널 : " + ctv.channel );
		
		ctv.displayCation("안녕하세요? 자막방송을 시작합니다.");
		ctv.caption = true;	// 캡션 기능을 켠다(참으로 바꿈)
		ctv.displayCation("자막기능을 켰습니다.");
	}

}