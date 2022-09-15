package thread;

class ShowThread extends Thread  {
	
	String threadName;	// 생성되는 쓰레드에 부여할 이름
	
	public ShowThread(String name) {
		threadName = name;
	}
	
	public void run() {	// 쓰레드에서 클래스의 main()과 같은 역할의 메서드
		for(int i = 0; i < 100; i++) {
			System.out.println("안녕하세요? 저는 " + threadName + "입니다.");
			try {	// sleep은 실행되다가 잠깐 멈추는 것(InterruptedException)
				// InterruptedException은 프로그램을 실행하다가 가로챈다.
				sleep(100);	// 10분의 1초 동안 잠재운다.
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class ThreadUnderstand {

	public static void main(String[] args) {
		
		ShowThread st1 = new ShowThread("멋진 쓰레드");
		ShowThread st2 = new ShowThread("귀여운 쓰레드");
		ShowThread st3 = new ShowThread("예쁜 쓰레드");

		st1.start(); 	// 쓰레드를 구동시킨다 .start();
		st2.start();	// 한번에 st1 , st2, st3가 한번에 100번 나옴
		st3.start();
		
		//st3.run(); 으로 쓰면 st1이 100번 작동한 후에 st2가 100번, st3가 100번 나온다.
		
	}

}
