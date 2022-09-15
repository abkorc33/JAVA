package thread;

class Sum {
	int num;
	public Sum() {num = 0;}
	public void addNum(int n) {num += n;}
	public int getNum() {return num;}
}

// Runnable은 인터페이스를 상속해서 쓰레드를 만든다
class AdderThread extends Sum implements Runnable {
	int start, end;
	
	public AdderThread(int s, int e) {
		start = s;
		end = e;
	}
	
	@Override
	public void run() {
		for(int i = start; i <= end; i++) {
			addNum(i);
		}
	}	
	
}

public class RunnableThread {

	public static void main(String[] args) {
		
		AdderThread at1 = new AdderThread(1, 100);
		AdderThread at2 = new AdderThread(101, 200);
		Thread tr1 = new Thread(at1);	// 이 코드가 있어야 쓰레드가 완성이 된다.
		Thread tr2 = new Thread(at2);
		tr1.start();
		tr2.start();
		
		try {
			// join(); 해당 쓰레드가 종료될 때까지 실행을 멈출 때 호출하는 메서드
			// tr1과 tr2가 참조하는 쓰레드가 종료되어야 아래의 합계를 출력하는 문장이 실행된다.
			tr1.join();	
			tr2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1 ~ 200까지의 합 : " + (at1.getNum() + at2.getNum()));
	}

}
