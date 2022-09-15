package thread.heap.sync02;	// 필요한 부분에만 synchronized를 사용하면 실행시간이 길어지지 않음

class Calculator {
	int opCount = 0;	// 연산된 횟수를 저장할 변수
	
	
	// public synchronized int plus(int num1, int num2) {
	public int plus(int num1, int num2) {
		synchronized(this) {opCount++;}	//	동기화가 필요한 부분
		return num1 + num2;
	}
	
	public int minus(int num1, int num2) {
		synchronized(this) {opCount++;}	//	동기화가 필요한 부분
		return num1 - num2;
	}
	
	public void showOpCount() {
		System.out.println("총 연산 횟수 : " + opCount);
	}
}

class PlusThread extends Thread {
	Calculator cal;
	
	public PlusThread(Calculator cal) {
		this.cal = cal;
	}
	
	public void run() {
		System.out.println("1 + 2 = " + cal.plus(1, 2));
		System.out.println("2 + 4 = " + cal.plus(2, 4));
	}
}

class MinusThread extends Thread {
	Calculator cal;
	
	public MinusThread(Calculator cal) {
		this.cal = cal;
	}
	
	public void run() {
		System.out.println("2 - 1 = " + cal.minus(2, 1));
		System.out.println("4 - 2 = " + cal.minus(4, 2));
	}
}

public class ThreadSyncMethodExam {

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		PlusThread pt = new PlusThread(cal);
		MinusThread mt = new MinusThread(cal);
		
		pt.start(); mt.start();
		try {
			pt.join();
			mt.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		cal.showOpCount();
	}
}
