package object.tv4;	// 단일상속 => 하나를 상속받고, 하나는 내용에 포함시켜 버리기

class Tv {	//근간이 되는 개념이 있는 클래스를 상속받음(중요한것)
	boolean power;
	int channel;
	
	void power() {power =! power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}

class VCR {	//부수적인 개념은 포함으로 처리
	boolean power;
	int counter = 0;
	void power() {power =! power;}
	void play() {/*내용 생략*/}
	void stop() {/*내용 생략*/}
	void ff() {/*빨리감기*/}
	void rew() {/*되감기*/}
	void count(int counter) {this.counter = counter;}
}

public class TVCR extends Tv{	// 상속
	VCR vcr = new VCR();	// 포함
	int counter = vcr.counter;
	
	void play() {vcr.play();}
	void stop() {vcr.stop();}
	void ff() {vcr.ff();}
	void rew() {vcr.rew();}

}
