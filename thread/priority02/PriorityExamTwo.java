package thread.priority02;	// 쓰레드 우선순위를 직접 정함

class MessageSendingThread extends Thread {
	String message;
	
	public MessageSendingThread(String str, int prio) {
		message = str;
		setPriority(prio);	// 우선순위 생성 가능
	}
	
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println(message + "[" + getPriority() + "]");
		}
	}
}

public class PriorityExamTwo {

	public static void main(String[] args) {
		// Thread.MAX_PRIORITY 최상위 쓰레드를 의미함, 정수로 쓸 수도 있음
		// 우선순위가 높은 애들이 일을 더 많이한다. 그 사이에 하위 순위를 적절히 분배해서 넣음 자바가
		MessageSendingThread tr1 = new MessageSendingThread("First", Thread.MAX_PRIORITY);
		MessageSendingThread tr2 = new MessageSendingThread("Second", Thread.NORM_PRIORITY);
		MessageSendingThread tr3 = new MessageSendingThread("Third", Thread.MIN_PRIORITY);
		
		tr1.start();
		tr2.start();
		tr3.start();

	}

}
