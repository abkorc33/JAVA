package thread.heap.sync01;	// 싱크로나이즈가 돌때는 무조건 하나의 쓰레드만 호출이 가능

class Increment {
	int num = 0;
	// public synchronized void increment() {num++;}	// synchronized제어자를 추가
	// 동기화를 하면 둘 이상의 쓰레드가 동시에 접근을 하지 못해 성능이 떨어진다.
	// 값은 정확히 나오나, 실행속도가 너무 느림
	public void increment() {num++;}
	public int getNum() {return num;}
}

class IncThread extends Thread {
	Increment inc;
	
	public IncThread(Increment inc) {
		this.inc = inc;
	}
	
	public void run() {
		for(int i = 0; i < 10000; i++)
			for(int j = 0; j < 10000; j++)
				inc.increment();
	}
}

public class ThreadSyncErrorExam {

	public static void main(String[] args) {
		Increment inc = new Increment();
		IncThread it1 = new IncThread(inc);
		IncThread it2 = new IncThread(inc);
		IncThread it3 = new IncThread(inc);
		
		it1.start(); it2.start(); it3.start();
		
		try {
			it1.join(); it2.join(); it3.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("합계 : " + inc.getNum());
	}

}
